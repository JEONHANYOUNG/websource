<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 다른 페이지로 특정 값을 넘기는 방법: get/post
     get : 주소줄에 따라가는 값이 보임(넘기는 것은 무조건 get 방식, 웹에서 사용)
     post : 보이지 않음 
     ex) adminPage.jsp?page=1&password=1234 => adminPage로 이동하고 페이지는 1이라는 이름이고 password는 1234라는 의미
--%>
	<p>
 		<a href="adminPage.jsp?page=1&password=1234">관리자 페이지</a>
	</p>
 	<form action= "adminPage.jsp" method="post">
 		<div>
 			비밀번호 : <input type="password" name="password"/>
 			<input type="submit" value="전송"/>
    	</div>
 	</form>
 	<!-- 단순 페이지 링크를 걸려면 위의 방식대로 작성 -->
</body>
</html>