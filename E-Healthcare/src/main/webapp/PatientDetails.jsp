<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Registration</title>
</head>
<body id="i">
<h2 style="text-align: center;">Patient Registration Form</h2>
<center>
<table border="1px" id="tb">

<form action="Patient" method="post" enctype="multipart/form-data">
<tr class="one"><td>Patient Name</td><td><input class="two" type="text" name="pname" required></td></tr>
<tr class="one"><td>Age</td><td><input class="two" type="number" name="age" required></td></tr>
<tr class="one"><td>Seeking for</td><td><select class="two" name="seek">
<option value="Fever">Fever</option>
<option value="Cold">Cold</option>
<option value="Asthma">Asthma</option>
<option value ="Diabetes">Diabetes</option>
<option value = "Stomach pain">Stomach pain</option>
<option value="Irregular Periods">Irregular Periods</option>
<option value="ENT">Ear/Nose/throat</option>
<option value = "Piles">Piles</option>
</select></td></tr>

<tr class="one"><td>Address</td><td><input class="two" type="text" name="address" required></td></tr>
<tr class="one"><td>Contact No</td><td><input class="two" type="tel" pattern="[0-9]{10}" name="mob" required></td></tr>
<tr class="one"><td>Gender</td>
<td><input type="radio" name = "gender" value="Male">Male
<input type="radio" name = "gender" value="Female">Female
<input type="radio" name = "gender" value="Others">Others</td></tr>
<tr class="one"><td>Previous Records</td><td><input type="file" name="prescription" required></td></tr>
</table>
<br>
<br>
<input id="bt" type="submit" value="Register"/>
</center>

</form>
</body>
<style>
.one{
text-align: center;
}
#tb
{
width: 600px;
height: 400px;
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
background-color:  pink;
}
#i
{
background-image: url("images/regback.jpg");
background-size: cover;
}
</style>
</html>