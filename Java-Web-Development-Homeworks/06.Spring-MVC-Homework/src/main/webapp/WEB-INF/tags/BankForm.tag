<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form method="POST" action="bankOperation" modelAttribute="user">
	<label>Client name:</label>
	<input type="text" name="name" />
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
	<input type="submit" value="Submit" />
</form:form>
