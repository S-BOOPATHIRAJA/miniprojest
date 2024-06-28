package datapack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class verifylogin
 */
@WebServlet("/verifylogin")
public class verifylogin extends HttpServlet {
	public void service(HttpServletRequest rq,HttpServletResponse rs)
	{
		String uname=rq.getParameter("f1");
		String pass=rq.getParameter("f2");
		String out="";
		if(!((uname.equals(out))||(pass.equals(out))))
		{
		try {
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/akki","root","root");
		     String st="select * from login";
		     PreparedStatement ps=cn.prepareStatement(st);
		     ResultSet res =ps.executeQuery();
		     int flag=0;
		     while(res.next())
		     {
		    	 String id=res.getString(1);
		    	 String pas=res.getString(2);
		    	 if(id.equals(uname)&&pas.equals(pass))
		    	 {
		    		 flag=1;
		    		 RequestDispatcher rd=rq.getRequestDispatcher("welcome.html");
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
		     }
		     if(flag!=1)
		     {
		    	 RequestDispatcher rd1=rq.getRequestDispatcher("home2.html");
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
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		else
		{ 
			RequestDispatcher rd1=rq.getRequestDispatcher("home2.html");
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
