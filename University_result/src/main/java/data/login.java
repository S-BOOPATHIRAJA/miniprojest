package data;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		PrintWriter pw=res.getWriter();
		//Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/diwa","root","root");
		
		
		int n=Integer.parseInt(req.getParameter("f1"));
		String name=req.getParameter("f2");
		RequestDispatcher rd=req.getRequestDispatcher("general.html");
		rd.include(req, res);
		try {
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/diwa","root","root");
			String str="select * from s_details where id=?";
			PreparedStatement ps=cn.prepareStatement(str);
			ps.setInt(1, n);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				int n1=rs.getInt(1);
				String s1=rs.getString(2);
				int n2=rs.getInt(3);
				if(n1==n&&s1.equals(name)) {
					int marks=n2;
					HttpSession h=req.getSession();
					h.setAttribute("bbb", s1);
					HttpSession hs=req.getSession();
					hs.setAttribute("aaa", marks);
					RequestDispatcher rd1=req.getRequestDispatcher("result.jsp");
					rd1.forward(req, res);
				}
				else {
					RequestDispatcher rd1=req.getRequestDispatcher("index2.html");
					rd1.forward(req, res);
				}
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		}
	}

	

