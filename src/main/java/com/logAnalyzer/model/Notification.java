package com.logAnalyzer.model;

import java.util.Date;

public class Notification {

	private Long notificationId;
	
	private String fileName;
	private String messageType;
	private String messageString;
	private Date dateTimeOfOccurrence;
	
	private Integer totalRecords;
	
	public Integer getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}
	
	
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getMessageString() {
		return messageString;
	}
	public void setMessageString(String messageString) {
		this.messageString = messageString;
	}
	public Long getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Date getDateTimeOfOccurrence() {
		return dateTimeOfOccurrence;
	}
	public void setDateTimeOfOccurrence(Date dateTimeOfOccurrence) {
		this.dateTimeOfOccurrence = dateTimeOfOccurrence;
	}
	
	
	
	
	
}
