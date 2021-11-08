<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- insert.jsp에서 삽입버튼을 누르면 "/insert.do"로 가라고 한것이고 거기서 멈추라고 한것(목적지는 servlet으로 간것)  -->
<p>
<!--  <a href="/insert.do?no=10">삽입</a> -->
<form action="/login.do" method="post">
	<div>
		<label for="userid">아이디</label>
	<input type="text" name="userid" id="userid"/>
	</div>
	<div>
	<label for="password">비밀번호</label>
	<input type="password" name="password" id="password"/>
	</div>
	<div> 
		<button type="submit">보내기</button>
	</div>
</form>


</p>
</body>
</html>