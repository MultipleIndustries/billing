

//alert("HIII m in Biom");

//document.write('<applet code="Legend.BiomAPI.class" width="0" height="0" MAYSCRIPT archive="BiomAPI.jar" id="Obj"></applet>');

function GetFeatureBFDData(iFingerID)
{
	Obj.PidXMLVersion("1.0");
	Obj.GetFeatureBFDData(iFingerID);
	var capAttempt = Obj.CaptureAttempt();
	$( document ).ready(function() { 	
		$(".handdiv ."+iFingerID).html("<img src=\"image/check.jpg\"></img>");

		});
	
}
function FormBFDData ()
{
	//document.getElementsByName("TerminalID")[0].value = "";
	document.getElementsByName("pidXML")[0].value = "";
	document.getElementsByName("encSession")[0].value = "";
	document.getElementsByName("Session")[0].value = "";
	document.getElementsByName("certExpiryDate")[0].value = "";
	document.getElementsByName("encHmac")[0].value = "";
	var lsTerminalID = null;
	var lsDataXml = null;
	var lsUidaiSessionKey = null;
	var lsLSSessionKey = null;
	var lsUidaiCertExpiryDate = null;
	var lsHmacXml = null;
	
	Obj.FormBFDXML();
	
	lsTerminalID = Obj.TerminalID();
	lsDataXml = Obj.PidXMLData();		
	lsUidaiSessionKey = Obj.EncSessionKey();		
	lsLSSessionKey = Obj.SessionKey();	
	lsUidaiCertExpiryDate = Obj.CertExpiryDate();
	lsHmacXml = Obj.EncHmacData();
	
	if(lsDataXml != "" && lsDataXml != "" && lsUidaiSessionKey != "" && lsUidaiCertExpiryDate != "" && lsHmacXml != "" &&lsDataXml != null && lsDataXml != null && lsUidaiSessionKey != null && lsUidaiCertExpiryDate != null && lsHmacXml != null)
	{
	//document.getElementsByName("TerminalID")[0].value = lsTerminalID;
	document.getElementsByName("pidXML")[0].value = lsDataXml;
	document.getElementsByName("encSession")[0].value = lsUidaiSessionKey;
	document.getElementsByName("Session")[0].value = lsLSSessionKey;
	document.getElementsByName("certExpiryDate")[0].value = lsUidaiCertExpiryDate;
	document.getElementsByName("encHmac")[0].value = lsHmacXml;
	alert("Fingerprint captured");
	}
	else
	{
	alert("Fingerprint not captured");
	}
	
}
function getFeatureUIDAIData (iFingerID)
{
	
	//alert("in GetFeatureUIDAIData");
	//document.getElementsByName("TerminalID")[0].value = "";
	//iFingerID=document.getElementsByName("fingpos")[0].value;
	document.getElementsByName("pidXML")[0].value = "";
	document.getElementsByName("encSession")[0].value = "";
	document.getElementsByName("Session")[0].value = "";
	document.getElementsByName("certExpiryDate")[0].value = "";
	document.getElementsByName("encHmac")[0].value = "";
	var lsTerminalID = null;
	var lsDataXml = null;
	var lsUidaiSessionKey = null;
	var lsLSSessionKey = null;
	var lsUidaiCertExpiryDate = null;
	var lsHmacXml = null;
	var timestamp = null;
	Obj.PidXMLVersion("1.0");
	Obj.GetFeatureUIDAIData(iFingerID);
	
	lsTerminalID = Obj.TerminalID();
	lsDataXml = Obj.PidXMLData();		
	lsUidaiSessionKey = Obj.EncSessionKey();		
	lsLSSessionKey = Obj.SessionKey();	
	lsUidaiCertExpiryDate = Obj.CertExpiryDate();
	lsHmacXml = Obj.EncHmacData();
	timestamp=Obj.TimeStamp();
	if(lsDataXml != "" && lsDataXml != "" && lsUidaiSessionKey != "" && lsUidaiCertExpiryDate != "" && lsHmacXml != "" &&lsDataXml != null && lsDataXml != null && lsUidaiSessionKey != null && lsUidaiCertExpiryDate != null && lsHmacXml != null)
	{
	//document.getElementsByName("TerminalID")[0].value = lsTerminalID;
	document.getElementsByName("pidXML")[0].value = lsDataXml;
	document.getElementsByName("encSession")[0].value = lsUidaiSessionKey;
	document.getElementsByName("Session")[0].value = lsLSSessionKey;
	document.getElementsByName("certExpiryDate")[0].value = lsUidaiCertExpiryDate;
	document.getElementsByName("encHmac")[0].value = lsHmacXml;
	// document.getElementsByName("timestamp")[0].value = timestamp;
    // alert("ts attribute in PID XML generated by BIOM API :"+Obj.TimeStamp());

		$( document ).ready(function() { 	
			$(".handdiv ."+iFingerID).html("<img src=\"image/check.jpg\"></img>");
	
		});
	
		
	}
	else
	{
	alert("Fingerprint not captured");
	}
	
}


function ClearBFDData()
{
	document.getElementsByName("uid")[0].value="";
	document.getElementsByName("fingpos")[0].value="0";
    Obj.ClearBFDData();
}

function GetFeatureTFAData (iFingerID)
{
	var iCaptureAttempt = document.getElementsByName("capAttempt")[0].value;
	//document.getElementsByName("TerminalID")[0].value = "";
	document.getElementsByName("pidXML")[0].value = "";
	document.getElementsByName("encSession")[0].value = "";
	document.getElementsByName("Session")[0].value = "";
	document.getElementsByName("certExpiryDate")[0].value = "";
	document.getElementsByName("encHmac")[0].value = "";
	var lsTerminalID = null;
	var lsDataXml = null;
	var lsUidaiSessionKey = null;
	var lsLSSessionKey = null;
	var lsUidaiCertExpiryDate = null;
	var lsHmacXml = null;

	Obj.PidXMLVersion("1.0");
	Obj.GetFeatureTFAData(iFingerID,iCaptureAttempt);
	
	lsTerminalID = Obj.TerminalID();
	lsDataXml = Obj.PidXMLData();		
	lsUidaiSessionKey = Obj.EncSessionKey();		
	lsLSSessionKey = Obj.SessionKey();	
	lsUidaiCertExpiryDate = Obj.CertExpiryDate();
	lsHmacXml = Obj.EncHmacData();
	
	if(lsDataXml != "" && lsDataXml != "" && lsUidaiSessionKey != "" && lsUidaiCertExpiryDate != "" && lsHmacXml != "" &&lsDataXml != null && lsDataXml != null && lsUidaiSessionKey != null && lsUidaiCertExpiryDate != null && lsHmacXml != null)
	{
	//document.getElementsByName("TerminalID")[0].value = lsTerminalID;
	document.getElementsByName("pidXML")[0].value = lsDataXml;
	document.getElementsByName("encSession")[0].value = lsUidaiSessionKey;
	document.getElementsByName("Session")[0].value = lsLSSessionKey;
	document.getElementsByName("certExpiryDate")[0].value = lsUidaiCertExpiryDate;
	document.getElementsByName("encHmac")[0].value = lsHmacXml;
  $( document ).ready(function() {
                $(".handdiv ."+iFingerID).html("<img src=\"image/check.jpg\"></img>");

                });

	}
	else
	{
	alert("Fingerprint not captured");
	}
}
