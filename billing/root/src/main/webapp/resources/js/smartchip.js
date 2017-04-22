/**
 * 
 */

//alert("HIII m in SAMRTCHIP");
document.write('<applet width="1" height="1" archive="AuthenticationCapture.jar" code="online.auth.AuthenticationApplet" id="app1" name="app1"> </applet>');





function getBiomFinger(buttonId)

{
	
	alert("Click on finger tip to scan");
	
	var button=buttonId;
		var data;
		var testTag = document.getElementById('app1');
		var val = testTag.captureFinger(buttonId);
		//document.getElementById('finger'+buttonId).value = val;
		
		if(val == "CONNECT_DEVICE_ERROR"){
		alert("Device Not Connected");
		}
		else
		if(val == "LIBRARY_MISSING_ERROR"){
		alert("Setup Not Installed Properly");
		}
		else
		if(val == "CAPTURE_TIMEOUT_ERROR"){
		alert("Device Not Able to Capture Finger Prints. Try Again.");
		}else
		if(val == "DUPLICATE_FINGER_ERROR"){
		alert("Current finger is already captured at some other finger index.");
		}else
		if(val == "INTERNAL_ERROR"){
		alert("Device Internal Error");
		}else{
			
			if(val != null || val.length()!=0 )
				{
			
			document.getElementById('fingerPrint').value = val.substring(2);
			//document.getElementById('fingerNumber').value = buttonId;
			//alert(document.getElementById('type').value);
			//alert(document.getElementById('fingerPrint').value);
			//alert(temp);
			alert("Finger Print Captured");
			
		
			switch(button)
			{
			case 1: $(document).ready(function(){ $("a").attr('onclick', '""'); });
					document.getElementById('fingerPosition').value = "RIGHT_THUMB";
					break;
			case 2: $(document).ready(function(){ $("a").attr('onclick', '""'); });
					document.getElementById('fingerPosition').value = "RIGHT_INDEX";
					break;	
			case 3: $(document).ready(function(){ $("a").attr('onclick', '""'); });
					document.getElementById('fingerPosition').value = "RIGHT_MIDDLE";
					break;
			case 4: $(document).ready(function(){ $("a").attr('onclick', '""'); });
					document.getElementById('fingerPosition').value = "RIGHT_RING";
					break;
			case 5: $(document).ready(function(){ $("a").attr('onclick', '""'); });
					document.getElementById('fingerPosition').value = "RIGHT_LITTLE";
					break;
			case 6: $(document).ready(function(){ $("a").attr('onclick', '""'); });
					document.getElementById('fingerPosition').value = "LEFT_THUMB";
					break;
			case 7: $(document).ready(function(){ $("a").attr('onclick', '""'); });
					document.getElementById('fingerPosition').value = "LEFT_INDEX";
					break;
			case 8: $(document).ready(function(){ $("a").attr('onclick', '""'); });
					document.getElementById('fingerPosition').value = "LEFT_MIDDLE";
					break;
			case 9: $(document).ready(function(){ $("a").attr('onclick', '""'); });
					document.getElementById('fingerPosition').value = "LEFT_RING";
					break;
			case 10:$(document).ready(function(){ $("a").attr('onclick', '""');  });
					document.getElementById('fingerPosition').value = "LEFT_LITTLE";
					break;
			
			
			}
			//alert(document.getElementById('fingerPosition').value);
			
			$( document ).ready(function() { 	
				$(".handdiv ."+button).html("<img src=\"image/check.jpg\"></img>");

				});
				
				}
			else
				{
							alert("Finger print not captured");
				}
			
			
		}
}




//For MORPHO MSO 1300 E2 for biometric

var template;
function captureBiometricFinger(buttonId)

