<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
    
    private String getCookieValue(Cookie[] cookies, String name){
       
       if(cookies==null){
          return null;
       }
       
       for(Cookie cookie : cookies){
          if(cookie.getName().equals(name)){
             return cookie.getValue();
          }
       }
       return null;
       
    }
    
%>
<!DOCTYPE html>
<html>
<head>
<body>
	<%
		//서버가 저장해둔
		Cookie[] cookies = request.getCookies();

	%>
	<p>
   		이름 : <%=getCookieValue(cookies, "name") %>
	</p>
	<p>
   		나이 : <%=getCookieValue(cookies, "age") %>
	</p>
	<p>
   		성별 : <%=getCookieValue(cookies, "gender") %>
	</p>
</body>
</html>