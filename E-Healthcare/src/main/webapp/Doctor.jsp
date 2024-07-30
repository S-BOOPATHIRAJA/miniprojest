<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Registration</title>
</head>
<style>
.one
{
text-align: center;
}
#i
{
background-image: url("images/pic1.jpg");
background-size: cover;
}
.two
{
width: 250px;
height: 40px;
}
#bt
{
width: 150px;
height: 40px;
border-radius: 10px;
background-color:  rgb(208, 226, 245);
border-color: rgb(188, 216, 245);
}
</style>
<body id="i">
<h2 style="text-align: center;">Doctor Registration Form</h2>
<center>
<table border="1px" width="600px" height="450px">

<form action="Doctor" method="post" enctype="multipart/form-data">
<tr class="one"><td >Doctor Name</td><td><input class="two" type="text" name="pname" required></td></tr>
<tr class="one"><td >Email Id</td><td><input class="two" type="email" name="email" required></td></tr>
<tr class="one"><td >Password</td><td><input class="two" type="password" name="pass" required></td></tr>
<tr class="one"><td>Specialized In:</td><td><select class="two" name="address" required>
<option>General Physician</option>
<option>Gynecologist</option>
<option>Otolaryngologist(ENT)</option>
<option>Proctologist</option>


</select></td></tr>
<tr class="one"><td>Contact No:</td><td><input class="two" type="tel" pattern="[0-9]{10}" name="con"required></td></tr>
<tr class="one"><td>Gender</td>
<td><input  type="radio" name = "gender" value="Male">Male
<input type="radio" name = "gender" value="Female">Female
<input type="radio" name = "gender" value="Others">Others</td></tr>

<tr class="one"><td>Profile Picture</td><td><input class="two" type="file" name="pic" required></td></tr>
<tr class="one"><td>Medical License</td><td><input class="two" type="file" name="medi" required></td></tr>
</table>
<br>
<input id="bt" type="submit" value="Register"/>
</center>

</form>
</body>

</html>