{
	alert("Click on finger tip to scan");
	var fingerindex=buttonId;
	var val;
	var deviceStat;
	var url = "https://localhost:8000/CaptureFingerprint";
	var xmlhttp;
	if (window.XMLHttpRequest)
	{// code for IE7+, Firefox, Chrome, Opera, Safari

		xmlhttp=new XMLHttpRequest();

	}
	else
	{// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");

	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			fpobject = JSON.parse(xmlhttp.responseText);
			//alert("Device Status: "+fpobject.ReturnCode);
			alert("Base64ISOTemplate: "+fpobject.Base64ISOTemplate);
			//alert("Base64RAWIMage: "+fpobject.Base64RAWIMage);
			//alert("Base64BMPIMage: "+fpobject.Base64BMPIMage);
			alert("NFIQ: "+fpobject.NFIQ);
			template = fpobject.Base64ISOTemplate; 	   
			
			deviceStat=fpobject.ReturnCode;

			if(deviceStat == "0")
			{

				document.getElementById('fingerPrint').value = fpobject.Base64ISOTemplate;
				//document.getElementById('res_nfiq').value = fpobject.NFIQ;
				//document.getElementById('fingerNumber').value = buttonId;
				//alert(document.getElementById('type').value);
				//alert(document.getElementById('fingerPrint').value);
				//alert(temp);
				alert("Finger Print Captured");
				


				switch(fingerindex)
				{
				case 1: $(document).ready(function(){ $("a").attr('onclick', '""'); });
				document.getElementById('fingerPosition').value = "RIGHT_THUMB";
				break;
				case 2: $(document).ready(function(){ $("a").attr('onclick', '""'); });
				document.getElementById('fingerPosition').value = "RIGHT_INDEX";
				break;	
				case 3: $(document).ready(function(){ $("a").attr('onclick', '""'); });
				document.getElementById('fingerPosition').value = "RIGHT_MIDDLE";
				break;
				case 4: $(document).ready(function(){ $("a").attr('onclick', '""'); });
				document.getElementById('fingerPosition').value = "RIGHT_RING";
				break;
				case 5: $(document).ready(function(){ $("a").attr('onclick', '""'); });
				document.getElementById('fingerPosition').value = "RIGHT_LITTLE";
				break;
				case 6: $(document).ready(function(){ $("a").attr('onclick', '""'); });
				document.getElementById('fingerPosition').value = "LEFT_THUMB";
				break;
				case 7: $(document).ready(function(){ $("a").attr('onclick', '""'); });
				document.getElementById('fingerPosition').value = "LEFT_INDEX";
				break;
				case 8: $(document).ready(function(){ $("a").attr('onclick', '""'); });
				document.getElementById('fingerPosition').value = "LEFT_MIDDLE";
				break;
				case 9: $(document).ready(function(){ $("a").attr('onclick', '""'); });
				document.getElementById('fingerPosition').value = "LEFT_RING";
				break;
				case 10:$(document).ready(function(){ $("a").attr('onclick', '""');  });
				document.getElementById('fingerPosition').value = "LEFT_LITTLE";
				break;


				}
		
		

				$( document ).ready(function() { 	
					$(".handdiv ."+fingerindex).html("<img src=\"image/check.jpg\"></img>");

				});
				
				//alert("document.getElementById('fingerPrint').value : " + document.getElementById('fingerPrint').value);
				alert("document.getElementById('fingerPosition').value : " + document.getElementById('fingerPosition').value);

			}
		
			else
			{
				alert("Finger print not captured");
			}
		}

		}
	
	var timeout = 5;
	xmlhttp.open("POST",url+"?"+timeout+"$"+fingerindex,true);
	xmlhttp.send();


}








function getBFDFinger(buttonId)

