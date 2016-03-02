package bg.jwd.webBank.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.webBank.entities.Account;
import bg.jwd.webBank.services.BankAccountService;

@Controller
public class BankOperationController extends BaseController {

	@Autowired
	private BankAccountService bankOperation;

	@RequestMapping(value = "/bankOperation", method = RequestMethod.GET)
	public String getRegisterUser() {
		return "bankOperation";
	}

	@RequestMapping(value = "/bankOperation", method = RequestMethod.POST)
	public String registerUser(Model model, HttpServletRequest request) {
		String accNum = request.getParameter("accNumber");
		String operation = request.getParameter("deposit_withdraw");
		Double amount = Double.parseDouble(request.getParameter("amount_to_change"));
		String userInputCurrency = request.getParameter("currency");

		Account acc = this.db.getAccount(accNum);

		if (acc == null) {
			return "redirect:/registerAccount";
		}

		request.getSession().setAttribute("balance_per_day", acc.getInitialAmount());

		Double currencyCalcAmount = this.currencyChecker(userInputCurrency, acc);
		amount *= currencyCalcAmount;
		if (operation.equals("deposit")) {
			bankOperation.deposite(acc, amount);
		} else if (operation.equals("withdraw")) {
			bankOperation.withdraw(acc, amount, request);
		}

		request.getSession().setAttribute("accNum", acc.getAccNumber());
		request.getSession().setAttribute("accInitAmount", acc.getInitialAmount());

		// this.db.addUser(user);

		return "redirect:/home";
	}

	private Double currencyChecker(String userInputCurrency, Account acc) {
		Double valueToAdd = 1.0;
		String accCurrency = acc.getCurrency().toLowerCase();

		if (accCurrency.equals("bgn")) {
			if (userInputCurrency.toLowerCase().equals("eur")) {
				valueToAdd = 1.92;
			}
		}

		if (accCurrency.equals("eur")) {
			if (userInputCurrency.toLowerCase().equals("bgn")) {
				valueToAdd = 0.51;
			}
		}

		return valueToAdd;
	}
}