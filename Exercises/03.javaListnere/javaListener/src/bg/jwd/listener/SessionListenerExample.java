package bg.jwd.listener;

import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListenerExample implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("Session created. ID: " + 
				event.getSession().getId());
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("Session destroyed at " + new Date() + ". ID: " + 
				event.getSession().getId());
	}

}
