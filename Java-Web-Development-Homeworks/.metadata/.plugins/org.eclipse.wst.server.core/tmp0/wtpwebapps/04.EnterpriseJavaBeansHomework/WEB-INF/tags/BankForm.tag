<form action="../BankOperationController" method="POST">
	<label>Client name:</label>
	<input type="text" name="client_name" />
	<br/>
	<label>Deposit or withdraw:</label>
	<select id="deposti_withdraw" name="deposti_withdraw">
	  <option value="deposit">Deposit</option>
	  <option value="withdraw">Withdraw</option>
	</select>
	<br/>
	<label>Amount to change:</label>
	<input type="number" name="amount_to_change" />
	<br/>
	<input type="submit" value="Submit" />
</form>
