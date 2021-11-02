<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%

	//post 방식 한글깨짐 방지
	request.setCharacterEncoding("Utf-8");
	
	//사용자의 요청을 가져올 때 request 로 처리
	//사용자의 요청은 무조건 String 형태임
	String username=request.getParameter("username");
	String age=request.getParameter("age");
	String gender=request.getParameter("gender"); //getParameter는 딱 하나만 가져올 수 있고 선택한 것 중 맨 앞에 있는 것만 가져오게 됨.
	
	String page1=request.getParameter("page");
	String bno=request.getParameter("bno");
	
	String fruits[]=request.getParameterValues("fruits"); //getParametervalues는 여러개를 가져올 수 있으며, 배열의 형태로 들어온다.

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>이름 : <%=username%> : <%=age%> : <%=gender%> : <%=Arrays.toString(fruits) %></h3>
<h3>page : <%=page1 %>, bno : <%=bno %></h3>
</body>
</html>