package bg.jwd.ejb;

import java.util.Map;

import javax.ejb.Stateful;

@Stateful
public class UserOperationImpl implements UserOperation {

	@Override
	public Double getUserAmount(Map<String, Double> users, String username) {
	
		return users.get(username);
	}

}
