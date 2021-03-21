package com.logAnalyzer.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.logAnalyzer.async.receiver.LogFileReceiver;
import com.logAnalyzer.constant.FilePropertiesConstants;
import com.logAnalyzer.model.Log;
import com.logAnalyzer.model.Notification;
import com.logAnalyzer.pagination.DataTableRequest;
import com.logAnalyzer.pagination.DataTableResults;
import com.logAnalyzer.service.LogApplicationService;

@RestController
public class AnalysisController {

	@Autowired
	public LogApplicationService logApplicationService;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	
	//upload file in chunks
	@RequestMapping(value = "/upload",method = { RequestMethod.POST })
	public Object upload(@RequestParam String name,@RequestParam MultipartFile file,@RequestParam(required=false, defaultValue="-1") int chunks,
            @RequestParam(required=false, defaultValue="-1") int chunk,HttpServletRequest request) throws IOException{
		
		//no chunks present
        if(chunks == -1 && chunk == -1) {
        	try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + file.getOriginalFilename() + "!";
            } catch (Exception e) {
                return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
            }
        } else {
        	Path source = Paths.get(env.getProperty(FilePropertiesConstants.FILE_UPLOAD_PATH),name);
        	
        	//first chunk
        	if(chunk==0 && chunks>=0) {
        		Files.deleteIfExists(source);
        		Files.createFile(source);
        	} 
        	//other chunks
        	else if( chunks > 0 && chunk > 0) {
        		Files.write(source, file.getBytes(), StandardOpenOption.APPEND);
        	}
        	
        	//last chunk received
        	if(chunk == chunks-1) {
        		Files.write(source, file.getBytes(), StandardOpenOption.APPEND);
        		jmsTemplate.convertAndSend("logFileQueue",name);
        	}
        }
		

		return "success";
	}

	
	//get log entries
	@RequestMapping(value="/logs/paginated", method=RequestMethod.GET)
	@ResponseBody
	public String listUsersPaginated(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		
		DataTableRequest<Log> dataTableInRQ = new DataTableRequest<Log>(request);
		DataTableResults<Log> dataTableResult = logApplicationService.getAllLogs(dataTableInRQ);
		
		
		return new Gson().toJson(dataTableResult);
	}
	
	
	//get notification entries
	@RequestMapping(value="/notifications/paginated", method=RequestMethod.GET)
	@ResponseBody
	public String listNotificationsPaginated(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		
		DataTableRequest<Notification> dataTableInRQ = new DataTableRequest<Notification>(request);
		DataTableResults<Notification> dataTableResult = logApplicationService.getAllNotifications(dataTableInRQ);
		
		
		return new Gson().toJson(dataTableResult);
	}
}
