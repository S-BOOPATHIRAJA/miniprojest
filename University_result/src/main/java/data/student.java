package data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.XAConnection;

@WebServlet("/student")
public class student extends HttpServlet {
	
  public void service(HttpServletRequest req,HttpServletResponse res)
  {
	  int id=Integer.parseInt(req.getParameter("f1"));
	  String name=req.getParameter("f2");
	  try {
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/diwa","root","root");
		String str="select*from s_details where id=?";
		PreparedStatement ps=cn.prepareStatement(str);
		ps.setInt(1, id);
		
		ps.execute();
		ResultSet rs=ps.executeQuery();
		try {
			PrintWriter pw=res.getWriter();
			int flag=0;
			while(rs.next()) {
				int a=rs.getInt(1);
				String b=rs.getString(2);
				int c=rs.getInt(3);
				
				if(a==id&&name.equals(b))
				{
					pw.println(c);
					//Cookie ck=new Cookie("NAME",name);
					//ck.setMaxAge(60*60);
					//res.addCookie(ck);
					HttpSession hst=req.getSession();
					hst.setAttribute("ssss",name);
					RequestDispatcher rd=req.getRequestDispatcher("session");
					try {
						rd.forward(req, res);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//String ss=(String)hst.getAttribute("ssss");
					//System.out.print(ss);
					flag=1;
					break;
				}
			}
			if(flag!=1)
			{
				//pw.println("invalid");	
				RequestDispatcher re=req.getRequestDispatcher("studentD.html");
				try {
					re.forward(req, res);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
