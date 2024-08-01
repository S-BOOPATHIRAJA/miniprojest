package datapack;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PatientImage
 */
@WebServlet("/PatientImage")
public class PatientImage extends HttpServlet {
	public void service(HttpServletRequest rq , HttpServletResponse res)
	{
		 String mobileStr = rq.getParameter("id");
	        

	        try {
	            int id = Integer.parseInt(mobileStr);
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "root");
	            String query = "SELECT prescription FROM patientdata WHERE Pid=?";
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                InputStream is = rs.getBinaryStream("prescription");
	                res.setContentType("image/jpeg");

	                OutputStream os = res.getOutputStream();
	                byte[] buffer = new byte[1024];
	                int bytesRead;

	                while ((bytesRead = is.read(buffer)) != -1) {
	                    os.write(buffer, 0, bytesRead);
	                }

	                os.close();
	                is.close();
	            }

	            rs.close();
	            ps.close();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	      
	}
}
