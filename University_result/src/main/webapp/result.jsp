<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%RequestDispatcher rd=request.getRequestDispatcher("general.html");
rd.include(request, response);
%>


<h1>your marks is:</h1>

<h1>
MARK:
<%

HttpSession hs=request.getSession();
out.print(hs.getAttribute("aaa"));
%>
</h1>


</body>
<style>
body{
text-align: center;
}


</style>
</html>