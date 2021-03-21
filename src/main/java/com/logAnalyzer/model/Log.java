package com.logAnalyzer.model;

import java.util.Date;

public class Log {

	private Long logId;
	
	private Date generatedAt;
	private String ipAddress;
	private String userAgent;
	private String statusCode;
	private String requestType;
	private String api;
	private String userName;
	private String userLogin;
	private String enterpriseId;
	private String enterpriseName;
	private String logString;
	private Long logFileId;
	private Integer totalRecords;
	
	public Long getLogId() {
		return logId;
	}
	public void setLogId(Long logId) {
		this.logId = logId;
	}
	public Date getGeneratedAt() {
		return generatedAt;
	}
	public void setGeneratedAt(Date generatedAt) {
		this.generatedAt = generatedAt;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public String getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	
	
	public String getLogString() {
		return logString;
	}
	public void setLogString(String logString) {
		this.logString = logString;
	}
	
	
	
	public Long getLogFileId() {
		return logFileId;
	}
	public void setLogFileId(Long logFileId) {
		this.logFileId = logFileId;
	}
	public Integer getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}

	
}
