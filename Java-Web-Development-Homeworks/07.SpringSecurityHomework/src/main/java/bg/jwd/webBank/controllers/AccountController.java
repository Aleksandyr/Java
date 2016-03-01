package bg.jwd.webBank.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.webBank.entities.Account;

@Controller
public class AccountController extends BaseController {

	@RequestMapping(value = "/registerAccount", method = RequestMethod.GET)
	public String getRegisterAccount() {
		return "registerAccount";
	}

	@RequestMapping(value = "/registerAccount", method = RequestMethod.POST)
	public String registerAccount(HttpServletRequest request, @ModelAttribute("account") Account account) {
		this.db.addAccount(account);

		return "redirect:/home";
	}
}
