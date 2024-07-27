package datapack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DocForgetPass
 */
@WebServlet("/DocForgetPass")
public class DocForgetPass extends HttpServlet {
	public void service(HttpServletRequest rq, HttpServletResponse res) throws ServletException, IOException
	{
		String email=rq.getParameter("email1");
		String pass=rq.getParameter("pass1");
		DoctorDao dd=new DoctorDao();
	    boolean result= dd.verifyEmail(email);
	    String url="";
		if(result==true) {
			dd.updatePass(pass, email);
			url="DocLogin.jsp";
		}
		else {
			
			url="InvalidEmail.html";
		}
		
		RequestDispatcher rd=rq.getRequestDispatcher(url);
		rd.forward(rq, res);
	}
}
