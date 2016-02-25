<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>


<c:set var="username" value= '<%= session.getAttribute("client_name") %>' />
<c:set var="amount" value= '<%= session.getAttribute("amount_to_change") %>' />
<html>
<head>
	<title>Home</title>
</head>
	<body>
		<ct:BankingPage></ct:BankingPage>
		<div>Username: ${username}</div>
		<div>Amount: ${amount}</div>
	</body>
</html>