{
	
	alert("Click on finger tip to scan one by one");
	
		var button=buttonId;
		var data;
		var testTag = document.getElementById('app1');
		var val = testTag.captureFinger(buttonId);
		var finger="";
		//document.getElementById('finger'+buttonId).value = val;
		
		if(val == "CONNECT_DEVICE_ERROR"){
		alert("Device Not Connected");
		}
		else
		if(val == "LIBRARY_MISSING_ERROR"){
		alert("Setup Not Installed Properly");
		}
		else
		if(val == "CAPTURE_TIMEOUT_ERROR"){
		alert("Device Not Able to Capture Finger Prints. Try Again.");
		}else
		if(val == "DUPLICATE_FINGER_ERROR"){
		alert("Current finger is already captured at some other finger index.");
		}else
		if(val == "INTERNAL_ERROR"){
		alert("Device Internal Error");
		}else{
			
			
			if(val != null || val.length()!=0 )
				{
				//alert('Response Code '+val[0]);
				//alert('NFIQ: '+val[1]);
  					document.getElementById('bfdNfiq').value = document.getElementById('bfdNfiq').value+val.substring(0,1)+"^";
                                        finger= finger+val.substring(2);

				//alert("Fingerprint together is :"+document.getElementById('fingerPrint').value);
			
				
			//alert("hello");
			document.getElementById('bfdFingerPrint').value = document.getElementById('bfdFingerPrint').value+finger+"^";
			//alert(document.getElementById('bfdNfiq').value);
			
			//document.getElementById('fingerNumber').value = buttonId;
			//alert(document.getElementById('type').value);
			//alert(document.getElementById('fingerPrint').value);
			//alert(temp);
			
			//alert("Fingerprint together is :"+document.getElementById('fingerPrint').value);
			alert("Finger Print Captured");
			
		
			switch(button)
			{
			case 1: $(document).ready(function(){ $(".1").attr('onclick', '""'); });
					document.getElementById('bfdFingerPosition').value = document.getElementById('bfdFingerPosition').value+"RIGHT_THUMB^";
					break;
			case 2: $(document).ready(function(){ $(".2").attr('onclick', '""'); });
					document.getElementById('bfdFingerPosition').value = document.getElementById('bfdFingerPosition').value+"RIGHT_INDEX^";
					break;	
			case 3: $(document).ready(function(){ $(".3").attr('onclick', '""'); });
					document.getElementById('bfdFingerPosition').value =document.getElementById('bfdFingerPosition').value+ "RIGHT_MIDDLE^";
					break;
			case 4: $(document).ready(function(){ $(".4").attr('onclick', '""'); });
					document.getElementById('bfdFingerPosition').value = document.getElementById('bfdFingerPosition').value+"RIGHT_RING^";
					break;
			case 5: $(document).ready(function(){ $(".5").attr('onclick', '""'); });
					document.getElementById('bfdFingerPosition').value =document.getElementById('bfdFingerPosition').value+ "RIGHT_LITTLE^";
					break;
			case 6: $(document).ready(function(){ $(".6").attr('onclick', '""'); });
					document.getElementById('bfdFingerPosition').value = document.getElementById('bfdFingerPosition').value+"LEFT_THUMB^";
					break;
			case 7: $(document).ready(function(){ $(".7").attr('onclick', '""'); });
					document.getElementById('bfdFingerPosition').value = document.getElementById('bfdFingerPosition').value+"LEFT_INDEX^";
					break;
			case 8: $(document).ready(function(){ $(".8").attr('onclick', '""'); });
					document.getElementById('bfdFingerPosition').value = document.getElementById('bfdFingerPosition').value+"LEFT_MIDDLE^";
					break;
			case 9: $(document).ready(function(){ $(".9").attr('onclick', '""'); });
					document.getElementById('bfdFingerPosition').value = document.getElementById('bfdFingerPosition').value+"LEFT_RING^";
					break;
			case 10:$(document).ready(function(){ $(".10").attr('onclick', '""');  });
					document.getElementById('bfdFingerPosition').value = document.getElementById('bfdFingerPosition').value+"LEFT_LITTLE^";
					break;
			
			
			}
			//alert(document.getElementById('fingerPosition').value);
			//alert(document.getElementById('bfdFingerPrint').value);
			
			$( document ).ready(function() { 	
				$(".handdiv ."+button).html("<img src=\"image/check.jpg\"></img>");

				});
				
				}
			else
				{
							alert("Finger print not captured");
				}
			
			
		}
}



//For MORPHO MSO 1300 E2 for BFD

var template;
function getBFDFingerAL(buttonId)

