$(document).ready(function(){
	
	//show only home module initially
	$(".module").hide();
	$(".home").show();
	
	//if header menu link is clicked, show that particular module
	$(".headerMenuLinks li").click(function(){
		moduleClass = $(this).attr("showComponent");
		$(".module").hide();
		$("."+moduleClass).show();
		
		if(moduleClass == "viewLogs"){
			logsTable.draw();
		} else if(moduleClass = "viewNotifications"){
			notificationsTable.draw();
		}
		
	});
	
	
	
});



