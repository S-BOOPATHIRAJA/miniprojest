<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="DocLoginCon">
<div id="one">

<div id="three" style=" border-radius: 10px">
<div style="margin-top: 30px;">
<h1 style="text-align: center; font-family: cursive;">Aarogya</h1>
</div>

<div id="zz" >
<input class="bt" type="email" placeholder="Invalid Email or Password" style="margin-top: 20px;border: 1px solid" name="email">
<br>
<input class="bt" type="password" placeholder="Password" style="margin-top: 20px;border: 1px solid" name="pass">
<br>
<input class="bt" type="submit" value="login" style="margin-top: 20px;background-color: rgb(97, 213, 242);
border-color: rgb(122, 217, 255);">
<br>
</div>
<div style="margin-top: 20px">
<a href="ForgetPass.jsp" style="margin-left: 120px; font-size: 14px">Forget password?</a>
</div>
<div id="fc" style="margin-left: 70px;margin-top: 60px">
Don't have an account? <a href="Doctor.jsp">register</a>
</div>
</div>
</div>
</form>
</body>
<style>
#one
{
padding: 0 460px;

}

#three
{
border:solid 1px;
float: right;
width: 330px;
height: 500px;
margin-top: 30px;
}
.bt
{
margin-left: 40px;
border-radius:5px;
width: 240px;
height: 40px;


}
::placeholder
{
text-align: center;
color: red;

}


</style>
</html>