package bg.jwd.webBank.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.webBank.entities.Account;
import bg.jwd.webBank.entities.User;

@Controller
public class AccountController extends BaseController {

	@Autowired
	private UserDetailsService userDetails;

	@Secured("ROLE_BANK_EMPLOYEE")
	@RequestMapping(value = "/registerAccount", method = RequestMethod.GET)
	public String getRegisterAccount() {
		return "registerAccount";
	}

	@Secured("ROLE_BANK_EMPLOYEE")
	@RequestMapping(value = "/registerAccount", method = RequestMethod.POST)
	public String registerAccount(HttpServletRequest request, @ModelAttribute("account") Account account) {
		this.db.addAccount(account);

		return "redirect:/";
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "/getAccount", method = RequestMethod.POST)
	public String getAccount(HttpServletRequest request) {
		String accNumber = request.getParameter("accounts");
		Account acc = this.db.getAccount(accNumber);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();

		if (acc != null) {
			this.db.addAccToUser(user, acc);
		}

		return "redirect:/";
	}
}
