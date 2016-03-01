package bg.jwd.webBank.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.webBank.entities.Account;
import bg.jwd.webBank.entities.User;

@Controller
public class WebBankController extends BaseController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {

		return "registerPage";
	}

	@RequestMapping(value = "/registerPage", method = RequestMethod.POST)
	public String registerPage(HttpServletRequest request) {
		String username = request.getParameter("username");
		String accountNumber = request.getParameter("acc_number");

		User user = this.db.getUser(username);
		Account acc = this.db.getAccount(accountNumber);

		if (user == null) {
			return "redirect:/registerUser";
		}

		if (acc == null) {
			request.setAttribute("user", user);
			return "redirect:/registerAccount";
		}

		if (user.getAccount() == null) {
			this.db.getUser(username).setAccount(acc);
		}

		return "registerPage";
	}
}