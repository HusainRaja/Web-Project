<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp" %>
    <%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
</head>
<body>
<h1>This is the Category page.</h1>
<form action="InsertCategory" method="post">
<table>
<tr>
<td colspan="2">categories</td>
</tr>
<tr>
<td>Category name</td>
<td> <input type="text" name="catname" id="catdesc"></td>
</tr>
<tr>
<td>Category desc</td>
<td> <textarea name="catdesc" id="catdesc"></textarea></td>
</tr>
</table>
<input type="submit" name="INSERT">
</form>
<table border="1px">
<tr>
<th>Category ID</th>
<th>Category name</th>
<th>Category Desc</th>
<th>Options</th>
</tr>
<c:forEach items="${categoryList}" var="category">
	<tr>
	<td>${category.categoryId}</td>
	<td>${category.categoryName}</td>
	<td>${category.categoryDesc}</td>
	<td>
		<a href="<c:url value='/editCategory/${category.categoryId}'/>">edit</a>/
		<a href="<c:url value='/deleteCategory/${category.categoryId}'/>">delete</a>
	</td>
	</tr>
</c:forEach>
</table>
</body>
</html>