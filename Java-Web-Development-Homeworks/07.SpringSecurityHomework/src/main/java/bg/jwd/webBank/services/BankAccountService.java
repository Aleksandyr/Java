package bg.jwd.webBank.services;

import javax.servlet.http.HttpServletRequest;

import bg.jwd.webBank.entities.Account;

public interface BankAccountService {
	void deposite(Account acc, double amount);

	void withdraw(Account acc, double amount, HttpServletRequest request);
}
