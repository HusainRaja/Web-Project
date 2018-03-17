<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Header.jsp" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Page</title>
</head>
<body>
<h1>This is the Product Page</h1>
<spring:form action="addProduct" modelAttribute="Product" method="post">
supplierId:<spring:input path="SupplierId"/><br/><br/>
categoryId:<spring:input path="CategoryId"/><br/><br/>
productName:<spring:input path="productName"/><br/><br/>
productDesc:<spring:input path="productDesc"/><br/><br/>
stock:<spring:input path="stock"/><br/><br/>
price:<spring:input path="price"/><br/><br/>
<button type="submit" class="btn">Add</button>
</spring:form>
<table border="1px">
<tr>
<th>product ID</th>
<th>product name</th>
<th>product Desc</th>
<th>supplier ID</th>
<th>category ID</th>
<th>stock</th>
<th>price</th>
<th>options</th>
</tr>
<c:forEach items="${productList}" var="product">
	<tr>
	<td>${product.productId}</td>
	<td>${product.productName}</td>
	<td>${product.productDesc}</td>
	<td>${product.supplierId}</td>
	<td>${product.categoryId}</td>
	<td>${product.stock}</td>
	<td>${product.price}</td>
	<td>
		<a href="<c:url value='/editProduct/${product.productId}'/>">edit</a>/
		<a href="<c:url value='/deleteProduct/${product.productId}'/>">delete</a>
	</td>
	</tr>
</c:forEach>
</table>
</body>
</html>