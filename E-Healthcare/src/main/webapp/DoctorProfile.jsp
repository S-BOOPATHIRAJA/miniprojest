<%@page import="java.sql.ResultSet"%>
<%@page import="datapack.DoctorDao"%>
<%@page import="datapack.Doctor" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Profiles</title>
<style>
body {
  font-family: Arial, sans-serif;
  background-color: #f4f4f4;
  margin: 0;
  padding: 20px;
}

.container {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 20px;
  max-width: 1200px;
  margin: 0 auto;
}

.card {
  box-shadow: 0 4px 8px rgba(0,0,0,0.2);
  transition: box-shadow 0.3s;
  border-radius: 5px;
  background-color: #fff;
  overflow: hidden;
  display: flex;
  flex-direction: column;
}

.card img {
  width: 100%;
  height: 400px;
  object-fit: cover;
}

.card .container {
  padding: 16px;
  display: flex;
  flex-direction: column; /* Ensures that content is stacked vertically */
}

.card h4 {
  margin: 0 0 10px 0; /* Adjusts margin below the name */
}
#i
{
background-image: url("images/pic1.jpg");
background-size: cover;
}

.card p {
  margin: 5px 0; /* Adds spacing between details */
}

.card:hover {
  box-shadow: 0 8px 16px rgba(0,0,0,0.2);
}
</style>
</head>
<body id="i">
<h1>Your Profile</h1>
<div class="container">
<%
    String email = (String) request.getAttribute("email");
    DoctorDao dd = new DoctorDao();
    ResultSet rs = dd.getDoctorProfile(email);

    while (rs.next()) {
    	int id=rs.getInt("D_id");
        String name = rs.getString("D_Name");
        String spc = rs.getString("D_specialized");
        String gen = rs.getString("gender");
        long mobile = rs.getLong("mobile");
%>

<div class="card">
  <img src="DoctorImage?id=<%= id %>" alt="Avatar">
  <div class="container">
    <h4>Doctor Name: <b><%= name %></b></h4>
    <p>Specialized In: <%= spc %></p>
    <p>Gender: <%= gen %></p>
    <p>Mobile No: <%= mobile %></p>
		<input type="submit" value="See your Appoinment" id="button-1"/>
  </div>
</div>

<%
    }
    rs.close();
%>
</div>
</body>
</html>
