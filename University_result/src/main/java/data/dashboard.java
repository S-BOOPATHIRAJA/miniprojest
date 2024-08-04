package data;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class dashboard
 */
@WebServlet("/dashboard")
public class dashboard extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		PrintWriter pw=res.getWriter();
		RequestDispatcher rd=req.getRequestDispatcher("general.html");
		rd.include(req, res);
		HttpSession hs=req.getSession(false);
		if(hs!=null) {
			RequestDispatcher r=req.getRequestDispatcher("welcome.jsp");
			r.forward(req, res);
		//String s=(String) hs.getAttribute("bbb");
		//pw.print("Welcome.."+s);
		}
		else {
			RequestDispatcher rd1=req.getRequestDispatcher("Dashboard.html");
			rd1.forward(req, res);
			//pw.print("opps! you need to login");
			//RequestDispatcher rs=req.getRequestDispatcher("index2.html");
			//rs.forward(req, res);
			
			
		}
	}

}
