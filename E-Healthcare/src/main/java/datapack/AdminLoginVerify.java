package datapack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLoginVerify
 */
@WebServlet("/AdminLoginVerify")
public class AdminLoginVerify extends HttpServlet {
	public void service(HttpServletRequest rq, HttpServletResponse res) throws ServletException, IOException
	{
		String email= rq.getParameter("email");
		String pass = rq.getParameter("pass");
		String url="";
		if((email.equals("iamadmin@gmail.com"))&&(pass.equals("adminakki")))
		{
			url="Admin.html";
		}
		else
		{
			url="InvalidAdminLogin.html";
		}
		RequestDispatcher rd = rq.getRequestDispatcher(url);
		rd.forward(rq, res);
	}
}
