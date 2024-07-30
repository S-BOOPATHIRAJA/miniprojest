package datapack;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import org.apache.catalina.connector.Request;

public class DoctorDao {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public DoctorDao() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "root");
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }

    // Method to retrieve all doctors
    public ResultSet getAllDoctors() {
        String sql = "SELECT * FROM doctorsdata";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return rs;
    }

    // Method to retrieve doctor by specialization
    public ResultSet getDoctor(String sp) {
        String sql = "SELECT * FROM doctorsdata WHERE D_specialized = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, sp);
            rs = pst.executeQuery();
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return rs;
    }
    // Shows Doctor profile after login
    public ResultSet getDoctorProfile(String email) {
        String sql = "SELECT * FROM doctorsdata WHERE email = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            rs = pst.executeQuery();
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return rs;
    }
    //verifies Doctors login
    public boolean checkDoc(String email,String pass)
    {
    	boolean result=false;
    	String sql = "select * from Doctorsdata where email=? and pass=?";
    	 try {
             pst = con.prepareStatement(sql);
             pst.setString(1, email);
             pst.setString(2, pass);
             rs = pst.executeQuery();
             result=rs.next();
         } catch (SQLException s) {
             s.printStackTrace();
         }
    	 return result;
    }
    
    //verifies email present in the db
    public boolean verifyEmail(String email)
    {
    	boolean result=false;
    	String sql = "select * from Doctorsdata where email=?";
    	 try {
             pst = con.prepareStatement(sql);
             pst.setString(1, email);
             rs = pst.executeQuery();
             result=rs.next();
         } catch (SQLException s) {
             s.printStackTrace();
         }
    	 return result;
    }
 
    // updates the password 
	public void updatePass(String pass,String email) {
		// TODO Auto-generated method stub
		String sql = "update Doctorsdata set pass=? where email=?";
   	 try {
            pst = con.prepareStatement(sql);
            pst.setString(2, email);
            pst.setString(1, pass);
             pst.executeUpdate();
             
            
        } catch (SQLException s) {
            s.printStackTrace();
        }
	}
	public void insertDoctorDetails(String pname,String address,String gender,String email,String pass,InputStream istrm,InputStream istrm1,long mob) throws SQLException
	{
		String sql = "INSERT INTO Doctorsdata (D_Name, D_specialized, gender, pic,medi_lic,mobile,email,pass) VALUES (?, ?, ?, ?,?,?,?,?)";
		  pst=con.prepareStatement(sql);
		 pst.setString(1, pname);
		 pst.setString(2, address);
		 pst.setString(3, gender);
		 pst.setString(7, email);
		 pst.setString(8, pass);
		 if(istrm != null) {
			 pst.setBlob(4, istrm);
		 }
		 if(istrm1 != null) {
			 pst.setBlob(5, istrm1);
		 }
		 pst.setLong(6, mob);
		 
		 pst.executeUpdate();
	}

	public boolean verifyEmailAndMob(String email, long mob) {
		boolean result=false;
    	String sql = "select * from Doctorsdata where email=?and mobile=?";
    	 try {
             pst = con.prepareStatement(sql);
             pst.setString(1, email);
             pst.setLong(2, mob);
             rs = pst.executeQuery();
             result=rs.next();
         } catch (SQLException s) {
             s.printStackTrace();
         }
    	 return result;
	}
}
