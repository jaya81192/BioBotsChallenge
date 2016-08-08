/*
 * Servlet for user home page, navigates to user data and report pages
 */
package print;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/UserHome"})	
public class UserHomePage extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String serial = (String) arg0.getSession().getAttribute("theSerial");
		if(arg0.getParameter("third") != null){
			arg1.sendRedirect("login.jsp");
		}
		else if(!serial.equals("")||!serial.isEmpty()){
			arg0.getSession().setAttribute("theSerial", serial);
			if(arg0.getParameter("first") != null){
				arg1.sendRedirect("displayData");
			}else if(arg0.getParameter("second") != null){
				arg1.sendRedirect("displayStat");
			}
		}
		else{
			arg1.sendRedirect("login.jsp");
		}
	}
}
