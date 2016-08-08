/*
 * Servlet for the login page. Communicates to AccessLoginCreds and checks if a valid user.
 */
package print;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/Login"})
public class Login extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("userpassword");
		AccessLoginCreds aLC = new AccessLoginCreds();
		HashMap<String, String> logins = aLC.getLogins();
		if(username.equals("admin")){
			if(logins.get(username).equals(password)){
				req.getSession().setAttribute("theSerial", username);
				req.getSession().setAttribute("user", username);
				resp.sendRedirect("userSerial.jsp");
			}
		}
		else if(logins.containsKey(username)){
			if(logins.get(username).equals(password)){
				req.getSession().setAttribute("theSerial", username);
				req.getSession().setAttribute("user", username);
				resp.sendRedirect("userHome.jsp");
			}
		}
		else{
			resp.getWriter().println("Incorrect username or password");
		}
	}
}
