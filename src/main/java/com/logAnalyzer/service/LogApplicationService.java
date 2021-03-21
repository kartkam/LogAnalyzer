package com.logAnalyzer.service;

import java.util.Iterator;

import com.logAnalyzer.model.Log;
import com.logAnalyzer.model.Notification;
import com.logAnalyzer.pagination.DataTableRequest;
import com.logAnalyzer.pagination.DataTableResults;

public interface LogApplicationService {

	DataTableResults<Log> getAllLogs(DataTableRequest<Log> dataTableInRQ);
	
	public void saveLogEntries(Iterator<String> linesIterator, Notification notification) throws Exception;
	
	public DataTableResults<Notification> getAllNotifications(DataTableRequest<Notification> dataTableInRQ);

	public Notification saveNotification(Notification notification);

}
