package bg.jwd.webBank.dao;

import java.util.List;

import bg.jwd.webBank.entities.Account;

public class BankDaoImpl implements BankDao {

	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String USERNAME = "db";
	public static final String PASSWORD = "db";

	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean createAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deposite(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean withdraw(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

}