{
	var fingerindex=buttonId;
	var val;
	var deviceStat;
	var url = "https://localhost:8000/CaptureFingerprint";
       var finger = ""; 
       var nfiq = "";
       var fingerPos = "";
    	var xmlhttp;
	if (window.XMLHttpRequest)
	{// code for IE7+, Firefox, Chrome, Opera, Safari

		xmlhttp=new XMLHttpRequest();

	}
	else
	{// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");

	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			fpobject = JSON.parse(xmlhttp.responseText);
			//alert("Device Status: "+fpobject.ReturnCode);
			//alert("Base64ISOTemplate: "+fpobject.Base64ISOTemplate);
			//alert("Base64RAWIMage: "+fpobject.Base64RAWIMage);
			//alert("Base64BMPIMage: "+fpobject.Base64BMPIMage);
			//alert("NFIQ: "+fpobject.NFIQ);
			template = fpobject.Base64ISOTemplate; 	   
			
			deviceStat=fpobject.ReturnCode;

			if(deviceStat == "0")
			{

				finger = fpobject.Base64ISOTemplate;
                            nfiq = fpobject.NFIQ;
                            document.getElementById('bfdFingerPrint').value = document.getElementById('bfdFingerPrint').value+finger+"^";
				document.getElementById('bfdNfiq').value = document.getElementById('bfdNfiq').value + nfiq + "^";
				//alert(document.getElementById('type').value);
				//alert(document.getElementById('fingerPrint').value);
				//alert(temp);
				alert("Finger Print Captured");
				


				switch(fingerindex)
				{
				case 1: $(document).ready(function(){ $("a").attr('onclick', '""'); });
				fingerPos  = "RIGHT_THUMB";
				break;
				case 2: $(document).ready(function(){ $("a").attr('onclick', '""'); });
				fingerPos  = "RIGHT_INDEX";
				break;	
				case 3: $(document).ready(function(){ $("a").attr('onclick', '""'); });
				fingerPos  = "RIGHT_MIDDLE";
				break;
				case 4: $(document).ready(function(){ $("a").attr('onclick', '""'); });
				fingerPos  = "RIGHT_RING";
				break;
				case 5: $(document).ready(function(){ $("a").attr('onclick', '""'); });
				fingerPos  = "RIGHT_LITTLE";
				break;
				case 6: $(document).ready(function(){ $("a").attr('onclick', '""'); });
				fingerPos  = "LEFT_THUMB";
				break;
				case 7: $(document).ready(function(){ $("a").attr('onclick', '""'); });
				fingerPos  = "LEFT_INDEX";
				break;
				case 8: $(document).ready(function(){ $("a").attr('onclick', '""'); });
				fingerPos  = "LEFT_MIDDLE";
				break;
				case 9: $(document).ready(function(){ $("a").attr('onclick', '""'); });
				fingerPos  = "LEFT_RING";
				break;
				case 10:$(document).ready(function(){ $("a").attr('onclick', '""');  });
				fingerPos  = "LEFT_LITTLE";
				break;


				}
		
		              document.getElementById('bfdFingerPosition').value = document.getElementById('bfdFingerPosition').value + fingerPos + "^";

				$( document ).ready(function() { 	
					$(".handdiv ."+fingerindex).html("<img src=\"image/check.jpg\"></img>");

				});
				
				//alert("document.getElementById('fingerPrint').value : " + document.getElementById('fingerPrint').value);
				alert("document.getElementById('bfdFingerPosition').value : " + document.getElementById('bfdFingerPosition').value);

			}
		
			else
			{
				alert("Finger print not captured");
			}
		}

		}
	
	var timeout = 5;
	xmlhttp.open("POST",url+"?"+timeout+"$"+fingerindex,true);
	xmlhttp.send();


}





