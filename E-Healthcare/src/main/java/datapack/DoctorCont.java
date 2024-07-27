package datapack;



import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/Doctor")
@MultipartConfig(maxFileSize = 16177215)
public class DoctorCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String url="jdbc:mysql://localhost:3306/persondb";
	String unm="root";
	String pwd="root";
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
		String pname=request.getParameter("pname");
		String address=request.getParameter("address");
		String gender =request.getParameter("gender");
		String email=request.getParameter("email");
		String pass = request.getParameter("pass");
		long mob = Long.parseLong(request.getParameter("con"));
		InputStream istrm=null;
		
		Part fp=request.getPart("pic");
		Part fp1=request.getPart("medi");
		InputStream istrm1=fp1.getInputStream();
		if(fp != null) {
			System.out.println(fp.getName());
			System.out.println(fp.getSize());
			System.out.println(fp.getContentType());
			istrm=fp.getInputStream();
		}
		Connection con=null;
		String msg=null;
		try {
			
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			 con=DriverManager.getConnection(url,unm,pwd);
		String sql = "INSERT INTO Doctorsdata (D_Name, D_specialized, gender, pic,medi_lic,mobile,email,pass) VALUES (?, ?, ?, ?,?,?,?,?)";
			 PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, pname);
			 ps.setString(2, address);
			 ps.setString(3, gender);
			 ps.setString(7, email);
			 ps.setString(8, pass);
			 if(istrm != null) {
				 ps.setBlob(4, istrm);
			 }
			 if(istrm1 != null) {
				 ps.setBlob(5, istrm1);
			 }
			 ps.setLong(6, mob);
			 
			 int res=ps.executeUpdate();
			 if (res > 0) {
	                response.getWriter().println("Post uploaded successfully!");
	            }
			 con.close();
			 
		}
		catch (SQLException e) {
            e.printStackTrace();
		}
		
	
	}

}