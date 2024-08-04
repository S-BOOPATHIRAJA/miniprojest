package data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Emp
 */
@WebServlet("/Emp")
public class Emp extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		int n=Integer.parseInt(req.getParameter("f1"));
		boolean c=valid.checkvalid(n);
		Connection cn;
		if(c)
		{
		try {
			String str="select*from emp where id=?";
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/diwa","root","root");
			PreparedStatement ps=cn.prepareStatement(str);
			ps.setInt(1, n);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				String a=rs.getString(2);
				int b=rs.getInt(3);
				int d=rs.getInt(4);
				String e=rs.getString(5);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	}
}
