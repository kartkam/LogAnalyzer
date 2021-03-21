package com.logAnalyzer.async.receiver;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Iterator;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.logAnalyzer.constant.FilePropertiesConstants;
import com.logAnalyzer.enums.MessageType;
import com.logAnalyzer.model.Notification;
import com.logAnalyzer.service.LogApplicationService;
import com.logAnalyzer.util.LogUtils;

@Component
public class LogFileReceiver {

	@Autowired
	LogApplicationService logApplicationService;
	
	@Autowired
	private Environment env;
	
	@Autowired
	StringWriter stringWriter;
	
	private static final Logger logger = LogManager.getLogger(LogFileReceiver.class);
	
	@JmsListener(destination="logFileQueue")
	public void receiveLogFile(String fileName) throws Exception{
		
		BufferedReader br = null;
				
		Stream<String> lines = null;
		Notification notification = null;
		Path source = null;
		
		try {
			source = Paths.get(env.getProperty(FilePropertiesConstants.FILE_UPLOAD_PATH),fileName);
			br = Files.newBufferedReader(source);
			
			//create notification
			notification = new Notification();
			notification.setMessageType(MessageType.SUCCESS.name());
			notification.setMessageString("File upload successful");
			notification.setDateTimeOfOccurrence(new Date());
			notification.setFileName(fileName);
			
			lines = br.lines().parallel();
			Iterator<String> linesIterator = lines.iterator();
			
			logApplicationService.saveLogEntries(linesIterator,notification);
			logger.info("Log entries added in db...");
			
		} catch(Exception e) {
			e.printStackTrace(new PrintWriter(stringWriter));
			logger.error(stringWriter.toString());
		} finally {
			lines.close();
			LogUtils.deleteFileIfExists(source);
			logApplicationService.saveNotification(notification);
			logger.info("Notification added in db...");
		}
		
		
	}
}
