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

		Account acc = this.db.getAccount(accNum);

		if (acc == null) {
			return "redirect:/registerAccount";
		}

		request.getSession().setAttribute("balance_per_day", acc.getInitialAmount());

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
}
