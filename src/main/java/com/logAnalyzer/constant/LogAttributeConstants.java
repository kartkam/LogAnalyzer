package com.logAnalyzer.constant;

public class LogAttributeConstants {

	//regex
	public static String TIMESTAMP_REGEX	=	"[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1]) (2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9],\\d{3}";
	public static String IP_ADDRESS_REGEX	=	"(IP-Address)=(.+?)(?=#,!)";
	public static String USER_AGENT_REGEX	=	"(User-Agent)=(.+?)(?=#,!)";
	public static String STATUS_CODE_REGEX	=	"(Status-Code)=(.+?)(?=#,!)";
	public static String REQUEST_TYPE_REGEX	=	"(Request-Type)=(.+?)(?=#,!)";
	public static String API_REGEX			=	"(API)=(.+?)(?=#,!)";
	public static String USER_LOGIN_REGEX	=	"(User-Login)=(.+?)(?=#,!)";
	public static String USER_NAME_REGEX	=	"(User-Name)=(.+?)(?=#,!)";
	public static String ENTERPRISE_ID_REGEX=	"(EnterpriseId)=(.+?)(?=#,!)";
	public static String ENTERPRISE_NAME_REGEX	=	"(EnterpriseName)=(.+?)(?=#,!)";
	
	//date formats
	public static String TIMESTAMP_FORMAT	= 	"yyyy-MM-dd HH:mm:ss,SS";
	
	public static String NOT_AVAILABLE		=	"NA";
	
}
