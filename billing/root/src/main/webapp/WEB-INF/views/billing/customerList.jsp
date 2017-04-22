<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nafis Enterprise</title>
</head>
<body>
    <div align="center">
        <form:form action="addCustomer" method="post" commandName="customer">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Nafis Enterprise</h2></td>
                </tr>
                <tr>
                    <td>Customer Name:</td>
                    <td><form:input path="customerName" /></td>
                </tr>
                  <tr>
                    <td>Address</td>
                    <td><form:input path="address" /></td>
                </tr>
                 <tr>
                    <td>Mobile</td>
                    <td><form:input path="mobile" /></td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Add" /></td>
                </tr>
            </table>
        </form:form>
    </div>
    <br>
    
    				<div>	
    					<table width="60%" border="1">
							<tr>
								
								<th>Customer Name</th>
								<th>Address</th>
								<th>Mobile</th>
							</tr>
						<c:forEach items="${allCustomers}" var="item">
							<tr>
								<td>${item.customerName}</td>
								<td>${item.address}</td>
								<td>${item.mobile}</td>
							</tr>
							</c:forEach>
						</table>
    				</div>
    
    
</body>
</html>