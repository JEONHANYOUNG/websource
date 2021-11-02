<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//form1.jsp 에서 사용자가 입력한 값을 서버로 가져오는 역할
	//HttpservletRequest request => request.getParameter("요소 이름"); 
	
	//가져오는 값에 대한 인코딩 처리, post를 넣어주면 한글이 깨지므로 아래와 같이 넣어줘야함
	request.setCharacterEncoding("UTF-8");
	
	String userid=request.getParameter("userid");
	String password = request.getParameter("password");
	String username = request.getParameter("username");
%>
<p><%=userid%></p>
<p><%=password%></p>
<p><%=username%></p>
<p>client addr : <%=request.getRemoteAddr() %></p>
<p>client host : <%=request.getRemoteHost() %></p>
<p>client port : <%=request.getRemotePort() %></p>
<p>request URI : <%=request.getRequestURI() %></p>
<p>request protocol : <%=request.getProtocol() %></p>
