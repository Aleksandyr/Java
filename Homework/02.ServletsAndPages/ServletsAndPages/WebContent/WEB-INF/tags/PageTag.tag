<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>
<%@ attribute name="title" %>

<html>
	<head>
		<title>This is page tag</title>
	</head>
	<body>
		<ct:Header title="${title}"></ct:Header>
		<jsp:doBody></jsp:doBody>
		<ct:Footer></ct:Footer>
	</body>
</html>
