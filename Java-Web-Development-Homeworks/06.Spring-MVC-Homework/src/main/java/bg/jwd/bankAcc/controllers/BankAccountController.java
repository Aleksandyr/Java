package bg.jwd.bankAcc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import bg.jwd.bankAcc.services.BankAccountService;

@Controller
public class BankAccountController {

	@Autowired
	private BankAccountService bankAccService;

	public String deposite(Model model) {
		return "BankPage";
	}
}
