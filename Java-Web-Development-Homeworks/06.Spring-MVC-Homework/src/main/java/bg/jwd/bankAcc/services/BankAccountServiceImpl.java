package bg.jwd.bankAcc.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import bg.jwd.bankAcc.entities.User;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	private static List<User> users = new ArrayList<>();

	@Override
	public void deposite(User user, double amount) throws Exception {
		if (amount > 0) {
			user.setAmount(amount);
		} else {
			throw new Exception("Invalid amount");
		}
	}

	@Override
	public void withdraw(User user, double amount, HttpServletRequest servletReq) throws Exception {
		double userAmount = user.getAmount();
		double userAmountfromSession = (double) servletReq.getSession().getAttribute("userAmount");
		double halfOfUserAmount = userAmountfromSession / 2;

		if (userAmount < amount) {
			throw new Exception("Withdraw money is more than your amount!");
		} else if (amount < 0) {
			throw new Exception("Withdraw money should be positive!");
		} else if (userAmount > halfOfUserAmount) {
			throw new Exception("Your limit for today is exhausted!");
		}

		userAmount -= amount;
		user.setAmount(userAmount);

	}

}