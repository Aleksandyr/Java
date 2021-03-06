package bg.jwd.bankAcc.services;

import javax.servlet.http.HttpServletRequest;

import bg.jwd.bankAcc.entities.User;

public interface BankAccountService {
	void deposite(User user, double amount) throws Exception;

	void withdraw(User user, double amount, HttpServletRequest request) throws Exception;
}
