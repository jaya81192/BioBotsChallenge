/*
 * Sign up page, communicates with AccessLoginCreds. 
 * Signs up a user only if the username is a valid serial, user doesn't already exists.
 * Doesn't allow "admin" as a username for sign up
 */
package print;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/SignUp"})
public class SignUp extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("userpassword");
		String email = req.getParameter("email");
		AccessLoginCreds aLC = new AccessLoginCreds();
		if(!username.equals("admin")){
			int done = aLC.addUser(username, password, email);
			if(done==0){
				resp.getWriter().println("User already exists");
			}else if(done == -1){
				resp.getWriter().println("Invalid printer serial");
			}
		}
		else{
			resp.getWriter().println("Cannot use this username");
		}
	}
}
