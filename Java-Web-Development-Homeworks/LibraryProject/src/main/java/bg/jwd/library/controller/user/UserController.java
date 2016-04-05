package bg.jwd.library.controller.user;

import javax.servlet.http.HttpServletRequest;

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
	public String getAllUsersPage(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		model.addAttribute("userRegisterUrl", UrlConstants.USER_REGISTER_URL);
		model.addAttribute("addUserUrl", UrlConstants.ADD_USER_URL);
		model.addAttribute("user", UserUtils.getUser());

		return "users";
	}

	@RequestMapping(value = UrlConstants.DELETE_USER_URL + "/{id}", method = RequestMethod.GET)
	public String deleteUserPage(@PathVariable("id") long userId, Model model) {

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
			return "redirect:" + UrlConstants.BASE_USER_URL + UrlConstants.ALL_USERS_URL;

		} else {
			return "delete";
		}
	}

	@RequestMapping(value = UrlConstants.EDIT_USER_URL + "/{id}", method = RequestMethod.GET)
	public String editUserPage(@PathVariable("id") long userId, Model model) {

		AutoUser user = this.userService.getUserById(userId);

		if (user != null) {
			model.addAttribute("user", user);

			return "editUserAdmin";

		} else {
			return "redirect:" + UrlConstants.BASE_HOME_URL + UrlConstants.HOME_URL;
		}
	}

	@RequestMapping(value = UrlConstants.EDIT_USER_URL + "/{id}", method = RequestMethod.POST)
	public String editUser(@PathVariable("id") long userId, Model model, HttpServletRequest request) {

		int status = Integer.parseInt(request.getParameter("status_select"));
		Boolean isEdited = this.userService.editUserFromAdminById(userId, status);

		if (isEdited == true) {
			return "redirect:" + UrlConstants.BASE_USER_URL + UrlConstants.ALL_USERS_URL;

		} else {
			return "editUserAdmin";
		}
	}
}