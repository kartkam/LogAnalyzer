package com.logAnalyzer.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

public class NotificationRowMapper implements RowMapper<Notification> {

	 @Override
    public Notification mapRow(ResultSet rs, int rowNum) throws SQLException {
    	Notification notification = new Notification();
    	notification.setDateTimeOfOccurrence(new Date(rs.getTimestamp("date_time_of_occurrence").getTime()));
    	notification.setFileName(rs.getString("file_name"));
    	notification.setMessageString(rs.getString("message_string"));
    	notification.setMessageType(rs.getString("message_type"));
    	notification.setTotalRecords(rs.getInt("total_records"));
        return notification;
    }
	
	
}
