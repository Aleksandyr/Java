package bg.jwd.webBank.database;

import java.util.ArrayList;
import java.util.List;

import bg.jwd.webBank.entities.Account;
import bg.jwd.webBank.entities.User;

public class WebBankDatabase {

	private List<User> users;
	private List<Account> accounts;

	public WebBankDatabase() {
		this.users = new ArrayList<>();
		this.accounts = new ArrayList<>();
	}

	public User getUser(String username) {
		User currUser = null;
		for (User userItem : this.users) {
			if (userItem.getUsername().equals(username)) {
				currUser = userItem;
			}
		}

		return currUser;
	}

	public Account getAccount(String accNumber) {
		Account curAcc = null;
		for (Account accItem : this.accounts) {
			if (accItem.getAccNumber().equals(accNumber)) {
				curAcc = accItem;
			}
		}

		return curAcc;
	}

	public List<Account> getAccountsFromUser(User user) {
		User currUser = this.getUser(user.getUsername());

		return currUser.getAccounts();
	}

	public List<User> getAllUsers() {
		return this.users;
	}

	public List<Account> getAllAccounts() {
		return this.accounts;
	}

	public void addUser(User user) {
		this.users.add(user);
	}

	public void addAccount(Account acc) {
		this.accounts.add(acc);
	}

	public void addAccToUser(User user, Account account) {
		User currUser = this.getUser(user.getUsername());
		currUser.getAccounts().add(account);
	}
}
