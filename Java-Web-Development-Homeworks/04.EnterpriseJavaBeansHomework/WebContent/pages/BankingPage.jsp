<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="username" value= '<%= session.getAttribute("client_name") %>' />
<c:set var="amount" value= '<%= session.getAttribute("amount_to_change") %>' />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ct:BankingPage></ct:BankingPage>
	<div>Username: ${username}</div>
	<div>Amount: ${amount}</div>
</body>
</html>