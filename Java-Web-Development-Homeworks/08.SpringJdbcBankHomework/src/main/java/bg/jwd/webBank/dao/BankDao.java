package bg.jwd.webBank.dao;

import java.util.List;

import bg.jwd.webBank.entities.Account;

public interface BankDao {
	public List<Account> getAllAccounts();

	public Boolean createAccount(Account account);

	public Boolean deposite(Account account);

	public Boolean withdraw(Account account);
}