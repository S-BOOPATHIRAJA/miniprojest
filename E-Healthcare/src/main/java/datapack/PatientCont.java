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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


@WebServlet("/Patient")
@MultipartConfig(maxFileSize = 16177215)
public class PatientCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String url="jdbc:mysql://localhost:3306/persondb";
	String unm="root";
	String pwd="root";
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
		String pname=request.getParameter("pname");
		String address=request.getParameter("address");
		String gender =request.getParameter("gender");
		int age=Integer.parseInt(request.getParameter("age"));
		String seek= request.getParameter("seek");
		System.out.println(seek);
		long contact=Long.parseLong(request.getParameter("mob"));
		InputStream istrm=null;
		Part fp=request.getPart("prescription");
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
		String sql = "INSERT INTO patientdata (Name, address, gender, prescription,contact,age,problem) VALUES (?, ?, ?, ?, ?, ?, ?)";
			 PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, pname);
			 ps.setString(2, address);
			 ps.setString(3, gender);
			 if(istrm != null) {
				 ps.setBlob(4, istrm);
			 }
			 ps.setLong(5, contact);
			 ps.setInt(6, age);
			 ps.setString(7, seek);
			 
			 int res=ps.executeUpdate();
			 
			 if (res > 0) {
	                response.getWriter().println("<h1>Data uploaded successfully!</h1>");
	            }
			 con.close();	 
		}
		catch (SQLException e) {
            e.printStackTrace();
		}
		String sp=null;
	       if(seek.equals("Fever")||seek.equals("Cold")||
	    		   seek.equals("Asthma")||seek.equals("Diabetes")||seek.equals("Stomach pain"))
	       {
	    	   sp="General Physician";
	       }
	       else if(seek.equals("Irregular Periods"))
	       {
	    	   sp = "Gynecologist";
	       }
	       else if(seek.equals("ENT"))
	       {
	    	   sp = "Otolaryngologist(ENT)";
	       }
	       else
	       {
	    	   sp = "Proctologist";
	       }
			
		
	request.setAttribute("sp", sp);	
		RequestDispatcher rds= request.getRequestDispatcher("DisplayDoctor.jsp");
		rds.forward(request, response);
	
		
	
	}

}