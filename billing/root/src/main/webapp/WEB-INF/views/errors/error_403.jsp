<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Aadhaar Authentication Services</title>
<link href="/aua/resources/css/aadhaar_style.css" rel="stylesheet"
	type="text/css" />
<script src="/aua/resources/js/jquery-1.10.2.min.js"
	type="text/javascript"></script>
<script src="/aua/resources/js/jquery_validate.js"
	type="text/javascript"></script>

</head>
<body>
	<div id="mainContainer">
		<div id="header">
			<%@ include file="header.jsp"%>
		</div>
		<div id="mainContent">

			<div class="col-sm-8 col-sm-offset-2 text-center">
				<h1 class="animation-fadeIn"><i class="fa fa-times-circle-o text-muted"></i> 403</h1>
				<h2 class="h3">Oops, we are sorry but you are not authorized to access this page..</h2>
			</div>
		</div>
		<div id="footer">
			<%@ include file="footer.jsp"%>
		</div>
	</div>


</body>
</html>