function getTFAFinger(buttonId)
{
	
	//alert("Click on finger tip to scan one by one");
	
		var button=buttonId;
		var data;
		var testTag = document.getElementById('app1');
		var val = testTag.captureFinger(buttonId);
		var finger="";
		//document.getElementById('finger'+buttonId).value = val;
		
		if(val == "CONNECT_DEVICE_ERROR"){
		alert("Device Not Connected");
		}
		else
		if(val == "LIBRARY_MISSING_ERROR"){
		alert("Setup Not Installed Properly");
		}
		else
		if(val == "CAPTURE_TIMEOUT_ERROR"){
		alert("Device Not Able to Capture Finger Prints. Try Again.");
		}else
		if(val == "DUPLICATE_FINGER_ERROR"){
		alert("Current finger is already captured at some other finger index.");
		}else
		if(val == "INTERNAL_ERROR"){
		alert("Device Internal Error");
		}else{
			
			
			if(val != null || val.length()!=0 )
				{
				//alert('Response Code '+val[0]);
				//alert('NFIQ: '+val[1]);
				//document.getElementById('tfaNfiq').value = document.getElementById('tfaNfiq').value+val[0]+"^";
                                   finger= finger+val.substring(2);

				//alert("Fingerprint together is :"+document.getElementById('fingerPrint').value);
			
				
			//alert("hello");
			document.getElementById('tfaFingerPrint').value = document.getElementById('tfaFingerPrint').value+finger+"^";
			//alert(document.getElementById('bfdNfiq').value);
			
			//document.getElementById('fingerNumber').value = buttonId;
			//alert(document.getElementById('type').value);
			//alert(document.getElementById('fingerPrint').value);
			//alert(temp);
			
			//alert("Fingerprint together is :"+document.getElementById('fingerPrint').value);
			alert("Finger Print Captured");
			
		
			switch(button)
			{
			case 1: $(document).ready(function(){ $(".1").attr('onclick', '""'); });
					document.getElementById('tfaFingerPosition').value = document.getElementById('tfaFingerPosition').value+"RIGHT_THUMB^";
					break;
			case 2: $(document).ready(function(){ $(".2").attr('onclick', '""'); });
					document.getElementById('tfaFingerPosition').value = document.getElementById('tfaFingerPosition').value+"RIGHT_INDEX^";
					break;	
			case 3: $(document).ready(function(){ $(".3").attr('onclick', '""'); });
					document.getElementById('tfaFingerPosition').value =document.getElementById('tfaFingerPosition').value+ "RIGHT_MIDDLE^";
					break;
			case 4: $(document).ready(function(){ $(".4").attr('onclick', '""'); });
					document.getElementById('tfaFingerPosition').value = document.getElementById('tfaFingerPosition').value+"RIGHT_RING^";
					break;
			case 5: $(document).ready(function(){ $(".5").attr('onclick', '""'); });
					document.getElementById('tfaFingerPosition').value =document.getElementById('tfaFingerPosition').value+ "RIGHT_LITTLE^";
					break;
			case 6: $(document).ready(function(){ $(".6").attr('onclick', '""'); });
					document.getElementById('tfaFingerPosition').value = document.getElementById('tfaFingerPosition').value+"LEFT_THUMB^";
					break;
			case 7: $(document).ready(function(){ $(".7").attr('onclick', '""'); });
					document.getElementById('tfaFingerPosition').value = document.getElementById('tfaFingerPosition').value+"LEFT_INDEX^";
					break;
			case 8: $(document).ready(function(){ $(".8").attr('onclick', '""'); });
					document.getElementById('tfaFingerPosition').value = document.getElementById('tfaFingerPosition').value+"LEFT_MIDDLE^";
					break;
			case 9: $(document).ready(function(){ $(".9").attr('onclick', '""'); });
					document.getElementById('tfaFingerPosition').value = document.getElementById('tfaFingerPosition').value+"LEFT_RING^";
					break;
			case 10:$(document).ready(function(){ $(".10").attr('onclick', '""');  });
					document.getElementById('tfaFingerPosition').value = document.getElementById('tfaFingerPosition').value+"LEFT_LITTLE^";
					break;
			
			
			}
			//alert(document.getElementById('fingerPosition').value);
			//alert(document.getElementById('bfdFingerPrint').value);
			
			$( document ).ready(function() { 	
				$(".handdiv ."+button).html("<img src=\"image/check.jpg\"></img>");

				});
				
				}
			else
				{
					alert("Finger print not captured");
				}
			
			var count = document.getElementById('capAttempt').value;
			
			if(count>=2)
			{
				$(document).ready(function(){
				for(var j=1;j<=10;j++)
				{
					 $("."+j).attr('onclick', '""');
				}
				 });
			}
		}
}





//For MORPHO MSO 1300 E2 for TFA

var template;
function getTFAFingerAL(buttonId)

