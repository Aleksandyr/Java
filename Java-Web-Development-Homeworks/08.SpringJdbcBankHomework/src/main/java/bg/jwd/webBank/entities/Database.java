package bg.jwd.webBank.entities;

import bg.jwd.webBank.database.WebBankDatabase;

public class Database {

	private static WebBankDatabase db = new WebBankDatabase();;

	public static WebBankDatabase getDatabase() {
		return db;
	}
}
