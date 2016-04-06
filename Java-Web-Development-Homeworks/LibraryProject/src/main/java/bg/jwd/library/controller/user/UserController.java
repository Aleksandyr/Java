package bg.jwd.library.controller.user;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.library.constants.UrlConstants;
import bg.jwd.library.entity.user.Authority;
import bg.jwd.library.entity.user.AutoUser;
import bg.jwd.library.security.User;
import bg.jwd.library.service.authority.AuthorityService;
import bg.jwd.library.service.user.UserService;
import bg.jwd.library.utils.UserUtils;

@Controller
@RequestMapping(UrlConstants.BASE_USER_URL)
@Secured("ROLE_ADMIN")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthorityService authorityService;

	@RequestMapping(value = UrlConstants.ALL_USERS_URL, method = RequestMethod.GET)
	public String getAllUsersPage(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		model.addAttribute("username", user.getUsername());
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

	@RequestMapping(value = UrlConstants.ADD_USER_URL, method = RequestMethod.GET)
	public String addUserPage(Model model) {

		List<Authority> authorities = this.authorityService.getAllAuthorities();
		model.addAttribute("authorities", authorities);

		return "addUser";
	}

	@RequestMapping(value = UrlConstants.ADD_USER_URL, method = RequestMethod.POST)
	public String addUser(HttpServletRequest request, @ModelAttribute("autoUser") AutoUser user)
			throws UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {

		// Convert password to MD5
		convertPasswordToMD5(user);

		String username = request.getParameter("username");
		AutoUser checkIfUserExist = this.userService.getUserByUsername(username);

		if (checkIfUserExist == null) {
			Boolean isAdded = this.userService.addUser(user);
			AutoUser userFromDb = this.userService.getUserByUsername(username);

			if (isAdded == true) {
				int role = Integer.parseInt(request.getParameter("role"));
				Boolean isUserAddedToRol = this.authorityService.addUserAuthority(userFromDb.getId(), role);

				if (isUserAddedToRol == true) {
					return "redirect:" + UrlConstants.BASE_USER_URL + UrlConstants.ALL_USERS_URL;
				} else {
					return "addUser";
				}
			} else {
				return "addUser";
			}
		} else {
			return "addUser";
		}
	}

	private void convertPasswordToMD5(AutoUser user) throws UnsupportedEncodingException, NoSuchAlgorithmException {

		MessageDigest m = MessageDigest.getInstance("MD5");
		m.reset();
		m.update(user.getPassword().getBytes("UTF-8"));
		byte[] digest = m.digest();
		BigInteger bigInt = new BigInteger(1, digest);
		String hashtext = bigInt.toString(16);

		while (hashtext.length() < 32) {
			hashtext = "0" + hashtext;
		}

		user.setPassword(hashtext.toString());
	}
}