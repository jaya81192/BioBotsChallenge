/*
 * Servlet to access all the data for a particular user
 */
package print;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/DataRead"})	
public class GetUserPrintData extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	public GetUserPrintData(){
		super();
	}
	
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
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String serial = (String) req.getSession().getAttribute("theSerial");
		List<PrintData> dataList = ReadJSON.getData(Integer.parseInt(serial));
		req.setAttribute("data", dataList);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/displayData.jsp");
		rd.forward(req, resp);
	}
}