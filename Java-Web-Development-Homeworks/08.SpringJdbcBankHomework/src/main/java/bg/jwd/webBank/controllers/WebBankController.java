package bg.jwd.webBank.controllers;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.webBank.entities.Account;
import bg.jwd.webBank.entities.User;

@Controller
public class WebBankController extends BaseController {

	@RequestMapping(value = "/registerPage", method = RequestMethod.GET)
	public String registerPage(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();

		List<Account> accounts = this.db.getAllAccounts();

		model.addAttribute("username", user.getUsername());
		model.addAttribute("accounts", accounts);

		return "registerPage";
	}
}
