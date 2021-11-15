<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 반드시 들어와야한다. => enctype="multipart/form-data" (request.getparameter로 못 갖고 온다.) 외부 라이브러리만 가능 -->
<form method="POST" enctype="multipart/form-data" action="/uploadResult.jsp"> 
  File to upload: <input type="file" name="upfile"><br/>
  Notes about the file: <input type="text" name="note"><br/>
  <br/>
  <input type="submit" value="Press"> to upload the file!
</form>
</body>
</html>









