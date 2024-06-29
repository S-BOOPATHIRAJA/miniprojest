
<%@page import="java.net.http.HttpRequest"%>
<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Welcome buddy Party ready</p>

<%
HttpSession gh= request.getSession();
HttpSession hs1=request.getSession();
String a=(String)hs1.getAttribute("two");
//out.print();
%>

<h1> Welcome

<%=a

%>

</h1>
Your Result is:
<br>
<table border="2px">
  <tr>
    <th>Overall Marks</th>
    
  </tr>
  <tr>
    <td><%=gh.getAttribute("one")%></td>
    
  </tr>
</table>


<br>
<a href="New.html">login</a>
<a href="logout">logout</a>
<a href="session">dashboard</a>

</body>
</html>