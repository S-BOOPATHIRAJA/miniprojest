package datapack;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DocLoginCon
 */
@WebServlet("/DocLoginCon")
public class DocLoginCon extends HttpServlet {
	public void service (HttpServletRequest rq, HttpServletResponse res) throws ServletException, IOException
	{
		String email = rq.getParameter("email");
		String pass = rq.getParameter("pass");
		DoctorDao dd=new DoctorDao();
		boolean result=dd.checkDoc(email, pass);
		String url="";
		if(result==true) {
			url="DoctorProfile.jsp";
			rq.setAttribute("email", email);
		}
		else {
			
			url="InvalidDocLogin.jsp";
		}
		
		RequestDispatcher rd=rq.getRequestDispatcher(url);
		rd.forward(rq, res);
	}
}
