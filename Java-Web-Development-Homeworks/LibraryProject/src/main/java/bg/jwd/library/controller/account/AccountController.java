package bg.jwd.library.controller.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.library.constants.UrlConstants;

@Controller
@RequestMapping(UrlConstants.BASE_ACCOUNT_URL)
public class AccountController {

	@RequestMapping(value = UrlConstants.USER_LOGIN_URL, method = RequestMethod.GET)
	public String loginPage(HttpServletRequest request) {
		return "/user/login";
	}

	@RequestMapping(value = UrlConstants.USER_LOGOUT_URL, method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);

		if (session != null) {
			session.invalidate();
		}

		return "redirect:" + UrlConstants.BASE_ACCOUNT_URL + UrlConstants.USER_LOGIN_URL;
	}
}