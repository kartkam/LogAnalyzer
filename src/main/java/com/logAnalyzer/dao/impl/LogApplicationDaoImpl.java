package com.logAnalyzer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.logAnalyzer.dao.LogApplicationDao;
import com.logAnalyzer.model.Log;
import com.logAnalyzer.model.LogRowMapper;
import com.logAnalyzer.model.Notification;
import com.logAnalyzer.model.NotificationRowMapper;
import com.logAnalyzer.pagination.DataTableRequest;
import com.logAnalyzer.pagination.PaginationCriteria;
import com.logAnalyzer.util.AppUtil;

@Repository
public class LogApplicationDaoImpl implements LogApplicationDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	private static final Logger logger = LogManager.getLogger(LogApplicationDaoImpl.class);
	
	@Override
	public List<Log> getAllLogs(DataTableRequest<Log> dataTableInRQ) {
		
		PaginationCriteria pagination = dataTableInRQ.getPaginationRequest();
		
		String baseQuery = " SELECT log_id, generated_at, ip_address, "
				+ "user_agent, status_code,"
				+ "request_type, api, user_name,"
				+ "user_login, enterprise_id,"
				+ "enterprise_name, log_string, ( SELECT COUNT(1) FROM LOG #WHERE_CLAUSE# ) as total_records  FROM LOG ";
		
		
		String paginatedQuery = AppUtil.buildPaginatedQuery(baseQuery, pagination);
		
		logger.info(paginatedQuery);
		
		List<Log> logList = jdbcTemplate.query(paginatedQuery, new LogRowMapper());
		
		
		return logList;
	}


	//insert batch example
	public void saveLogEntries(List<Log> logs){
			
	  String sql = "INSERT INTO LOG (GENERATED_AT, IP_ADDRESS, USER_AGENT, STATUS_CODE, REQUEST_TYPE, API, "
		+ "USER_NAME, USER_LOGIN, ENTERPRISE_ID, ENTERPRISE_NAME, LOG_STRING) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
	  jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
				
		@Override
		public void setValues(PreparedStatement ps, int i) throws SQLException {
			Log log = logs.get(i);
			ps.setTimestamp(1,new Timestamp(log.getGeneratedAt().getTime()));
			ps.setString(2, log.getIpAddress());
			ps.setString(3, log.getUserAgent());
			ps.setString(4, log.getStatusCode());
			ps.setString(5, log.getRequestType());
			ps.setString(6, log.getApi());
			ps.setString(7, log.getUserName());
			ps.setString(8, log.getUserLogin());
			ps.setString(9, log.getEnterpriseId());
			ps.setString(10, log.getEnterpriseName());
			ps.setString(11, log.getLogString());
		}
				
		@Override
		public int getBatchSize() {
			return logs.size();
		}
	  });
	}
	

	@Override
	public List<Notification> getAllNotifications(DataTableRequest<Notification> dataTableInRQ) {
		
		PaginationCriteria pagination = dataTableInRQ.getPaginationRequest();
		
		String baseQuery = " SELECT notification_id, date_time_of_occurrence, "
				+ " file_name, message_string, message_type "
				+ " , ( SELECT COUNT(1) FROM NOTIFICATION #WHERE_CLAUSE# ) AS total_records  FROM NOTIFICATION ";
		
		
		String paginatedQuery = AppUtil.buildPaginatedQuery(baseQuery, pagination);
		
		logger.info(paginatedQuery);
		
		List<Notification> notificationList = jdbcTemplate.query(paginatedQuery, new NotificationRowMapper());
		
		return notificationList;
		
	}


	@Override
	public Notification saveNotification(Notification notification){
        final String sql = "INSERT INTO NOTIFICATION (DATE_TIME_OF_OCCURRENCE, FILE_NAME, MESSAGE_STRING, "
        		+ " MESSAGE_TYPE) values(?, ?, ?, ?)";

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setTimestamp(1,new Timestamp(notification.getDateTimeOfOccurrence().getTime()));
                ps.setString(2, notification.getFileName());
                ps.setString(3, notification.getMessageString());
                ps.setString(4, notification.getMessageType());
                return ps;
            }
        });

        return notification;
    }
	
	
	
}

