package bg.jwd.ejb;

import javax.ejb.Local;

@Local
public interface StatelessHelloWorld {
	String sessionIdWithDate(String id);
}
