package bg.jwd.ejb;

import java.util.Map;

import javax.ejb.Local;

@Local
public interface BankOperation {
	void deposite(Map<String, Double> users, String currentUser, double depositMoney);
	
	void withdraw(Map<String, Double> users, String currentUser, double withdrawMoney);
}
