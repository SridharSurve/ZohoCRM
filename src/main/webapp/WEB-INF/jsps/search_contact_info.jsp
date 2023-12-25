<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Contact Info</title>
</head>
<body>
	<table>
	<table border=2/>
	<tr>
	<th>FirstName</th>
	<th>LastName</th>
	<th>Email</th>
	<th>Mobile</th>
	<tr>
		<c:forEach var="contact" items="${contacts}">
		<tr>
		<td><a href="contact_info?id=${contact.id}">${contact.firstNmae}</a></td>
		<td>${contact.lastName}</td>
		<td>${contact.email}</td>
		<td>${contact.mobile}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>