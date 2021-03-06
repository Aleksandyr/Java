<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		<form:form method="POST" action="bankOperation">
			<label>All accounts</label>
			<select id="myAcc" name="myAcc">
				<c:if test="${not empty myAccounts}">	
			        <c:forEach var="a" items="${myAccounts}">
						  <option value="${a.getAccNumber()}">${a.getAccNumber()}</option>
			        </c:forEach>
				</c:if>
			</select>
			<br/>
			<label>Deposit or withdraw:</label>
			<select id="deposti_withdraw" name="deposit_withdraw">
			  <option value="deposit">Deposit</option>
			  <option value="withdraw">Withdraw</option>
			</select>
			<br/>
			<label>Amount to change:</label>
			<input type="number" name="amount_to_change" />
			<br/>
			<label>Currency</label>
			<select id="currency" name="currency">
			  <option value="BGN">BGN</option>
			  <option value="EUR">EUR</option>
			</select>
			<br/>
			<input type="submit" value="Submit" />
		</form:form>
	</body>
</html>