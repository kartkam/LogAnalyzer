package com.logAnalyzer.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

public class LogRowMapper implements RowMapper<Log> {

    @Override
    public Log mapRow(ResultSet rs, int rowNum) throws SQLException {
        Log log = new Log();
        log.setGeneratedAt(new Date(rs.getTimestamp("generated_at").getTime()));
        log.setIpAddress(rs.getString("ip_address"));
        log.setUserAgent(rs.getString("user_agent"));
        log.setStatusCode(rs.getString("status_code"));
        log.setRequestType(rs.getString("request_type"));
        log.setApi(rs.getString("api"));
        log.setUserName(rs.getString("user_name"));
        log.setUserLogin(rs.getString("user_login"));
        log.setEnterpriseId(rs.getString("enterprise_id"));
        log.setEnterpriseName(rs.getString("enterprise_name"));
        log.setTotalRecords(rs.getInt("total_records"));
        log.setLogString(rs.getString("log_string"));
        return log;
    }
    
}
