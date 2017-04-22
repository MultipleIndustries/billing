/**
 * 
 */

function setBiometricFunction()
{
//	alert(document.getElementById('type').value);

	var val=document.getElementById('type').value;

	if(val=="1")
	{

		$('#type').prop('disabled', 'disabled');

		//document.write("<script type='text/javascript' src='LegendScript.js'></script>" );
		var js = document.createElement("script");

		js.type = 'text/javascript';
		js.src = '/aua/resources/js/LegendScript.js';
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


		//$(document).ready(function(){
		$(".handdiv").prepend('<applet code="Legend.BiomAPI.class" width="0" height="0" MAYSCRIPT archive="BiomAPI.jar" id="Obj"></applet>');
		$(".10").on('click',function(){getFeatureUIDAIData(10)});
		$(".9").on('click',function(){getFeatureUIDAIData(9)});
		$(".8").on('click',function(){getFeatureUIDAIData(8)});
		$(".7").on('click',function(){getFeatureUIDAIData(7)});
		$(".6").on('click',function(){getFeatureUIDAIData(6)});
		$(".5").on('click',function(){getFeatureUIDAIData(5)});
		$(".4").on('click',function(){getFeatureUIDAIData(4)});
		$(".3").on('click',function(){getFeatureUIDAIData(3)});
		$(".2").on('click',function(){getFeatureUIDAIData(2)});
		$(".1").on('click',function(){getFeatureUIDAIData(1)});


		//});




	}
	else
		if(val=="0")
		{

			alert("Please Select proper Device type");

		}
		else
			if(val=="2")
			{

				// alert(document.getElementById('type').value);
				//document.write("<script  type='text/javascript' src='smartchip.js'></script> " );

				$('#type').prop('disabled', 'disabled');

				var js = document.createElement("script");

				js.type = 'text/javascript';
				js.src = '/aua/resources/js/smartchip.js';
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
					$(".10").on('click',function(){getBiomFinger(10)});
					$(".9").on('click',function(){getBiomFinger(9)});
					$(".8").on('click',function(){getBiomFinger(8)});
					$(".7").on('click',function(){getBiomFinger(7)});
					$(".6").on('click',function(){getBiomFinger(6)});
					$(".5").on('click',function(){getBiomFinger(5)});
					$(".4").on('click',function(){getBiomFinger(4)});
					$(".3").on('click',function(){getBiomFinger(3)});
					$(".2").on('click',function(){getBiomFinger(2)});
					$(".1").on('click',function(){getBiomFinger(1)});

				});
			}

			else
				if(val=="3")
				{
					$('#type').prop('disabled', 'disabled');

					var js = document.createElement("script");

					js.type = 'text/javascript';
					js.src = '/aua/resources/js/smartchip.js';
					document.body.appendChild(js);

					$(document).ready(function(){
						//		$(".handdiv").prepend('<applet width="1" height="1" archive="AuthenticationCapture.jar" code="online.auth.AuthenticationApplet" id="app1" name="app1"> </applet>');
						$(".10").on('click', function() {captureBiometricFinger(10)});
						$(".9").on('click', function() {captureBiometricFinger(9)});
						$(".8").on('click', function() {captureBiometricFinger(8)});
						$(".7").on('click', function() {captureBiometricFinger(7)});
						$(".6").on('click', function() {captureBiometricFinger(6)});
						$(".5").on('click', function() {captureBiometricFinger(5)});
						$(".4").on('click', function() {captureBiometricFinger(4)});
						$(".3").on('click', function() {captureBiometricFinger(3)});
						$(".2").on('click', function() {captureBiometricFinger(2)});
						$(".1").on('click', function() {captureBiometricFinger(1)});

					});

				}
				else 
					if(val=="4")
					{
						
						$('#type').prop('disabled', 'disabled');

						var js = document.createElement("script");

						js.type = 'text/javascript';
						js.src = '/aua/resources/js/LegendScript_Appletless.js';
						document.body.appendChild(js);
					
						$(document).ready(function() {
							
							var result ;
							var strMessage = "Initialize";
							$.ajax({
								type: "GET",
								url: "http://localhost:62015/MMMCSD200Service/ActionServlet"+"?action=" + strMessage,
								crossDomain: true,
								dataType: 'jsonp',
								jsonp: 'callback',
								jsonpCallback: 'jsonpCallback',
								success: function(jsonObj)
								{
									alert(jsonObj.Message);

									$(".10").on('click',function(){getBiomFingerCogentAL(10)});
									$(".9").on('click',function(){getBiomFingerCogentAL(9)});
									$(".8").on('click',function(){getBiomFingerCogentAL(8)});
									$(".7").on('click',function(){getBiomFingerCogentAL(7)});
									$(".6").on('click',function(){getBiomFingerCogentAL(6)});
									$(".5").on('click',function(){getBiomFingerCogentAL(5)});
									$(".4").on('click',function(){getBiomFingerCogentAL(4)});
									$(".3").on('click',function(){getBiomFingerCogentAL(3)});
									$(".2").on('click',function(){getBiomFingerCogentAL(2)});
									$(".1").on('click',function(){getBiomFingerCogentAL(1)});



								},
								error: function(jqXHR, textStatus, errorThrown)
								{
								}	    
							});
						});	


					}


}




