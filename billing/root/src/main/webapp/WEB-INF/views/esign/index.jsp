<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Aadhaar Authentication Services</title>
<link href="/esign/resources/css/aadhaar_style.css" rel="stylesheet"
	type="text/css" />

</head>
<body>
	<div id="mainContainer">
		<div id="header">
			<%@ include file="header.jsp"%>
		</div>
		<div id="mainContent">
		<c:set var="setId" value="${ID}"></c:set>
			<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
			response.setHeader("Pragma", "no-cache"); // HTTP 1.0
			response.setDateHeader("Expires", 0); // Proxies.
			String user = (String)session.getAttribute("user");
			String idFromSession = (String)session.getAttribute("id");
			String idFromUrl = (String)pageContext.getAttribute("setId");
			System.out.println("idFromSession:" + idFromSession);
			System.out.println("idFromUrl:" + idFromUrl);
			System.out.println("user:" + user);
			if(user==null || user.length()==0 || idFromUrl==null ||idFromSession == null ||  !idFromUrl.equalsIgnoreCase(idFromSession))
			{
				session.invalidate();
				
		%>
			<div id="heading">

				<h3>Your Session Has Expired. Please Login Again.</h3>
			</div>
			<div
				style="width: 800px; margin-left: auto; margin-right: auto; padding: 0px">
				<div
					style="width: 150px; margin-left: auto; margin-right: auto; padding: 0px">
					<a id="loginagain" href="/aua/login.jsp" class="loginagain">Login
						Again</a>
				</div>
			</div>
			<%		
			}else
			{
				Random r = new Random();
				int id=0;
				do
				{
					id = r.nextInt();
				}while(id<0);
				session.setAttribute("id",String.valueOf(id));
		%>
			<div id="heading">
				<div class="userdetail">
					<a id="logout" href="/aua/logout" class="logout">Logout</a>
				</div>
				<h3>Select Authentication Type</h3>
			</div>
			<h4>AUA Requests</h4>
			<div id="content">
				<div class="options">
					<div style="height: 100%;">

						<div style="height: 100px;">
							<a href="/aua/demoInput?id=<%=id %>"
								style="float: left; margin-left: 50px;" class="oLink">Demographic</a>
							<a href="/aua/biomInput?ID=<%=id %>"
								style="float: right; margin-right: 50px;" class="oLink">Fingerprint</a>
						</div>
						
						<div style="height: 100px;">
							<a href="/aua/irisInput?ID=<%=id %>"
								style="float: left; margin-left: 50px;" class="oLink">Iris</a>
							<a href="/aua/bfdInput?ID=<%=id %>"
								style="float: right; margin-right: 50px;" class="oLink">BFD</a>
						</div>
						<%-- <div style="height: 100px;">
							<a href="/aua/bfdInput?ID=<%=id %>"
								style="margin: 0px auto;" class="oLink">BFD</a>
						</div> --%>
						<div style="height: 100px;">
							<a href="/aua/otpInput?id=<%=id %>"
								style="float: left; margin-left: 50px;" class="oLink">OTP</a> <a
								href="/aua/tfaInput?ID=<%=id %>"
								style="float: right; margin-right: 50px;" class="oLink">Two
								Finger</a>
						</div>
						
						<div style="height: 100px;">
							<a href="/aua/showLog?id=<%=id %>"
								style="float: left; margin-left: 50px;" class="oLink">Show Log</a> <a
								href="/aua/showLog?id=<%=id %>"
								style="float: right; margin-right: 50px;" class="oLink">Show Log</a>
						</div> 

					</div>
				</div>
			</div>
			
			<hr>
			</hr>
			<%--  <h4>KUA Requests</h4>
			<div id="content">
			<div class="options">
				<a href="/aua/bfdKuaInput?ID=<%=id %>" class="oLink">BFD</a>
				<a href="/aua/otpKuaInput?ID=<%=id %>" class="oLink">OTP</a>
				<a href="/aua/biomKuaInput?ID=<%=id %>" class="oLink">Biometric</a>
			</div>
		</div>  --%> 
			<%
			}
		%>
		</div>
		<div id="footer">
			<%@ include file="footer.jsp"%>
		</div>
	</div>

</body>
</html>