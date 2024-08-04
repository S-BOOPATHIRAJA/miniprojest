package data;

import java.io.IOException;
import java.io.PrintWriter;

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
	public void service(HttpServletRequest rq,HttpServletResponse re)
	{
		
		HttpSession hts=rq.getSession();
		String diwa=(String)hts.getAttribute("ssss");
		try {
			PrintWriter pw=re.getWriter();
			pw.print(diwa);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
