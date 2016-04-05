package bg.jwd.library.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.library.constants.UrlConstants;
import bg.jwd.library.entity.user.AutoUser;
import bg.jwd.library.service.user.UserService;
import bg.jwd.library.utils.UserUtils;

@Controller
@RequestMapping(UrlConstants.BASE_USER_URL)
@Secured("ROLE_ADMIN")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = UrlConstants.ALL_USERS_URL, method = RequestMethod.GET)
	public String getAllUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		model.addAttribute("userRegisterUrl", UrlConstants.USER_REGISTER_URL);
		model.addAttribute("addUserUrl", UrlConstants.ADD_USER_URL);
		model.addAttribute("user", UserUtils.getUser());

		return "users";
	}

	@RequestMapping(value = UrlConstants.DELETE_USER_URL + "/{id}", method = RequestMethod.GET)
	public String deletePage(@PathVariable("id") long userId, Model model) {

		AutoUser user = this.userService.getUserById(userId);

		if (user != null) {
			model.addAttribute("user", user);

			return "delete";

		} else {
			return "redirect:" + UrlConstants.BASE_HOME_URL + UrlConstants.HOME_URL;
		}
	}

	@RequestMapping(value = UrlConstants.DELETE_USER_URL + "/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable("id") long userId, Model model) {

		Boolean isDeleted = this.userService.deleteUserById(userId);

		if (isDeleted == true) {
			return "redirect:" + UrlConstants.BASE_HOME_URL + UrlConstants.HOME_URL;

		} else {
			return "delete";
		}
	}
}