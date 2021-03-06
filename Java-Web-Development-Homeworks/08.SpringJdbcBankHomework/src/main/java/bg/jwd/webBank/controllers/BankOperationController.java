package bg.jwd.webBank.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.webBank.entities.Account;
import bg.jwd.webBank.entities.User;
import bg.jwd.webBank.services.BankAccountService;

@Controller
public class BankOperationController extends BaseController {
	private static final Double BGN_TO_EUR_VALUE = 1.92;
	private static final Double EUR_TO_BGN_VALUE = 0.51;

	@Autowired
	private BankAccountService bankOperation;

	@Secured("ROLE_USER")
	@RequestMapping(value = "/bankOperation", method = RequestMethod.GET)
	public String getRegisterUser(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();

		model.addAttribute("myAccounts", this.db.getUser(user.getUsername()).getAccounts());

		return "bankOperation";
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "/bankOperation", method = RequestMethod.POST)
	public String registerUser(Model model, HttpServletRequest request) {
		String accNum = request.getParameter("myAcc");
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

		return "redirect:/registerPage";
	}

	private Double currencyChecker(String userInputCurrency, Account acc) {
		Double valueToAdd = 1.0;
		String accCurrency = acc.getCurrency().toLowerCase();

		if (accCurrency.equals("bgn")) {
			if (userInputCurrency.toLowerCase().equals("eur")) {
				valueToAdd = BGN_TO_EUR_VALUE;
			}
		}

		if (accCurrency.equals("eur")) {
			if (userInputCurrency.toLowerCase().equals("bgn")) {
				valueToAdd = EUR_TO_BGN_VALUE;
			}
		}

		return valueToAdd;
	}
}
