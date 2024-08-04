package data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/servlet")
public class servlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		try {
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/diwa","root","root");
			String str="insert into emp values(2222,'diwa',30000,35,'male','2025-05-02')";
		    PreparedStatement ps=cn.prepareStatement(str);
		    ps.execute();
		    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("inserted");
		}
		
		
	}

}
