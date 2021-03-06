package bg.jwd.listeners;

import java.util.*;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestLoggerListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		System.out.println("Ip addres: " + event.getServletRequest().getLocalAddr());
		System.out.println("Session ID: " + ((HttpServletRequest) event.getServletRequest()).getSession().getId());
		System.out.println("Request type: " + ((HttpServletRequest) event.getServletRequest()).getMethod());
		System.out.println("Date and time: " + new Date());
		
		
	}

}
