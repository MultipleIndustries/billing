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
        <form:form action="addVariant" method="post" commandName="variant">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Nafis Enterprise</h2></td>
                </tr>
                <tr>
                    <td>Product</td>
                    <td><select name="productId">
                    		<option value="0">Select Product</option>
                    			<c:forEach items="${allProducts}" var="item">
						    		<option value="${item.productId}">${item.productName}</option>
								</c:forEach>
                    	</select>
                    </td>
                </tr>
                <tr>
                    <td>Variant Name:</td>
                    <td><form:input path="variantName" /></td>
                </tr>
                  <tr>
                    <td>Variant Code:</td>
                    <td><form:input path="variantCode" /></td>
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
								<th>Product Name</th>
								<th>Variant Code</th>
								<th>Variant Name</th>
							</tr>
							<c:forEach items="${allVariants}" var="item">
							<tr>
								<td>${item.productMaster.productName}</td>
								<td>${item.variantCode}</td>
								<td>${item.variantName}</td>
							</tr>
							</c:forEach>
						</table>
    				</div>
    
    
</body>
</html>