package com.logAnalyzer.dao;

import java.util.List;

import com.logAnalyzer.model.Log;
import com.logAnalyzer.model.Notification;
import com.logAnalyzer.pagination.DataTableRequest;

public interface LogApplicationDao {

	List<Log> getAllLogs(DataTableRequest<Log> dataTableInRQ);
	
	
	public void saveLogEntries(List<Log> logs);
	
	
	public List<Notification> getAllNotifications(DataTableRequest<Notification> dataTableInRQ);


	public Notification saveNotification(Notification notification);

	
}
