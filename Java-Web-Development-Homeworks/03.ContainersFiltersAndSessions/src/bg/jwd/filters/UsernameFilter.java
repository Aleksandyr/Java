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

@WebFilter("/pages/HomePage.jsp")
public class UsernameFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String username = (String) httpRequest.getSession().getAttribute("username");
		String requestUsername = request.getParameter("username");
		
		if(username == null && requestUsername == null){
			((HttpServletResponse) response).sendRedirect("SetUsername.jsp");
		} else if(requestUsername != null){
			httpRequest.getSession().setAttribute("username", requestUsername);
		}
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
