<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="POST">
		<label>ID</label>
		<input type="number" name="id" />
		<label>Topic</label>
		<input type="text" name="topic" />
		<label>Date</label>
		<input type="date" value="date" name="date" />
		<input type="button" name="submit" value="submit"/>
		<input type="button" name="cancel" value="cancel"/>
	</form>
</body>
</html>