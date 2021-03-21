package com.logAnalyzer.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.logAnalyzer.constant.LogAttributeConstants;
import com.logAnalyzer.enums.MessageType;
import com.logAnalyzer.model.Log;
import com.logAnalyzer.model.Notification;

public class LogUtils {

	private static final Logger logger = LogManager.getLogger(LogUtils.class);
	
	public static Notification convertLogStringEntryToLogEntity(String input,List<Log> logsList, Notification notification) {
		
		try {
			
			Log logEntry = null;
			
			//extract timestamp
			Pattern pattern = Pattern.compile(LogAttributeConstants.TIMESTAMP_REGEX);
			Matcher matcher	= pattern.matcher(input);
			String logTimestamp = null;
			
			//if timestamp is found, then log entry is valid
			if(matcher.find()) {
				
				logEntry = new Log();
				
				logTimestamp = matcher.group();
				
				Date logDate = null;
				if(logTimestamp != null) {
					SimpleDateFormat format=new SimpleDateFormat(LogAttributeConstants.TIMESTAMP_FORMAT);
					logDate=format.parse(logTimestamp);
				}
				logEntry.setGeneratedAt(logDate);
				
				//extract Ip address
				pattern = Pattern.compile(LogAttributeConstants.IP_ADDRESS_REGEX);
				matcher	= pattern.matcher(input);
				String ipAddress = LogAttributeConstants.NOT_AVAILABLE;
				if(matcher.find()) {
					ipAddress = matcher.group(2);
				} 
				logEntry.setIpAddress(ipAddress);
				
				//extract User agent
				pattern = Pattern.compile(LogAttributeConstants.USER_AGENT_REGEX);
				matcher	= pattern.matcher(input);
				String userAgent = LogAttributeConstants.NOT_AVAILABLE;
				if(matcher.find()) {
					userAgent = matcher.group(2);
				} 
				logEntry.setUserAgent(userAgent);
				
				//extract Status code
				pattern = Pattern.compile(LogAttributeConstants.STATUS_CODE_REGEX);
				matcher	= pattern.matcher(input);
				String statusCode = LogAttributeConstants.NOT_AVAILABLE;
				if(matcher.find()) {
					statusCode = matcher.group(2);
				} 
				logEntry.setStatusCode(statusCode);
				
				//extract request type
				pattern = Pattern.compile(LogAttributeConstants.REQUEST_TYPE_REGEX);
				matcher	= pattern.matcher(input);
				String requestType = LogAttributeConstants.NOT_AVAILABLE;
				if(matcher.find()) {
					requestType = matcher.group(2);
				} 
				logEntry.setRequestType(requestType);
				
				//extract api
				pattern = Pattern.compile(LogAttributeConstants.API_REGEX);
				matcher	= pattern.matcher(input);
				String api = LogAttributeConstants.NOT_AVAILABLE;
				if(matcher.find()) {
					api = matcher.group(2);
				} 
				logEntry.setApi(api);
				
				//extract user name
				pattern = Pattern.compile(LogAttributeConstants.USER_NAME_REGEX);
				matcher	= pattern.matcher(input);
				String userName = LogAttributeConstants.NOT_AVAILABLE;
				if(matcher.find()) {
					userName = matcher.group(2);
				} 
				logEntry.setUserName(userName);
				
				//extract user login
				pattern = Pattern.compile(LogAttributeConstants.USER_LOGIN_REGEX);
				matcher	= pattern.matcher(input);
				String userLogin = LogAttributeConstants.NOT_AVAILABLE;
				if(matcher.find()) {
					userLogin = matcher.group(2);
				} 
				logEntry.setUserLogin(userLogin);
				
				//extract Enterprise id
				pattern = Pattern.compile(LogAttributeConstants.ENTERPRISE_ID_REGEX);
				matcher	= pattern.matcher(input);
				String enterpriseId = LogAttributeConstants.NOT_AVAILABLE;
				if(matcher.find()) {
					enterpriseId = matcher.group(2);
				} 
				logEntry.setEnterpriseId(enterpriseId);
				
				//extract Enterprise id
				pattern = Pattern.compile(LogAttributeConstants.ENTERPRISE_NAME_REGEX);
				matcher	= pattern.matcher(input);
				String enterpriseName = LogAttributeConstants.NOT_AVAILABLE;
				if(matcher.find()) {
					enterpriseName = matcher.group(2);
				} 
				logEntry.setEnterpriseName(enterpriseName);
				
				//adding entire log string
				logEntry.setLogString(input);
				
				//adding log entry to log list
				logsList.add(logEntry);
				
				notification.setMessageType(MessageType.SUCCESS.name());
				
			} /*else {
				notification.setMessageType(MessageType.ERROR.name());
				notification.setMessageString("Invalid Log entry since it doesn't have timestamp.");
			}*/
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
			notification.setMessageType(MessageType.ERROR.name());
			notification.setMessageString("Log file is not present in required format");
		}
		return notification;
	}
	
	
	public static void deleteFileIfExists(Path source) {
		try {
			if(source != null) {
				Files.deleteIfExists(source);
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}
	
}
