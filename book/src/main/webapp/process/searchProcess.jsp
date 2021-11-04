<%@page import="book.domain.BookDTO"%>
<%@page import="java.util.List"%>
<%@page import="book.persistence.BookDAO"%>
<%@page import="book.persistence.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.getAttribute("utf-8");
	
	//search.jsp에서 넘긴 것 가져오기
	String criteria = request.getParameter("criteria");
	String keyword = request.getParameter("keyword");
	
	//db작업 하기
	Connection con = JdbcUtil.getConnection();
	BookDAO dao = new BookDAO(con);
	
	List<BookDTO> searchList = dao.search(criteria, keyword);

	JdbcUtil.close(con);
	
	request.setAttribute("list", searchList);
	//페이지 이동하기
	pageContext.forward("/searchIndex.jsp");
	

%>
