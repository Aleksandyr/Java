package bg.jwd.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/pages/HomePageAfterLogin.jsp")
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		String username = (String) httpRequest.getSession().getAttribute("username");
		String password = (String) httpRequest.getSession().getAttribute("password");
		
		String requestUsername = request.getParameter("username");
		String requestPassword = request.getParameter("password");
		
		if(username == null && requestUsername == null && password == null){
			((HttpServletResponse) response).sendRedirect("Login.jsp");
		} else if(requestUsername != null && requestPassword != null){
			httpRequest.getSession().setAttribute("username", requestUsername);
			httpRequest.getSession().setAttribute("password", requestPassword);
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
