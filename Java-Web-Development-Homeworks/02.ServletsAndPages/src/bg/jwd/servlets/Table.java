package bg.jwd.servlets;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Table")
public class Table extends HttpServlet {
	
	private static final long serialVersionUID = -8869225566462175309L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		response.getWriter().println(formatDynamicContent());
	}
	
	private String formatDynamicContent(){
		StringBuilder builder = new StringBuilder();
		builder.append("<html>");
		builder.append("<head><title>").append("Table").append("</title></head>");
		builder.append("<body>");
		builder.append("<table border=1>");
		builder.append("<tr>");
		builder.append("<th>").append("Topic").append("</th>");
		builder.append("<th>").append("Date").append("</th>");
		builder.append("</tr>");
		builder.append("<tr>");
		builder.append("<td>").append("Java web development").append("</td>");
		builder.append("<td>").append(new Date()).append("</td>");
		builder.append("</tr>");
		builder.append("</table>");
		builder.append("</body>");
		builder.append("</html>");
		
		return builder.toString();
	}

}
