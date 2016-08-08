/*
 * Servlet to access all the stats for a particular user
 */
package print;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/UserStat"})
public class GetUserPrintStat extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = (String) req.getSession().getAttribute("user");
		if(user.equals("admin")){
			resp.sendRedirect("userSerial.jsp");
		}
		else{
			resp.sendRedirect("userHome.jsp");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String serial = (String) req.getSession().getAttribute("theSerial");
		PrintDataStatistic stat = ReadJSON.getStatistics(Integer.parseInt(serial));
		req.setAttribute("stat", stat);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/displayStat.jsp");
		rd.forward(req, resp);
	}
}
