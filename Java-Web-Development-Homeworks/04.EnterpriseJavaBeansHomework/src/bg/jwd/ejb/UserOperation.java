package bg.jwd.ejb;

import java.util.Map;

import javax.ejb.Local;

@Local
public interface UserOperation {
	
	Double getUserAmount(Map<String, Double> users, String username);
}
