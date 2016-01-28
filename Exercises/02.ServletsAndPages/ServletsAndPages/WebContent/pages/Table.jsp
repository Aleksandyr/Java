<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Table</title>
</head>
<body>
	<table border=1>
		<tr>
			<th>Topic</th>
			<th>Date</th>
		</tr>
		<tr>
			<td>Java web development</td>
			<td><%= new java.util.Date() %></td>
		</tr>
	</table>
</body>
</html>