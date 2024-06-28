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
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	public void service(HttpServletRequest rq,HttpServletResponse rs)
	{
		String uname=rq.getParameter("m1");
		String pass=rq.getParameter("m2");
		if(!(uname.equals("")||pass.equals("")))
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
		    	 if(id.equals(uname))
		    	 {
		    		 flag=1;
		    		 RequestDispatcher rd=rq.getRequestDispatcher("signup2.html");
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
		     { if(!(uname.equals("")&&pass.equals("")))
		     {
		    	 String str2="insert into login values(?,?)";
		    	 PreparedStatement ps6=cn.prepareStatement(str2);
		    	 ps6.setString(1, uname);
		    	 ps6.setString(2, pass);
		    	 ps6.execute();
		    	 RequestDispatcher rd1=rq.getRequestDispatcher("home.html");
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
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		else
		{ RequestDispatcher rd1=rq.getRequestDispatcher("signup.html");
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