function setBFDFunction()
{
	//alert(document.getElementById('type').value);

	var val=document.getElementById('type').value;
	//alert(document.getElementById('type').value);
	if(val=="1")
	{
		//alert("aaya");
		$('#type').prop('disabled', 'disabled');
		//alert('aaya');
		$( document ).ready(function() { $('#btnFormBFD').show(); });
		//document.write("<script type='text/javascript' src='LegendScript.js'></script>" );
		var js = document.createElement("script");

		js.type = 'text/javascript';
		js.src = '/aua/resources/js/LegendScript.js';
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
			$(".10").on('click',function(){GetFeatureBFDData(10)});
			$(".9").on('click',function(){GetFeatureBFDData(9)});
			$(".8").on('click',function(){GetFeatureBFDData(8)});
			$(".7").on('click',function(){GetFeatureBFDData(7)});
			$(".6").on('click',function(){GetFeatureBFDData(6)});
			$(".5").on('click',function(){GetFeatureBFDData(5)});
			$(".4").on('click',function(){GetFeatureBFDData(4)});
			$(".3").on('click',function(){GetFeatureBFDData(3)});
			$(".2").on('click',function(){GetFeatureBFDData(2)});
			$(".1").on('click',function(){GetFeatureBFDData(1)});

		});




	}
	else
		if(val=="0")
		{

			alert("Please select proper device type");

		}
		else
			if(val=="2")
			{

				$('#type').prop('disabled', 'disabled');
				// alert(document.getElementById('type').value);
				//document.write("<script  type='text/javascript' src='smartchip.js'></script> " );
				var js = document.createElement("script");

				js.type = 'text/javascript';
				js.src = '/aua/resources/js/smartchip.js';
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
					//	alert('aaya');
					$(".10").on('click',function(){getBFDFinger(10)});
					$(".9").on('click',function(){getBFDFinger(9)});
					$(".8").on('click',function(){getBFDFinger(8)});
					$(".7").on('click',function(){getBFDFinger(7)});
					$(".6").on('click',function(){getBFDFinger(6)});
					$(".5").on('click',function(){getBFDFinger(5)});
					$(".4").on('click',function(){getBFDFinger(4)});
					$(".3").on('click',function(){getBFDFinger(3)});
					$(".2").on('click',function(){getBFDFinger(2)});
					$(".1").on('click',function(){getBFDFinger(1)});

				});
			}

			else
				if(val=="3")
				{

					$('#type').prop('disabled', 'disabled');
					// alert(document.getElementById('type').value);
					//document.write("<script  type='text/javascript' src='smartchip.js'></script> " );
					var js = document.createElement("script");

					js.type = 'text/javascript';
					js.src = '/aua/resources/js/smartchip.js';
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
						//$(".handdiv").prepend('<applet width="1" height="1" archive="AuthenticationCapture.jar" code="online.auth.AuthenticationApplet" id="app1" name="app1"> </applet>');
						//	alert('aaya');
						$(".10").on('click',function(){getBFDFingerAL(10)});
						$(".9").on('click',function(){getBFDFingerAL(9)});
						$(".8").on('click',function(){getBFDFingerAL(8)});
						$(".7").on('click',function(){getBFDFingerAL(7)});
						$(".6").on('click',function(){getBFDFingerAL(6)});
						$(".5").on('click',function(){getBFDFingerAL(5)});
						$(".4").on('click',function(){getBFDFingerAL(4)});
						$(".3").on('click',function(){getBFDFingerAL(3)});
						$(".2").on('click',function(){getBFDFingerAL(2)});
						$(".1").on('click',function(){getBFDFingerAL(1)});

					});
				}else 
					if(val=="4")
					{

						$('#type').prop('disabled', 'disabled');

						var js = document.createElement("script");

						js.type = 'text/javascript';
						js.src = '/aua/resources/js/LegendScript_Appletless.js';
						document.body.appendChild(js);

						$(document).ready(function() {
							var result ;
							var strMessage = "Initialize";
							$.ajax({
								type: "GET",
								url: "http://localhost:62015/MMMCSD200Service/ActionServlet"+"?action=" + strMessage,
								crossDomain: true,
								dataType: 'jsonp',
								jsonp: 'callback',
								jsonpCallback: 'jsonpCallback',
								success: function(jsonObj)
								{
									alert(jsonObj.Message);

									$(".10").on('click',function(){captureBFDFingerCogentAL(10)});
									$(".9").on('click',function(){captureBFDFingerCogentAL(9)});
									$(".8").on('click',function(){captureBFDFingerCogentAL(8)});
									$(".7").on('click',function(){captureBFDFingerCogentAL(7)});
									$(".6").on('click',function(){captureBFDFingerCogentAL(6)});
									$(".5").on('click',function(){captureBFDFingerCogentAL(5)});
									$(".4").on('click',function(){captureBFDFingerCogentAL(4)});
									$(".3").on('click',function(){captureBFDFingerCogentAL(3)});
									$(".2").on('click',function(){captureBFDFingerCogentAL(2)});
									$(".1").on('click',function(){captureBFDFingerCogentAL(1)});



								},
								error: function(jqXHR, textStatus, errorThrown)
								{
								}	    
							});
						});	


					}





}




