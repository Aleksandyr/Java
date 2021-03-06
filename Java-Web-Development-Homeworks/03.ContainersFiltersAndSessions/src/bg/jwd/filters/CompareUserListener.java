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

@WebFilter("/pages/HomePageAfterCompare.jsp")
public class CompareUserListener implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		String requestUsername = request.getParameter("username");
		String requestPassword = request.getParameter("password");
		
		if(requestUsername == null && requestPassword == null){
			//((HttpServletResponse) response).sendRedirect("CompareLogin.jsp");
		} else if(requestUsername.equals("pesho") && requestPassword.equals("123")){
			httpRequest.getSession().setAttribute("username", requestUsername);
			httpRequest.getSession().setAttribute("password", requestPassword);
			
			//((HttpServletResponse) response).sendRedirect("HomePageAfterCompare.jsp");
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
