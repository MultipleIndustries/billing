<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Aadhaar Authentication Services</title>
<link href="/esign/resources/css/aadhaar_style.css" rel="stylesheet"
	type="text/css" />
<script src="/esign/resources/js/jquery-1.10.2.min.js"
	type="text/javascript"></script>
<script src="/esign/resources/js/jquery_validate.js"
	type="text/javascript"></script>

</head>
<body>
	<div id="mainContainer">
		<div id="header">
			<%@ include file="header.jsp"%>
		</div>
		<div id="mainContent">

			<div id="heading">
				<h3>LOGIN</h3>
			</div>
			<div id="content">
				<div
					style="height: 20px; margin: 0px; padding: 0px; color: #003399; margin-top: 10px;">
					<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
			response.setHeader("Pragma", "no-cache"); // HTTP 1.0
			response.setDateHeader("Expires", 0); // Proxies.
			String user = (String)session.getAttribute("user");
			Random r = new Random();
			int id=0;
			do
			{
				id = r.nextInt();
			}while(id<0);
			if(user!=null && user.length()!=0)
			{
				
				request.getSession(true).removeAttribute("user");
				request.getSession(true).invalidate();
				
			%>
					<h6
						style="height: 20px; margin: 0px; padding: 0px; text-align: center;">You
						are now logged out</h6>
					<%
			}
			%>
					<%
					String login = (String)request.getAttribute("login");
					if(login!=null&&login.equalsIgnoreCase("fail"))
					{
						
					
				%>
					<h6
						style="height: 20px; margin: 0px; padding: 0px; text-align: center;">Invalid
						username and password</h6>
					<%
					}
				%>
					<!-- Added for license File Check -->
					<%
					String license = (String)request.getAttribute("license");
					if(license!=null )
					{
				%>
					<h6
						style="height: 20px; margin: 0px; padding: 0px; text-align: center;"><%=license.toString() %></h6>
					<%
					}
				%>
					<%
					String fileExists = (String)request.getAttribute("fileExists");
					if(fileExists!=null && fileExists.equalsIgnoreCase("License file does not exists"))
					{
				%>
					<h6
						style="height: 20px; margin: 0px; padding: 0px; text-align: center;">License
						file does not exists</h6>
					<%
					}
				%>

					<!-- End of license file check -->

				</div>

				<div class="login">

					<form autocomplete="off" action="/billing/LoginServlet?id=<%=id %>" method="post" id="loginForm">

						<table width="60%">
							<tr>
								<td width="40%" align="right">User ID</td>
								<td><input type="text" id="user" name="user" /></td>
							</tr>
							<tr>
								<td width="40%" align="right">Password</td>
								<td><input type="password" id="pwd" name="pwd" /></td>
							</tr>
							<tr>
								<td colspan="2"><center>
										<button title="submit" id="submit" type="submit">Submit</button>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<button title="reset" type="reset">Reset</button>
									</center></td>
							</tr>
						</table>
					</form>
				</div>
			</div>

		</div>
		<div id="footer">
			<%@ include file="footer.jsp"%>
		</div>
	</div>
	<style>
	.error{
	color:red;
	font-family: arial;
	font-size: 12px;
	font-weight: normal;
	width: 130px;
	display: block;
	}
	
	</style>
	<script type="text/javascript"> 
$( document ).ready(function() {
	  $.validator.addMethod("alphanumeric", function(value, element) {
        return this.optional(element) || /^[a-zA-Z0-9]+$/.test(value);
	  },"Only alphanumeric input allowed");
	  $.validator.addMethod("PASSWORD",function(value,element){
          return this.optional(element) || /^(?=.*\d)(?=.*[a-z])(?=.*[$@$!%*?&])(?=.*[A-Z]).{8,16}$/i.test(value);
      },"Password must contain Minimum 8 and Maximum 16 characters at least 1 Uppercase Alphabet, 1 Lowercase Alphabet, 1 Number and 1 Special Character");

	  $("#loginForm").validate({
          rules: {
        	  user: "required alphanumeric",
              pwd: "required PASSWORD",
          },
      });
/* 	$("#loginForm").submit(function(event){
		var re = new RegExp('^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,16}');
		if(!re.test($("#password").val())){
			event.preventDefault();
			alert("Password must contain Minimum 8 and Maximum 16 characters at least 1 Uppercase Alphabet, 1 Lowercase Alphabet, 1 Number and 1 Special Character")
		}
	   
	}); */
	
	});
</script>

</body>
</html>