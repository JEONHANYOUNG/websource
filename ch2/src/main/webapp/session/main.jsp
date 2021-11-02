<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>main 페이지</h1>
<%
	// 세션객체에 특정 값을 담기
	session.setAttribute("name", "hong"); //(String arg0, Object arg1) <= 앞에는 이름이고 뒤에는 담고 싶은 값(객체형태면 아무거나 가능)으로 작성해줘야 함 
	session.setAttribute("userid", "hong123"); //(String arg0, Object arg1) <= 앞에는 이름이고 뒤에는 담고 싶은 값(객체형태면 아무거나 가능)으로 작성해줘야 함 
%>
<div>
	<a href="section1.jsp">섹션 1 페이지</a>
</div>
<div>
	<a href="user.jsp">user 페이지</a>
</div>
<div>
	<a href="session1.jsp">세션 페이지</a>
</div>
</body>
</html>