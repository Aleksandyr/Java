package bg.jwd.webBank;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.webBank.controllers.BaseController;
import bg.jwd.webBank.entities.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	@Secured("ROLE_BANK_EMPLOYEE")
	@RequestMapping(value = "/allAccounts", method = RequestMethod.GET)
	public String allAccounts(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();

		model.addAttribute("accounts", this.db.getAllAccounts());
		model.addAttribute("user", user);

		return "home";
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "/userAccounts", method = RequestMethod.GET)
	public String userAccounts(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();

		model.addAttribute("userAccounts", this.db.getUser(user.getUsername()).getAccounts());
		model.addAttribute("user", user);

		return "home";
	}

}
