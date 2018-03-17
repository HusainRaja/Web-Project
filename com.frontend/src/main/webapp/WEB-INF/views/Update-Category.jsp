<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp" %>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update Category</title>
</head>
<body>
<h1>This is the Category page.</h1>
<spring:form action="updateCategory" modelAttribute="category" method="post">

<spring:input path="categoryId" readonly="readonly" value="${categoryInfo.categoryId}"/><br/>
<spring:input path="categoryName" value="${categoryInfo.categoryName}"/><br/>
<spring:input path="categoryDesc" value="${categoryInfo.categoryDesc}"/><br/>
<button type="submit" class="btn">Update</button>
</spring:form>
</body>
</html>