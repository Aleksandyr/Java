package bg.jwd.ejb;

import java.util.Date;

import javax.ejb.Stateless;

@Stateless
public class StatelessHelloWorldImpl implements StatelessHelloWorld {

	@Override
	public String sessionIdWithDate(String id) {
		return "Session ID: " + id + "\ndate: " + new Date();
	}

}
