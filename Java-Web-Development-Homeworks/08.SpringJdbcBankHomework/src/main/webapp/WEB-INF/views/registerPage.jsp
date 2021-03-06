<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="accNum" value= '<%= session.getAttribute("accNum") %>' />
<c:set var="accInitAmount" value= '<%= session.getAttribute("accInitAmount") %>' />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Enter acc number and get him!</h3>
	
	<form:form method="POST" action="getAccount">
		<label>Username:</label>
		<input type="text" name="username" value="${username}" />
		<br/>
		<label>All accounts</label>
		<select id="accounts" name="accounts">
			<c:if test="${not empty accounts}">	
		        <c:forEach var="a" items="${accounts}">
					  <option value="${a.getAccNumber()}">${a.getAccNumber()}</option>
		        </c:forEach>
			</c:if>
		</select>
		<br/>
		<input type="submit" value="Submit" />
	</form:form>
	
	<sec:authorize access="hasRole('ROLE_USER')">
				<button type="button" onclick="location = 'bankOperation'">Bank Operation</button>
	</sec:authorize>
	<button type="button" onclick="location = '../webBank/'">HOME</button>
	<button type="button" onclick="location = 'logout'">Logout</button>
	
	<div>
		<h3>Acc info:</h3>
		<p>Account number: ${accNum}</p>
		<p>Account inital amount: ${accInitAmount}</p>
		
	</div>
</body>
</html>