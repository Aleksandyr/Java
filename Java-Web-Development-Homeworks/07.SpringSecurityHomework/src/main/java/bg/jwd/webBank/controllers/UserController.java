package bg.jwd.webBank.controllers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.webBank.entities.User;

@Controller
public class UserController extends BaseController {

	@Autowired
	private UserDetailsService userDetails;

	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public String getRegisterUser() {
		return "registerUser";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));

		String hashedPassword = this.getMD5(password);
		User user = new User(username, hashedPassword, authorities);

		this.db.addUser(user);

		userDetails.loadUserByUsername(username);

		return "redirect:/registerPage";
	}

	private String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
