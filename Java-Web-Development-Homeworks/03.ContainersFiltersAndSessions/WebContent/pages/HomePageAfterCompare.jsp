<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="username" value= '<%= session.getAttribute("username") %>' />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<body>
		<ct:PageTag>
			<jsp:body>
				<div>Your password and username are correct!</div>
				<div>Username: ${username}</div>
			</jsp:body>
		</ct:PageTag>
	</body>
</body>
</html>