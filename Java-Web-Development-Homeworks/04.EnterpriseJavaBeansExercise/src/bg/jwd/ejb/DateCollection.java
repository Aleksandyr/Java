package bg.jwd.ejb;

import javax.ejb.Local;

@Local
public interface DateCollection {
	String addAndReturn();
}