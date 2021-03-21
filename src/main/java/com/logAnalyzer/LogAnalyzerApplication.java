package com.logAnalyzer;

import java.io.StringWriter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class LogAnalyzerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogAnalyzerApplication.class, args);
	}
	
	
	@Bean
	public StringWriter getStringWriter() {
		return new StringWriter();
	}
}
