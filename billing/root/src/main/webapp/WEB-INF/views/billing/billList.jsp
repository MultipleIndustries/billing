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
        <form:form action="addBill" method="post" commandName="bill">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Nafis Enterprise</h2></td>
                </tr>
                
                <tr>
                    <td>Customer</td>
                    <td><select name="customerId">
                    		<option value="0">Select Customer</option>
                    			<c:forEach items="${allCustomers}" var="item">
						    		<option value="${item.customerId}">${item.customerName}</option>
								</c:forEach>
                    	</select>
                    </td>
                </tr>
                
                 <tr>
                    <td>Contractor Number: </td>
                    <td><form:input path="contractorNumber" /></td>
                </tr>
                 <tr>
                    <td>Contractor Category: </td>
                    <td><form:input path="contractorCategory" /></td>
                </tr>
                <tr>
                    <td>Entry Sheet Number: </td>
                    <td><form:input path="sheetNumber" /></td>
                </tr>
                 <tr>
                    <td>Name of the Building: </td>
                    <td><form:input path="buildingName" /></td>
                </tr>
                 <tr>
                    <td>Job: </td>
                    <td><form:input path="job" /></td>
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
                    <td>Variant</td>
                    <td><select name="variantId">
                    		<option value="0">Select Variant</option>
                    			<c:forEach items="${allVariants}" var="item">
						    		<option value="${item.variantId}">${item.variantName}</option>
								</c:forEach>
                    	</select>
                    </td>
                </tr>
                <tr>
                    <td>Length: </td>
                    <td><form:input path="length" /></td>
                </tr>
                <tr>
                    <td>Width: </td>
                    <td><form:input path="width" /></td>
                </tr> 
                <tr>
                    <td>Area: </td>
                    <td><form:input path="area" /></td>
                </tr> 
                <tr>
                    <td>Rate: </td>
                    <td><form:input path="rate" /></td>
                </tr>
               <tr>
                    <td>Amount: </td>
                    <td><form:input path="amount" /></td>
                </tr>
                <tr>
                    <td>VAT Amount: </td>
                    <td><form:input path="vatAmount" /></td>
                </tr>
                <tr>
                    <td>Total Amount: </td>
                    <td><form:input path="totalAmount" /></td>
                </tr>
                <tr>
                    <td>Status: </td>
                    <td><form:input path="status" /></td>
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
								<th>Product</th>
								<th>Area</th>
								<th>Rate</th>
								<th>Amount</th>
							</tr>
							<c:forEach items="${allBills}" var="item">
							<tr>
								<td>${item.customer.customerName}</td>
								<td>
								<c:forEach items="${item.product}" var="pro">
								${pro.productName}
								</c:forEach>
								</td>
								<td>${item.area}</td>
								<td>${item.rate}</td>
								<td>${item.totalAmount}</td>
							</tr>
							</c:forEach>
						</table>
    				</div>
    
    
</body>
</html>