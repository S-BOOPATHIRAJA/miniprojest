package datapack;



import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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
		DoctorDao dd= new DoctorDao();
		boolean tt=dd.verifyEmailAndMob(email,mob);
		if(tt==false)
		{
		
		Connection con=null;
		String msg=null;
		try {
			dd.insertDoctorDetails(pname,address,gender,email,pass,istrm,istrm1,mob);
			 request.setAttribute("email", email);
			 RequestDispatcher rd = request.getRequestDispatcher("DoctorProfile.jsp");
			 rd.forward(request, response);
			
			 
		}
		catch (SQLException e) {
            e.printStackTrace();
		}
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("EmailMobileExists.jsp");
			rd.forward(request, response);
		}
		
	
	}

}