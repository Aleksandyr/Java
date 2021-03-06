package bg.jwd.webBank.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import bg.jwd.webBank.entities.Account;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Override
	public void deposite(Account acc, double amount) {
		double currAmount = acc.getInitialAmount();
		if (amount > 0) {
			currAmount += amount;
			acc.setInitialAmount(currAmount);
		}
	}

	@Override
	public void withdraw(Account acc, double amount, HttpServletRequest request) {
		double userAmount = acc.getInitialAmount();
		double getMoneyFromSession = (Double) request.getSession().getAttribute("balance_per_day");
		double halfOfUserAmount = getMoneyFromSession / 2;

		if (userAmount > amount && amount > 0 && ((userAmount - amount) > halfOfUserAmount)) {
			userAmount -= amount;
			acc.setInitialAmount(userAmount);
		}
	}

}
