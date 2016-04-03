package bg.jwd.library;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.library.constants.UrlConstants;

@Controller
public class LoginController {

	@RequestMapping(value = UrlConstants.USER_LOGIN_URL, method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
}