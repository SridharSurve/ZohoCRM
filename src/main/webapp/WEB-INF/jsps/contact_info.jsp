<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contacts Information</title>
</head>
<body>
<pre>
		Contact Id:${contact.id}
		First Name:${contact.firstNmae}
		Last Name:${contact.lastName}
		Email:${contact.email}
		Mobile:${contact.mobile}
</pre>		
</body>
</html>