<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>adminProcess</h1>
<!-- 사용자가 입력한 방식 그대로 사용하는 방식 --> 	
<%
String page1 = request.getParameter("page");
String password = request.getParameter("password");
out.print("page1 : " + page1+ "<br>");
out.print("password : " + password+ "<br>");

%>
</body>
</html>