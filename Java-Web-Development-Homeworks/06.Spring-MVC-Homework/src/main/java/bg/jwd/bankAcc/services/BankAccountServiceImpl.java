package bg.jwd.bankAcc.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import bg.jwd.bankAcc.entities.User;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Override
	public void deposite(User user, double amount) throws Exception {
		double currAmount = user.getAmount();
		if (amount > 0) {
			currAmount += amount;
			user.setAmount(currAmount);
		} else {
			throw new Exception("Invalid amount");
		}
	}

	@Override
	public void withdraw(User user, double amount, HttpServletRequest request) throws Exception {
		double userAmount = user.getAmount();
		double getMoneyFromSession = (Double) request.getSession().getAttribute("balance_per_day");
		double halfOfUserAmount = getMoneyFromSession / 2;

		if (userAmount < amount) {
			throw new Exception("Withdraw money is more than your amount!");
		} else if (amount < 0) {
			throw new Exception("Withdraw money should be positive!");
		} else if ((userAmount - amount) <= halfOfUserAmount) {
			throw new Exception("Your limit for today is exhausted, "
					+ "or you want to withdraw more than you can!");
		}

		userAmount -= amount;
		user.setAmount(userAmount);

	}

}
