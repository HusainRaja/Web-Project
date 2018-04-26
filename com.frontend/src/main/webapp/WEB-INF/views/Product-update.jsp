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
<spring:form action="productUpdate" modelAttribute="Product" method="post">
productId:<spring:input path="productId" value="${productInfo.productId }"/>
supplierId:<spring:input path="SupplierId" value="${productInfo.supplierId }"/><br/>
categoryId:<spring:input path="CategoryId" value="${productInfo.categoryId }"/><br/>
productName:<spring:input path="productName" value="${productInfo.productName }"/><br/>
productDesc:<spring:input path="productDesc" value="${productInfo.productDesc }"/><br/>
stock:<spring:input path="stock" value="${productInfo.stock }"/><br/>
price:<spring:input path="price" value="${productInfo.price }"/><br/>
<button type="submit" class="btn">Add</button>
</spring:form>
</body>
</html>