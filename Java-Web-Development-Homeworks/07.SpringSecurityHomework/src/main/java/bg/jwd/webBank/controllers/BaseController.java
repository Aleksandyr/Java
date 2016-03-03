package bg.jwd.webBank.controllers;

import bg.jwd.webBank.database.WebBankDatabase;
import bg.jwd.webBank.entities.Database;

public class BaseController {

	protected WebBankDatabase db;

	public BaseController() {
		db = Database.getDatabase();
	}
}
