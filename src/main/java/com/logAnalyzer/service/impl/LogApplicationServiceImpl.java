package com.logAnalyzer.service.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logAnalyzer.constant.FilePropertiesConstants;
import com.logAnalyzer.dao.LogApplicationDao;
import com.logAnalyzer.enums.MessageType;
import com.logAnalyzer.model.Log;
import com.logAnalyzer.model.Notification;
import com.logAnalyzer.pagination.DataTableRequest;
import com.logAnalyzer.pagination.DataTableResults;
import com.logAnalyzer.service.LogApplicationService;
import com.logAnalyzer.util.AppUtil;
import com.logAnalyzer.util.LogUtils;

@Service
public class LogApplicationServiceImpl implements LogApplicationService {

	@Autowired
	LogApplicationDao logApplicationDao;
	
	@Autowired
	StringWriter stringWriter;
	
	private static final Logger logger = LogManager.getLogger(LogApplicationServiceImpl.class);
	
	@Override
	public DataTableResults<Log> getAllLogs(DataTableRequest<Log> dataTableInRQ) {
		
		DataTableResults<Log> dataTableResult = null;
		
		try {
		
			List<Log> logList = logApplicationDao.getAllLogs(dataTableInRQ); 
			
			dataTableResult = new DataTableResults<Log>();
			dataTableResult.setDraw(dataTableInRQ.getDraw());
			dataTableResult.setListOfDataObjects(logList);
			if (!AppUtil.isObjectEmpty(logList)) {
				dataTableResult.setRecordsTotal(logList.get(0).getTotalRecords().toString());
				dataTableResult.setRecordsFiltered(logList.get(0).getTotalRecords().toString());
			}
		} catch(Exception e) {
			e.printStackTrace(new PrintWriter(stringWriter));
			logger.error(stringWriter.toString());
		}
		
		return dataTableResult;
	}


	@Override
	public void saveLogEntries(Iterator<String> linesIterator, Notification notification) throws Exception {
		
		String logEntry = null;
		List<Log> logsList= new ArrayList<>();
		
		logger.info("Started reading file...");
		while(linesIterator.hasNext()) {
			logEntry = linesIterator.next();
			
			notification = LogUtils.convertLogStringEntryToLogEntity(logEntry,logsList,notification);
			
			if(MessageType.ERROR.name().equals(notification.getMessageType())) {
				throw new Exception();
			}
			
			if(FilePropertiesConstants.LOG_BATCH_SIZE.equals(logsList.size())) {
				logger.info("Started to save batch in db...");
				logApplicationDao.saveLogEntries(logsList);
				logsList.clear();
			}
		}
		
		logger.info("Started to save last batch in db...");
		
		if(!logsList.isEmpty()) {
			logApplicationDao.saveLogEntries(logsList);
		}
	}
	

	
	
	@Override
	public DataTableResults<Notification> getAllNotifications(DataTableRequest<Notification> dataTableInRQ) {
		
		DataTableResults<Notification> dataTableResult = null;
		try {
			List<Notification> notificationList = logApplicationDao.getAllNotifications(dataTableInRQ); 
			
			dataTableResult = new DataTableResults<Notification>();
			dataTableResult.setDraw(dataTableInRQ.getDraw());
			dataTableResult.setListOfDataObjects(notificationList);
			if (!AppUtil.isObjectEmpty(notificationList)) {
				dataTableResult.setRecordsTotal(notificationList.get(0).getTotalRecords()
						.toString());
				dataTableResult.setRecordsFiltered(notificationList.get(0).getTotalRecords()
						.toString());
				
			}
		} catch(Exception e) {
			e.printStackTrace(new PrintWriter(stringWriter));
			logger.error(stringWriter.toString());
		}
		
		return dataTableResult;
		
		
		
	}


	@Override
	public Notification saveNotification(Notification notification) {
		try {
			if(notification != null) {
				notification = logApplicationDao.saveNotification(notification);
			}
		}  catch(Exception e) {
			e.printStackTrace(new PrintWriter(stringWriter));
			logger.error(stringWriter.toString());
		}
		return notification;
	}


}
