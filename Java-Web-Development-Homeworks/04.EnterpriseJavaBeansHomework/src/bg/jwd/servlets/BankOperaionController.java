package bg.jwd.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bg.jwd.ejb.BankOperation;

@WebServlet("/BankOperationController")
public class BankOperaionController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 177521010322536851L;

	private Map<String, Double> users;
	
	public BankOperaionController(){
		this.users = new HashMap<String, Double>();
		this.users.put("pesho", 1000d);
		this.users.put("misho", 2000d);
		this.users.put("tosho", 3000d);
		
	}
	
	@EJB
	private BankOperation bankOperation;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		
		String clientName = (String) servletRequest.getParameter("client_name");
		String action = (String) servletRequest.getParameter("deposti_withdraw");
		String amountToChange = (String) servletRequest.getParameter("amount_to_change");
		
		if(clientName.equals("") && amountToChange.equals("")){
			servletRequest.getSession().setAttribute("client_name", "No user");
			servletRequest.getSession().setAttribute("amount_to_change", "No amount");
			((HttpServletResponse) response).sendRedirect("/04.EnterpriseJavaBeansHomework/pages/BankingPage.jsp");
			return;
		}
		
		Boolean checkIfUserExist = this.users.get(clientName) == null;
		
		if(checkIfUserExist){
			this.users.put(clientName, 0d);
		}
		
		double convertedAmount = Double.parseDouble(amountToChange);
		
		if(action.equals("deposit")){
			this.bankOperation.deposite(this.users, clientName, convertedAmount);
		} else if (action.equals("withdraw")){
			this.bankOperation.withdraw(this.users, clientName, convertedAmount);
		}
		
		servletRequest.getSession().setAttribute("client_name", clientName);
		servletRequest.getSession().setAttribute("amount_to_change", this.users.get(clientName));
		
		((HttpServletResponse) response).sendRedirect("/04.EnterpriseJavaBeansHomework/pages/BankingPage.jsp");

	}
}
