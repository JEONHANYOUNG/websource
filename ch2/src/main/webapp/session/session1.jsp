<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//세션을 유지하는 시간 : 10초
	session.setMaxInactiveInterval(10);
%>
<h3>세션 테스트</h3>
<p>isNew : <%=session.isNew() %></p> <!-- 처음 열면 false이고 10초를 부여해서 기다리면 true가 뜸 -->
<p>생성시간 : <%=session.getCreationTime() %></p> <!-- 생성한 시간에 맞게 나온 것 -->
<p>최종접속시간 : <%=session.getLastAccessedTime() %></p> 
<p>세션 ID : <%=session.getId() %></p> <!-- 해당 클라이언트에게 세션 아이디를 주면서 연결이 유지되는 것을 만들어 줌 -->
<div>
	<a href="main.jsp">메인 페이지</a>
</div>
<div>
	<a href="user.jsp">user 페이지</a>
</div>
<div>
	<a href="section1.jsp">섹션 페이지</a>
</div>
<h2>세션 객체에 담긴 값 : <%=session.getAttribute("name") %></h2>
<h2>세션 객체에 담긴 값 : <%=session.getAttribute("userid") %></h2>
</body>
</html>