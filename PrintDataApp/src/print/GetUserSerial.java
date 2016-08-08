/*
 * Servlet for admin home page, sets the serial for session and navigates to data and report pages
 */
package print;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/UserSession"})	
public class GetUserSerial extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String serial = req.getParameter("serial");
		if(!serial.equals("")||!serial.isEmpty()){
			req.getSession().setAttribute("theSerial", serial);
			if(req.getParameter("first") != null){
				resp.sendRedirect("displayData");
			}else if(req.getParameter("second") != null){
				resp.sendRedirect("displayStat");
			}
		}
		else if(req.getParameter("third") != null){
			resp.sendRedirect("login.jsp");
		}
		else{
			resp.sendRedirect("userSerial.jsp");
		}
	}
}
