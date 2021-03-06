package bg.jwd.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bg.jwd.ejb.DateCollection;
import bg.jwd.ejb.StatelessHelloWorld;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 304140117876337064L;
	
	@EJB
	private StatelessHelloWorld statelessHelloWorld;
	
	@EJB
	private DateCollection dateCollection;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		String id = servletRequest.getSession().getId();
		response.getWriter().println(statelessHelloWorld.sessionIdWithDate(id));
		response.getWriter().println(dateCollection.addAndReturn());
	}

}
