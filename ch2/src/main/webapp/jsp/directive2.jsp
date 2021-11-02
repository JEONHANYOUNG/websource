<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>지시어</h1>
<%-- page / taglib --%>
<%-- b=0 인데 "/"를 해서 에러가 발생 (500 - 에러) --%>
<% 
	int a=1, b=0;
 	out.print("<p>a 와  b의 사칙연산<p>");
 	out.print("<p>a +  b = "+ (a+b) +"</p>");
 	out.print("<p>a -  b = "+ (a-b) +"</p>");
 	out.print("<p>a *  b = "+ (a*b) +"</p>");
 	out.print("<p>a /  b = "+ (a/b) +"</p>");
%>
</body>
</html>