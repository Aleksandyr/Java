<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
</head>
	<body>
		<form:form method="POST" action="registerUser">
			<label>Username:</label>
			<input type="text" name="username" />
			<br/>
			<input type="submit" value="Submit" />
		</form:form>
	</body>
</html>