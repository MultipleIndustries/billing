<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.button {
    align-items: flex-start;
    text-align: center;
    cursor: default;
    color: buttontext;
    background-color: buttonface;
    box-sizing: border-box;
    padding: 2px 6px 3px;
    border-width: 2px;
    border-style: outset;
    border-color: buttonface;
    border-image: initial;
}
</style>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nafis Enterprise</title>
</head>
<body>
    <div align="center">
        <form:form action="addProduct" method="post" commandName="product">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Nafis Enterprise</h2></td>
                </tr>
                <tr>
                    <td>Product Name:</td>
                    <td><form:input path="productName" /></td>
                </tr>
                  <tr>
                    <td>Product Code:</td>
                    <td><form:input path="productCode" /></td>
                </tr>
               
                
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Add" /></td>
                    
                    <td colspan="2" align="center"><a class="button" href="/billing/landingPage">Back</a></td>
                </tr>
            </table>
        </form:form>
    </div>
    <br>
    
    				<div>	
    					<table width="60%" border="1">
							<tr>
								<th>Product Code</th>
								<th>Product Name</th>
								<th>Action</th>
							</tr>
							<c:forEach items="${allProducts}" var="item">
						    
							<tr>
								<td>${item.productCode}</td>
								<td>${item.productName}</td>
								<td><a href="/billing/productList?id=${item.productId}">Edit</a></td>
							</tr>
							</c:forEach>
						</table>
    				</div>
    
    
</body>
</html>