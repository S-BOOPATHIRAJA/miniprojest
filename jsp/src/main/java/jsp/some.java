package jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class some
 */
@WebServlet("/some")
public class some extends HttpServlet {
	public void service(HttpServletRequest rq,HttpServletResponse rs)
	{
		try {
			int a=Integer.parseInt(rq.getParameter("f1"));
			String b = rq.getParameter("f2");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/akki","root","root");
		     String str="select * from student_details";
		     PreparedStatement ps =cn.prepareStatement(str);
		     ResultSet rsp=ps.executeQuery();
		     int flag=0;
		   
		while(rsp.next())
		{
			int num=rsp.getInt(1);
			String name=rsp.getString(2);
			int mark=rsp.getInt(3);
			
			if(num==a&&b.equals(name))
			{
				//System.out.print(mark);
			   int c=mark;
			   flag=1;
			   HttpSession hs=rq.getSession();
			   hs.setAttribute("one", c);
			   HttpSession hs1=rq.getSession();
			   hs1.setAttribute("two", name);
			   RequestDispatcher rds=rq.getRequestDispatcher("myfirst.jsp");
			   try {
				rds.include(rq, rs);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
				
			}
			if(flag!=1)
			{
				RequestDispatcher rds6=rq.getRequestDispatcher("New.html");
				try {
					rds6.forward(rq, rs);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
