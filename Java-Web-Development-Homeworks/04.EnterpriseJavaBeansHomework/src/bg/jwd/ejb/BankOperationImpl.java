package bg.jwd.ejb;

import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.servlet.http.HttpServletRequest;

@Stateful
public class BankOperationImpl implements BankOperation {

	@EJB
	private UserOperation userOperation;
	
	private double currAmountForUser = 0;
	
	@Override
	public void deposite(Map<String, Double> users, String currentUser, double depositMoney) {
		double userAmount = userOperation.getUserAmount(users, currentUser);
		
		if(depositMoney > 0){
			userAmount += depositMoney;
		}
		
			
		users.put(currentUser, userAmount);
	}

	@Override
	public void withdraw(Map<String, Double> users, String currentUser, double withdrawMoney) {
		double userAmount = userOperation.getUserAmount(users, currentUser);
		double userAllAmound = getCurrAmountFromUser(users, currentUser);
		double userAmountInAHalf = userAllAmound / 2;
		
		if(withdrawMoney > 0 && 
				withdrawMoney <= userAmount &&
				userAmount > userAmountInAHalf){
			
			userAmount -= withdrawMoney;
		}
		
		
		users.put(currentUser, userAmount);
	}	
	
	private Double getCurrAmountFromUser(Map<String, Double> users, String username){
		if(this.currAmountForUser == 0){
			this.currAmountForUser = users.get(username);
		}
		
		return this.currAmountForUser;
	}
}