function setTFAFunction()
{
	//alert(document.getElementById('type').value);

	var val=document.getElementById('type').value;

	if(val=="1")
	{
		$('#type').prop('disabled', 'disabled');
		//	alert(document.getElementById('type').value);
		//document.write("<script type='text/javascript' src='LegendScript.js'></script>" );
		var js = document.createElement("script");

		js.type = 'text/javascript';
		js.src = '/aua/resources/js/LegendScript.js';
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
			$(".10").on('click',function(){GetFeatureTFAData(10)});
			$(".9").on('click',function(){GetFeatureTFAData(9)});
			$(".8").on('click',function(){GetFeatureTFAData(8)});
			$(".7").on('click',function(){GetFeatureTFAData(7)});
			$(".6").on('click',function(){GetFeatureTFAData(6)});
			$(".5").on('click',function(){GetFeatureTFAData(5)});
			$(".4").on('click',function(){GetFeatureTFAData(4)});
			$(".3").on('click',function(){GetFeatureTFAData(3)});
			$(".2").on('click',function(){GetFeatureTFAData(2)});
			$(".1").on('click',function(){GetFeatureTFAData(1)});

		});




	}
	else
		if(val=="0")
		{

			alert("Please select proper device type");

		}
		else
			if(val=="2")
			{

				$('#type').prop('disabled', 'disabled');
				// alert(document.getElementById('type').value);
				//document.write("<script  type='text/javascript' src='smartchip.js'></script> " );
				var js = document.createElement("script");

				js.type = 'text/javascript';
				js.src = '/aua/resources/js/smartchip.js';
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
					$(".10").on('click',function(){getTFAFinger(10)});
					$(".9").on('click',function(){getTFAFinger(9)});
					$(".8").on('click',function(){getTFAFinger(8)});
					$(".7").on('click',function(){getTFAFinger(7)});
					$(".6").on('click',function(){getTFAFinger(6)});
					$(".5").on('click',function(){getTFAFinger(5)});
					$(".4").on('click',function(){getTFAFinger(4)});
					$(".3").on('click',function(){getTFAFinger(3)});
					$(".2").on('click',function(){getTFAFinger(2)});
					$(".1").on('click',function(){getTFAFinger(1)});

				});
			}

	//added by Supneet for MORPHO applet less
			else
				if(val=="3")
				{

					$('#type').prop('disabled', 'disabled');
//					alert(document.getElementById('type').value);
//					document.write("<script  type='text/javascript' src='smartchip.js'></script> " );
					var js = document.createElement("script");

					js.type = 'text/javascript';
					js.src = '/aua/resources/js/smartchip.js';
					document.body.appendChild(js);
//					document.write('<applet width="1" height="1" archive="AuthenticationCapture.jar" code="online.auth.AuthenticationApplet" id="app1" name="app1"> </applet>');
					/*var app=document.createElement("applet");
app.width="1";
app.height="1";
app.archive="AuthenticationCapture.jar";
app.code="online.auth.AuthenticationApplet";
app.id="app1";
app.name="app1";
document.body.appendChild(app);*/


//					document.write('<applet width="1" height="1" archive="AuthenticationCapture.jar" code="online.auth.AuthenticationApplet" id="app1" name="app1"> </applet>');



					$(document).ready(function(){
						//$(".handdiv").prepend('<applet width="1" height="1" archive="AuthenticationCapture.jar" code="online.auth.AuthenticationApplet" id="app1" name="app1"> </applet>');
						$(".10").on('click',function(){getTFAFingerAL(10)});
						$(".9").on('click',function(){getTFAFingerAL(9)});
						$(".8").on('click',function(){getTFAFingerAL(8)});
						$(".7").on('click',function(){getTFAFingerAL(7)});
						$(".6").on('click',function(){getTFAFingerAL(6)});
						$(".5").on('click',function(){getTFAFingerAL(5)});
						$(".4").on('click',function(){getTFAFingerAL(4)});
						$(".3").on('click',function(){getTFAFingerAL(3)});
						$(".2").on('click',function(){getTFAFingerAL(2)});
						$(".1").on('click',function(){getTFAFingerAL(1)});

					});
				}else 
					if(val=="4")
					{

						$('#type').prop('disabled', 'disabled');

						var js = document.createElement("script");

						js.type = 'text/javascript';
						js.src = '/aua/resources/js/LegendScript_Appletless.js';
						document.body.appendChild(js);

						$(document).ready(function() {
							var result ;
							var strMessage = "Initialize";
							$.ajax({
								type: "GET",
								url: "http://localhost:62015/MMMCSD200Service/ActionServlet"+"?action=" + strMessage,
								crossDomain: true,
								dataType: 'jsonp',
								jsonp: 'callback',
								jsonpCallback: 'jsonpCallback',
								success: function(jsonObj)
								{
									alert(jsonObj.Message);

									$(".10").on('click',function(){getTFAFingerCogentAL(10)});
									$(".9").on('click',function(){getTFAFingerCogentAL(9)});
									$(".8").on('click',function(){getTFAFingerCogentAL(8)});
									$(".7").on('click',function(){getTFAFingerCogentAL(7)});
									$(".6").on('click',function(){getTFAFingerCogentAL(6)});
									$(".5").on('click',function(){getTFAFingerCogentAL(5)});
									$(".4").on('click',function(){getTFAFingerCogentAL(4)});
									$(".3").on('click',function(){getTFAFingerCogentAL(3)});
									$(".2").on('click',function(){getTFAFingerCogentAL(2)});
									$(".1").on('click',function(){getTFAFingerCogentAL(1)});



								},
								error: function(jqXHR, textStatus, errorThrown)
								{
								}	    
							});
						});	


					}


}
