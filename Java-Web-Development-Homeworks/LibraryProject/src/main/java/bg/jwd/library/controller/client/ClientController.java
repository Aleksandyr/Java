package bg.jwd.library.controller.client;

import org.springframework.beans.factory.annotation.Autowired;

import bg.jwd.library.service.user.UserService;

public class ClientController {

	@Autowired
	private UserService userService;

	// @RequestMapping(value = UrlConstants.USER_REGISTER_URL, method =
	// RequestMethod.GET)
	// public String getUsers(Model model, @ModelAttribute("UserSearch")
	// UserSearch userSearch) {
	// model.addAttribute("users",
	// userService.getUsers(userSearch.getUsername(), userSearch.getStatus()));
	// model.addAttribute("userRegisterUrl", UrlConstants.USER_REGISTER_URL);
	// model.addAttribute("addUserUrl", UrlConstants.ADD_USER_URL);
	// model.addAttribute("user", UserUtils.getUser());
	//
	// return "userRegister";
	// }
}
