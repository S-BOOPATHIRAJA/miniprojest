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
 * Servlet implementation class logout
 */
@WebServlet("/logout")
public class logout extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=res.getWriter();
		RequestDispatcher rd=req.getRequestDispatcher("general.html");
		
		rd.include(req, res);
		HttpSession hs=req.getSession();
		hs.getAttribute("aaa");
		String str=(String)hs.getAttribute("NAME");
		hs.invalidate();
		
		//pw.println("loggedout successfully");
		RequestDispatcher r=req.getRequestDispatcher("Logout.html");
		r.forward(req, res);
		/*if()
		{
			
		}
		else {
			RequestDispatcher rd1=req.getRequestDispatcher("dashboard");
			rd1.forward(req, res);
		}*/
	}

	
}
