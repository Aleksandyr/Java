<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="date" value="<%= new java.util.Date()%>" />
    
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
			<td>${date}</td>
		</tr>
	</table>
</body>
</html>