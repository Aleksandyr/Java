<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
	<body>
		<h1>
			Main menu!
		</h1>
		<table border="1">
			<tr>
				<th>Username</th>
				<th>password</th>
				<th>Role</th>
				<th>Description</th>
			</tr>
			<tr>
				<td>user</td>
				<td>123456</td>
				<td>ROLE_USER</td>
				<td>In register page you can add accounts that has been created before from employee!</td>
			</tr>
			<tr>
				<td>employee</td>
				<td>123456</td>
				<td>ROLE_BANK_EMPLOYEE</td>
				<td>To have account first you should create with this user!</td>
			</tr>
		</table>
		
		<button type="button" onclick="location = 'registerPage'">Register page</button>
		<sec:authorize access="hasRole('ROLE_BANK_EMPLOYEE')">
			<button type="button" onclick="location = 'registerAccount'">New account</button>
			<button type="button" onclick="location = 'allAccounts'">All accounts</button>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_USER')">
			<button type="button" onclick="location = 'userAccounts'">See my accounts</button>
		</sec:authorize>
		
		<c:if test="${not empty accounts}">
			<table border="1">
				<thead>
					<tr>
						<td>Account number</td>
						<td>Initial amount</td>
						<td>Currency</td>
					</tr>
				</thead>
			   	<tbody>
			        <c:forEach var="a" items="${accounts}">
			            <tr>
			                <td>${a.getAccNumber()}</td>
			                <td>${a.getInitialAmount()}</td>
			                <td>${a.getCurrency()}</td>
			            </tr>
			        </c:forEach>
			     </tbody>
			</table>
		</c:if>
		<c:if test="${not empty userAccounts}">
			<table border="1">
				<thead>
					<tr>
						<td>Username</td>
						<td>Account number</td>
						<td>Initial amount</td>
						<td>Currency</td>
					</tr>
				</thead>
			   	<tbody>
			        <c:forEach var="a" items="${userAccounts}">
			            <tr>
			            	<td>${user.getUsername()}</td>
			                <td>${a.getAccNumber()}</td>
			                <td>${a.getInitialAmount()}</td>
			                <td>${a.getCurrency()}</td>
			            </tr>
			        </c:forEach>
			     </tbody>
			</table>
		</c:if>
	</body>
</html>
