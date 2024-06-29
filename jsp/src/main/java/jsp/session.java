package jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class session
 */
@WebServlet("/session")
public class session extends HttpServlet {
	public void service(HttpServletRequest rq, HttpServletResponse rs)
	{
		HttpSession hs = rq.getSession();
		
		if(!(hs.getAttribute("one").equals("")))
		{
			RequestDispatcher rd= rq.getRequestDispatcher("myfirst.jsp");
			try {
				rd.forward(rq, rs);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			RequestDispatcher rd1=rq.getRequestDispatcher("welcome.html");
			try {
				rd1.forward(rq, rs);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
}
