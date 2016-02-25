package bg.jwd.bankAcc.controllers;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.bankAcc.entities.User;
import bg.jwd.bankAcc.services.BankAccountService;

@Controller
public class BankAccountController {

	@Autowired
	private BankAccountService bankAccService;

	private Map<User, Double> users;

	public BankAccountController() {
		this.initializeUsers();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "home";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String checkStudent(Model model, @ModelAttribute("user") User user) {
		// Very basic register just for the homework!!!
		String username = user.getName();
		User newUser = new User();
		newUser.setName(username);
		this.users.put(newUser, (double) 0);

		return "home";
	}

	@RequestMapping(value = "/bankOperation", method = RequestMethod.POST)
	public String bankOperation(Model model, @ModelAttribute("user") User user, HttpServletRequest request)
			throws Exception {
		String username = user.getName();
		User getUser = null;

		for (User currUser : this.users.keySet()) {
			if (currUser.getName().equals(username)) {
				getUser = currUser;
			}
		}

		// Register new user
		if (getUser == null) {
			return "registerUser";
		}

		request.getSession().setAttribute("balance_per_day", this.users.get(getUser));

		String operation = request.getParameter("deposit_withdraw");
		String amountToChange = request.getParameter("amount_to_change");
		double convertedAmount = Double.parseDouble(amountToChange);

		if (operation.equals("deposit")) {
			this.bankAccService.deposite(getUser, convertedAmount);
		} else if (operation.equals("withdraw")) {
			this.bankAccService.withdraw(getUser, convertedAmount, request);
		}

		request.getSession().setAttribute("client_name", username);
		request.getSession().setAttribute("amount_to_change", getUser.getAmount());

		return "home";
	}

	private void initializeUsers() {
		this.users = new HashMap<User, Double>();

		User user1 = new User();
		user1.setId(1);
		user1.setName("pesho");
		user1.setAmount(1000);

		User user2 = new User();
		user2.setId(2);
		user2.setName("misho");
		user2.setAmount(1000);

		User user3 = new User();
		user3.setId(3);
		user3.setName("tosho");
		user3.setAmount(1000);

		this.users.put(user1, user1.getAmount());
		this.users.put(user2, user2.getAmount());
		this.users.put(user3, user3.getAmount());
	}
}