{
	var fingerindex=buttonId;
	var val;
	var deviceStat;
	var url = "https://localhost:8000/CaptureFingerprint";
        var finger = ""; 
        var nfiq = "";
        var fingerPos = "";
	var xmlhttp;
	if (window.XMLHttpRequest)
	{// code for IE7+, Firefox, Chrome, Opera, Safari

		xmlhttp=new XMLHttpRequest();

	}
	else
	{// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");

	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			fpobject = JSON.parse(xmlhttp.responseText);
			//alert("Device Status: "+fpobject.ReturnCode);
			//alert("Base64ISOTemplate: "+fpobject.Base64ISOTemplate);
			//alert("Base64RAWIMage: "+fpobject.Base64RAWIMage);
			//alert("Base64BMPIMage: "+fpobject.Base64BMPIMage);
		//	//alert("NFIQ: "+fpobject.NFIQ);
			template = fpobject.Base64ISOTemplate; 	   
			
			deviceStat=fpobject.ReturnCode;

			if(deviceStat == "0")
			{

			    finger = fpobject.Base64ISOTemplate;
               // nfiq = fpobject.NFIQ;
                document.getElementById('tfaFingerPrint').value = document.getElementById('tfaFingerPrint').value+finger+"^";
			 //   document.getElementById('tfaNfiq').value = document.getElementById('tfaNfiq').value + nfiq + "^";
				//document.getElementById('tfaFingerPrint').value = fpobject.Base64ISOTemplate;
				//document.getElementById('res_nfiq').value = fpobject.NFIQ;
				//document.getElementById('fingerNumber').value = buttonId;
				//alert(document.getElementById('type').value);
				//alert(document.getElementById('fingerPrint').value);
				//alert(temp);
				alert("Finger Print Captured");
				


				switch(fingerindex)
				{
				case 1: $(document).ready(function(){ $(".1").attr('onclick', '""'); });
						document.getElementById('tfaFingerPosition').value = document.getElementById('tfaFingerPosition').value+"RIGHT_THUMB^";
						break;
				case 2: $(document).ready(function(){ $(".2").attr('onclick', '""'); });
						document.getElementById('tfaFingerPosition').value = document.getElementById('tfaFingerPosition').value+"RIGHT_INDEX^";
						break;	
				case 3: $(document).ready(function(){ $(".3").attr('onclick', '""'); });
						document.getElementById('tfaFingerPosition').value =document.getElementById('tfaFingerPosition').value+ "RIGHT_MIDDLE^";
						break;
				case 4: $(document).ready(function(){ $(".4").attr('onclick', '""'); });
						document.getElementById('tfaFingerPosition').value = document.getElementById('tfaFingerPosition').value+"RIGHT_RING^";
						break;
				case 5: $(document).ready(function(){ $(".5").attr('onclick', '""'); });
						document.getElementById('tfaFingerPosition').value =document.getElementById('tfaFingerPosition').value+ "RIGHT_LITTLE^";
						break;
				case 6: $(document).ready(function(){ $(".6").attr('onclick', '""'); });
						document.getElementById('tfaFingerPosition').value = document.getElementById('tfaFingerPosition').value+"LEFT_THUMB^";
						break;
				case 7: $(document).ready(function(){ $(".7").attr('onclick', '""'); });
						document.getElementById('tfaFingerPosition').value = document.getElementById('tfaFingerPosition').value+"LEFT_INDEX^";
						break;
				case 8: $(document).ready(function(){ $(".8").attr('onclick', '""'); });
						document.getElementById('tfaFingerPosition').value = document.getElementById('tfaFingerPosition').value+"LEFT_MIDDLE^";
						break;
				case 9: $(document).ready(function(){ $(".9").attr('onclick', '""'); });
						document.getElementById('tfaFingerPosition').value = document.getElementById('tfaFingerPosition').value+"LEFT_RING^";
						break;
				case 10:$(document).ready(function(){ $(".10").attr('onclick', '""');  });
						document.getElementById('tfaFingerPosition').value = document.getElementById('tfaFingerPosition').value+"LEFT_LITTLE^";
						break;
				
				
				}
		              /*document.getElementById('tfaFingerPosition').value = document.getElementById('tfaFingerPosition').value + fingerPos + "^";
		
		

				$( document ).ready(function() { 	
					$(".handdiv ."+fingerindex).html("<img src=\"image/check.jpg\"></img>");

				});
				
				//alert("document.getElementById('fingerPrint').value : " + document.getElementById('fingerPrint').value);
				alert("document.getElementById('tfaFingerPosition').value : " + document.getElementById('tfaFingerPosition').value);*/

			/*}
		
			else
			{
				alert("Finger print not captured");
			}
		}

		}
	*/
	
				$( document ).ready(function() { 	
					$(".handdiv ."+fingerindex).html("<img src=\"image/check.jpg\"></img>");

					});
					
					}
		
				else
					{
						alert("Finger print not captured");
					}
		}
				
				var count = document.getElementById('capAttempt').value;
				
				if(count>=2)
				{
					$(document).ready(function(){
					for(var j=1;j<=10;j++)
					{
						 $("."+j).attr('onclick', '""');
					}
					 });
				}
			}
	
	var timeout = 5;
	xmlhttp.open("POST",url+"?"+timeout+"$"+fingerindex,true);
	xmlhttp.send();


}




