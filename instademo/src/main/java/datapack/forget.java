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
 * Servlet implementation class forget
 */
@WebServlet("/forget")
public class forget extends HttpServlet {
	public void service(HttpServletRequest rq,HttpServletResponse rs)
	{
		String name=rq.getParameter("x1");
		String passw=rq.getParameter("x2");
		if(!(passw.equals("")))
		{
			try {
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/akki","root","root");
			    String sty="select * from login";
			    PreparedStatement pst=cn.prepareStatement(sty);
			    ResultSet rst=pst.executeQuery();
			    int flag=0;
			    while(rst.next())
			    {
			    	String uname=rst.getString(1);
			    	String pa=rst.getString(2);
			    	if(uname.equals(name))
			    	{
			    		flag=1;
			    		break;
			    	}
			    }
			    if(flag==1)
			    {
			    	String str2="update login set pass=? where username=?";
			    	PreparedStatement pst1=cn.prepareStatement(str2);
			    	pst1.setString(1, passw);
			    	pst1.setString(2, name);
			    	pst1.execute();
			    	RequestDispatcher tt=rq.getRequestDispatcher("home.html");
			    	try {
						tt.forward(rq, rs);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	
			    }
			    else
			    {
			    	RequestDispatcher yy=rq.getRequestDispatcher("forget2.html");
			    	try {
						yy.forward(rq, rs);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			RequestDispatcher pp=rq.getRequestDispatcher("forget.html");
			try {
				pp.forward(rq, rs);
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
