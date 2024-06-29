package jsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class admin
 */
@WebServlet("/admin")
public class admin extends HttpServlet {
	public void service(HttpServletRequest rq,HttpServletResponse rs) throws ServletException, IOException
	{
		String a= rq.getParameter("t1");
		String b = rq.getParameter("t2");
		String c="Admin";
		String d="admin@123";
		if(a.equals(c)&&b.equals(d))
		{
			RequestDispatcher rd= rq.getRequestDispatcher("admin2.html");
			rd.forward(rq, rs);
		}
		else
		{
			RequestDispatcher rd =rq.getRequestDispatcher("invalidadmin.html");
					rd.forward(rq, rs);
		}
	}

}
