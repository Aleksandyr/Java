<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" action="registerPage">
		<label>Username:</label>
		<input type="text" name="username" />
		<br/>
		<label>Account number:</label>
		<input type="text" name="acc_number" />
		<br/>
		<label>Current amount:</label>
		<input type="number" name="curr_amount" />
		<br/>
		<label>Account currency:</label>
		<input type="text" name="acc_currency" />
		<br/>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>