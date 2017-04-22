/**
 * 
 */

$( document ).ready(function() { 
		
	
	$(".piMatchStrategyPartial").click(function(){
		
		$(".piRange1-100").removeProp( "disabled"); 
	});
	
	
	$(".piMatchStrategyExact").click(function(){
		
		$(".piRange1-100").prop( "disabled",true); 
	});
	
	$(".pfaMatchStrategyPartial").click(function(){
		
		$(".pfaRange1-100").removeProp( "disabled"); 
	});
	
	
	$(".pfaMatchStrategyExact").click(function(){
		
		$(".pfaRange1-100").prop( "disabled",true); 
	});
	
	$(function(){
	    
	    for (i=1;i<=100;i++){
	    	
	    	$(".piRange1-100").append("<option value=\""+i+"\">"+i+"</option>");
	    }
	});
	$(function(){
	    
	    for (i=1;i<=100;i++){
	    	
	    	$(".pfaRange1-100").append("<option value=\""+i+"\">"+i+"</option>");
	    }
	});
	});
