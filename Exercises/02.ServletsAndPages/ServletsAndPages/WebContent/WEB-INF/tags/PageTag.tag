<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="isShowDate" value="true"></c:set>
<c:set var="date" value="<%= new java.util.Date() %>"></c:set>
<html>
	<head>
		<title>This is page tag</title>
	</head>
	<body>
		<div>Here is content</div>
		<footer>
			<div>
				Version 0.1	
				<c:if test='${isShowDate == "true"}'>
					<p>${date}</p>
				</c:if>
			</div>
		</footer>
	</body>
</html>
