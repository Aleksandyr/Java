package bg.jwd.webBank.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.webBank.entities.User;

@Controller
public class UserController extends BaseController {

	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public String getRegisterUser() {
		return "registerUser";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(HttpServletRequest request) {
		String username = request.getParameter("username");

		User user = new User();
		user.setUsername(username);

		this.db.addUser(user);

		return "redirect:/home";
	}
}