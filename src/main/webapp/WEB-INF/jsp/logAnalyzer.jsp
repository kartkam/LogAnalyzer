<html lang="en">
	<head>
		<title>Log Analyzer</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	 
	 
	 	<jsp:include page="../components/pluploadImports.jsp" /> 
	  
	  	<jsp:include page="../components/dataTableImports.jsp" />
	  
		
		<style>
			.footer {
			   left: 0;
			   bottom: 0;
			   width: 100%;
			   font-size: 17px;
			   background: #E0E0E0;
			   text-align: center;
			}
		</style>
	  
	</head>
	<body>
		
		<div class="header">
			<jsp:include page="../components/header.jsp" /> 
		</div>
		
		<div class="container-fluid" style="min-height: 620px;">
			
			<div class="home module">
				<jsp:include page="home.jsp" /> 
			</div>
			
			<div class="uploadLogFile module">
				<jsp:include page="uploadLogFile.jsp" /> 
			</div>
			
			<div class="viewLogs module">
				<jsp:include page="viewLogs.jsp" /> 
			</div>
			
			<div class="viewNotifications module">
				<jsp:include page="viewNotifications.jsp" /> 
			</div>
			
			
			
		</div>
		<div class="footer">
			<jsp:include page="../components/footer.jsp" /> 
		</div>
	    
	    <script src="js/logScript.js"></script>
	    
	</body>
</html>