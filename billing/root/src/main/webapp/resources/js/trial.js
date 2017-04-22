/**
 * 
 */

function setFunction()
{
	//alert(document.getElementById('type').value);
	
	var val=document.getElementById('type').value;
	
	if(val=="1")
		{
		
	//	alert(document.getElementById('type').value);
		//document.write("<script type='text/javascript' src='LegendScript.js'></script>" );
		var js = document.createElement("script");

		js.type = 'text/javascript';
		js.src = 'LegendScript.js';
		document.body.appendChild(js);
		
		/*
		var app=document.createElement("applet");
		app.width="0";
		app.height="0";
		app.archive="BiomAPI.jar";
		app.code="Legend.BiomAPI.class";
		app.id="Obj";
		app.type="MAYSCRIPT";
		document.body.appendChild(app);*/
		
		
		$(document).ready(function(){
			$(".handdiv").prepend('<applet code="Legend.BiomAPI.class" width="0" height="0" MAYSCRIPT archive="BiomAPI.jar" id="Obj"></applet>');
		    $(".10").attr('onclick', 'getFeatureUIDAIData(10)');
		    $(".9").attr('onclick', 'getFeatureUIDAIData(9)');
		    $(".8").attr('onclick', 'getFeatureUIDAIData(8)');
		    $(".7").attr('onclick', 'getFeatureUIDAIData(7)');
		    $(".6").attr('onclick', 'getFeatureUIDAIData(6)');
		    $(".5").attr('onclick', 'getFeatureUIDAIData(5)');
		    $(".4").attr('onclick', 'getFeatureUIDAIData(4)');
		    $(".3").attr('onclick', 'getFeatureUIDAIData(3)');
		    $(".2").attr('onclick', 'getFeatureUIDAIData(2)');
		    $(".1").attr('onclick', 'getFeatureUIDAIData(1)');
		    
		});


		
		
		}
	else
		if(val=="0")
		{
			
			alert("Please Select proper Device type");
			
		}
		else
			{
		
		// alert(document.getElementById('type').value);
		//document.write("<script  type='text/javascript' src='smartchip.js'></script> " );
		var js = document.createElement("script");

		js.type = 'text/javascript';
		js.src = 'smartchip.js';
		document.body.appendChild(js);
		//document.write('<applet width="1" height="1" archive="AuthenticationCapture.jar" code="online.auth.AuthenticationApplet" id="app1" name="app1"> </applet>');
		/*var app=document.createElement("applet");
		app.width="1";
		app.height="1";
		app.archive="AuthenticationCapture.jar";
		app.code="online.auth.AuthenticationApplet";
		app.id="app1";
		app.name="app1";
		document.body.appendChild(app);*/
		
		
		//document.write('<applet width="1" height="1" archive="AuthenticationCapture.jar" code="online.auth.AuthenticationApplet" id="app1" name="app1"> </applet>');
		
		
		
		$(document).ready(function(){
			$(".handdiv").prepend('<applet width="1" height="1" archive="AuthenticationCapture.jar" code="online.auth.AuthenticationApplet" id="app1" name="app1"> </applet>');
		    $(".10").attr('onclick', 'test(10)');
		    $(".9").attr('onclick', 'test(9)');
		    $(".8").attr('onclick', 'test(8)');
		    $(".7").attr('onclick', 'test(7)');
		    $(".6").attr('onclick', 'test(6)');
		    $(".5").attr('onclick', 'test(5)');
		    $(".4").attr('onclick', 'test(4)');
		    $(".3").attr('onclick', 'test(3)');
		    $(".2").attr('onclick', 'test(2)');
		    $(".1").attr('onclick', 'test(1)');
		    
		});
			}

	
	
	
	
}