-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 21, 2019 at 01:30 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `log_analyzer_db`
--
CREATE DATABASE `log_analyzer_db`;

-- --------------------------------------------------------

--
-- Table structure for table `log`
--

CREATE TABLE `log_analyzer_db`.`log` (
  `log_id` bigint(20) NOT NULL,
  `api` varchar(255) DEFAULT NULL,
  `enterprise_id` varchar(255) DEFAULT NULL,
  `enterprise_name` varchar(255) DEFAULT NULL,
  `generated_at` datetime(6) DEFAULT NULL,
  `ip_address` varchar(255) DEFAULT NULL,
  `request_type` varchar(255) DEFAULT NULL,
  `status_code` varchar(255) DEFAULT NULL,
  `user_agent` varchar(255) DEFAULT NULL,
  `user_login` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `log_string` varchar(5000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `log`
--

INSERT INTO `log_analyzer_db`.`log` (`log_id`, `api`, `enterprise_id`, `enterprise_name`, `generated_at`, `ip_address`, `request_type`, `status_code`, `user_agent`, `user_login`, `user_name`, `log_string`) VALUES
(187, '/v2/google', '2', 'Enterprise-5', '2018-09-18 04:12:39.000000', '157.49.142.133', 'GET', '607', 'Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko', 'twe@googlwo.com', 'googly', '2018-09-18 04:12:39,842 ERROR (default task-21) IP-Address=157.49.142.133#,!User-Agent=Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko#,!X-Request-From=UIX#,!Request-Type=GET#,!API=/v2/google#,!User-Login=twe@googlwo.com#,!User-Name=googly#,!EnterpriseId=2#,!EnterpriseName=Enterprise-5#,!Auth-Status=#,!Status-Code=607#,!Response-Time=1240#,!Request-Body= '),
(188, '/v2/facebook', '2', 'Enterprise-2', '2018-09-18 12:49:41.000000', '157.49.01.133', 'PUT', '200', 'drop table log;', 'hack@gmail.com', 'hacker', '2018-09-18 12:49:41,946 ERROR (default task-127) IP-Address=157.49.01.133#,!User-Agent=drop table log;#,!X-Request-From=UIX#,!Request-Type=PUT#,!API=/v2/facebook#,!User-Login=hack@gmail.com#,!User-Name=hacker#,!EnterpriseId=2#,!EnterpriseName=Enterprise-2#,!Auth-Status=#,!Status-Code=200#,!Response-Time=1117#,!Request-Body='),
(189, '/we/whatsapp', '2', 'Enterprise-4', '2018-09-18 19:43:41.000000', '134.49.141.133', 'POST', '400', 'Internet Exploreer like Gecko', 'test@demo.com', 'testUser', '2018-09-18 19:43:41,946 ERROR (default task-127) IP-Address=134.49.141.133#,!User-Agent=Internet Exploreer like Gecko#,!X-Request-From=UIX#,!Request-Type=POST#,!API=/we/whatsapp#,!User-Login=test@demo.com#,!User-Name=testUser#,!EnterpriseId=2#,!EnterpriseName=Enterprise-4#,!Auth-Status=#,!Status-Code=400#,!Response-Time=1117#,!Request-Body='),
(190, '/v2/qc/back', '2', 'Enterprise-2', '2018-09-18 23:49:41.000000', '192.49.41.133', 'DELETE', '503', 'Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko', 'test@is.com', 'isour', '2018-09-18 23:49:41,946 ERROR (default task-127) IP-Address=192.49.41.133#,!User-Agent=Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko#,!X-Request-From=UIX#,!Request-Type=DELETE#,!API=/v2/qc/back#,!User-Login=test@is.com#,!User-Name=isour#,!EnterpriseId=2#,!EnterpriseName=Enterprise-2#,!Auth-Status=#,!Status-Code=503#,!Response-Time=1117#,!Request-Body='),
(191, '/v2/developers/ui', '2', 'Enterprise-3', '2018-09-19 06:19:41.000000', '17.49.168.133', 'GET', '500', 'Chrome like Gecko', 'tarun@demo.com', 'tarunUser', '2018-09-19 06:19:41,946 ERROR (default task-127) IP-Address=17.49.168.133#,!User-Agent=Chrome like Gecko#,!X-Request-From=UIX#,!Request-Type=GET#,!API=/v2/developers/ui#,!User-Login=tarun@demo.com#,!User-Name=tarunUser#,!EnterpriseId=2#,!EnterpriseName=Enterprise-3#,!Auth-Status=#,!Status-Code=500#,!Response-Time=1117#,!Request-Body='),
(192, '/v2/developers', '2', 'Enterprise-2', '2018-09-19 11:49:41.000000', '157.49.141.135', 'PUT', '200', 'Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko', 'test@demo.com', 'testUser', '2018-09-19 11:49:41,946 ERROR (default task-127) IP-Address=157.49.141.135#,!User-Agent=Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko#,!X-Request-From=UIX#,!Request-Type=PUT#,!API=/v2/developers#,!User-Login=test@demo.com#,!User-Name=testUser#,!EnterpriseId=2#,!EnterpriseName=Enterprise-2#,!Auth-Status=#,!Status-Code=200#,!Response-Time=1117#,!Request-Body='),
(193, '/v2/developers', '2', 'Enterprise-2', '2018-09-19 14:51:41.000000', '157.49.141.136', 'POST', '200', 'Chrome like Gecko', 'test@demo.com', 'testUser', '2018-09-19 14:51:41,946 ERROR (default task-127) IP-Address=157.49.141.136#,!User-Agent=Chrome like Gecko#,!X-Request-From=UIX#,!Request-Type=POST#,!API=/v2/developers#,!User-Login=test@demo.com#,!User-Name=testUser#,!EnterpriseId=2#,!EnterpriseName=Enterprise-2#,!Auth-Status=#,!Status-Code=200#,!Response-Time=1117#,!Request-Body='),
(194, 'NA', 'NA', 'NA', '2018-09-20 03:12:39.000000', 'NA', 'NA', 'NA', 'NA', 'NA', 'NA', '2018-09-20 03:12:39,842 ERROR Exception in thread "main" java.lang.ArithmeticException: / by zero'),
(195, '/v2/developers', '2', 'Enterprise-2', '2018-09-19 18:58:41.000000', '157.49.141.137', 'DELETE', '200', 'Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko', 'test@demo.com', 'testUser', '2018-09-19 18:58:41,949 ERROR (default task-127) IP-Address=157.49.141.137#,!User-Agent=Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko#,!X-Request-From=UIX#,!Request-Type=DELETE#,!API=/v2/developers#,!User-Login=test@demo.com#,!User-Name=testUser#,!EnterpriseId=2#,!EnterpriseName=Enterprise-2#,!Auth-Status=#,!Status-Code=200#,!Response-Time=1117#,!Request-Body='),
(196, '/v2/google', '2', 'Enterprise-5', '2018-09-19 23:12:39.000000', '157.49.142.133', 'GET', '607', 'Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko', 'twe@googlwo.com', 'googly', '2018-09-19 23:12:39,842 ERROR (default task-21) IP-Address=157.49.142.133#,!User-Agent=Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko#,!X-Request-From=UIX#,!Request-Type=GET#,!API=/v2/google#,!User-Login=twe@googlwo.com#,!User-Name=googly#,!EnterpriseId=2#,!EnterpriseName=Enterprise-5#,!Auth-Status=#,!Status-Code=607#,!Response-Time=1240#,!Request-Body= '),
(197, 'NA', 'NA', 'NA', '2018-09-20 03:12:39.000000', 'NA', 'NA', 'NA', 'NA', 'NA', 'NA', '2018-09-20 03:12:39,842 ERROR Exception in thread "main" java.lang.ArithmeticException: / by zero'),
(198, '/v2/facebook', '2', 'Enterprise-2', '2018-09-20 03:49:41.000000', '157.49.01.133', 'PUT', '200', 'drop table log;', 'hack@gmail.com', 'hacker', '2018-09-20 03:49:41,946 ERROR (default task-127) IP-Address=157.49.01.133#,!User-Agent=drop table log;#,!X-Request-From=UIX#,!Request-Type=PUT#,!API=/v2/facebook#,!User-Login=hack@gmail.com#,!User-Name=hacker#,!EnterpriseId=2#,!EnterpriseName=Enterprise-2#,!Auth-Status=#,!Status-Code=200#,!Response-Time=1117#,!Request-Body='),
(199, 'NA', 'NA', 'NA', '2018-10-20 16:12:39.000000', 'NA', 'NA', 'NA', 'NA', 'NA', 'NA', '2018-10-20 16:12:39,842 ERROR Exception in thread "main" java.lang.ArithmeticException: / by zero'),
(200, '/we/whatsapp', '2', 'Enterprise-4', '2018-10-24 07:43:41.000000', '134.49.141.133', 'POST', '400', 'Internet Exploreer like Gecko', 'test@demo.com', 'testUser', '2018-10-24 07:43:41,946 ERROR (default task-127) IP-Address=134.49.141.133#,!User-Agent=Internet Exploreer like Gecko#,!X-Request-From=UIX#,!Request-Type=POST#,!API=/we/whatsapp#,!User-Login=test@demo.com#,!User-Name=testUser#,!EnterpriseId=2#,!EnterpriseName=Enterprise-4#,!Auth-Status=#,!Status-Code=400#,!Response-Time=1117#,!Request-Body='),
(201, '/v2/qc/back', '2', 'Enterprise-2', '2018-10-24 13:49:41.000000', '192.49.41.133', 'DELETE', '503', 'Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko', 'test@is.com', 'isour', '2018-10-24 13:49:41,946 ERROR (default task-127) IP-Address=192.49.41.133#,!User-Agent=Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko#,!X-Request-From=UIX#,!Request-Type=DELETE#,!API=/v2/qc/back#,!User-Login=test@is.com#,!User-Name=isour#,!EnterpriseId=2#,!EnterpriseName=Enterprise-2#,!Auth-Status=#,!Status-Code=503#,!Response-Time=1117#,!Request-Body='),
(202, '/v2/developers/ui', '2', 'Enterprise-3', '2018-10-25 06:19:41.000000', '17.49.168.133', 'GET', '500', 'Chrome like Gecko', 'tarun@demo.com', 'tarunUser', '2018-10-25 06:19:41,946 ERROR (default task-127) IP-Address=17.49.168.133#,!User-Agent=Chrome like Gecko#,!X-Request-From=UIX#,!Request-Type=GET#,!API=/v2/developers/ui#,!User-Login=tarun@demo.com#,!User-Name=tarunUser#,!EnterpriseId=2#,!EnterpriseName=Enterprise-3#,!Auth-Status=#,!Status-Code=500#,!Response-Time=1117#,!Request-Body='),
(203, 'NA', 'NA', 'NA', '2018-09-20 03:12:39.000000', 'NA', 'NA', 'NA', 'NA', 'NA', 'NA', '2018-09-20 03:12:39,842 ERROR Exception in thread "main" java.lang.ArithmeticException: / by zero'),
(204, '/v2/developers', '2', 'Enterprise-2', '2018-10-26 04:49:41.000000', '157.49.141.135', 'PUT', '200', 'Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko', 'test@demo.com', 'testUser', '2018-10-26 04:49:41,946 ERROR (default task-127) IP-Address=157.49.141.135#,!User-Agent=Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko#,!X-Request-From=UIX#,!Request-Type=PUT#,!API=/v2/developers#,!User-Login=test@demo.com#,!User-Name=testUser#,!EnterpriseId=2#,!EnterpriseName=Enterprise-2#,!Auth-Status=#,!Status-Code=200#,!Response-Time=1117#,!Request-Body='),
(205, '/v2/developers', '2', 'Enterprise-2', '2018-10-26 15:49:41.000000', '157.49.141.136', 'POST', '200', 'Chrome like Gecko', 'test@demo.com', 'testUser', '2018-10-26 15:49:41,946 ERROR (default task-127) IP-Address=157.49.141.136#,!User-Agent=Chrome like Gecko#,!X-Request-From=UIX#,!Request-Type=POST#,!API=/v2/developers#,!User-Login=test@demo.com#,!User-Name=testUser#,!EnterpriseId=2#,!EnterpriseName=Enterprise-2#,!Auth-Status=#,!Status-Code=200#,!Response-Time=1117#,!Request-Body='),
(206, '/v2/developers', '2', 'Enterprise-2', '2018-10-27 00:58:41.000000', '157.49.141.137', 'DELETE', '200', 'Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko', 'test@demo.com', 'testUser', '2018-10-27 00:58:41,949 ERROR (default task-127) IP-Address=157.49.141.137#,!User-Agent=Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko#,!X-Request-From=UIX#,!Request-Type=DELETE#,!API=/v2/developers#,!User-Login=test@demo.com#,!User-Name=testUser#,!EnterpriseId=2#,!EnterpriseName=Enterprise-2#,!Auth-Status=#,!Status-Code=200#,!Response-Time=1117#,!Request-Body=');

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE `log_analyzer_db`.`notification` (
  `notification_id` bigint(20) NOT NULL,
  `date_time_of_occurrence` datetime(6) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `message_string` varchar(255) DEFAULT NULL,
  `message_type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notification`
--

INSERT INTO `log_analyzer_db`.`notification` (`notification_id`, `date_time_of_occurrence`, `file_name`, `message_string`, `message_type`) VALUES
(23, '2019-06-21 17:00:30.000000', 'sample_input_file.txt', 'File upload successful', 'SUCCESS');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `log`
--
ALTER TABLE `log_analyzer_db`.`log`
  ADD PRIMARY KEY (`log_id`);

--
-- Indexes for table `notification`
--
ALTER TABLE `log_analyzer_db`.`notification`
  ADD PRIMARY KEY (`notification_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `log`
--
ALTER TABLE `log_analyzer_db`.`log`
  MODIFY `log_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=207;
--
-- AUTO_INCREMENT for table `notification`
--
ALTER TABLE `log_analyzer_db`.`notification`
  MODIFY `notification_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


COMMIT;