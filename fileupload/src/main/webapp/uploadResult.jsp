<%@page import="java.util.UUID"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>note : <%=request.getParameter("note") %></h1>
<h1>upfile : <%=request.getParameter("upfile") %></h1>
<hr/>
<%-- commons fileupload 이용한 처리 --%>
<%
	// enctype이 "multipart/form-data" 이걸로 왔는지 확인
	boolean isMultipart = ServletFileUpload.isMultipartContent(request); // 사용자가 어떤 요청을 했는가?

	if(isMultipart){
		// 전송된 파일을 디스크에 저장하기 위한 객체
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//업로드 가능 사이즈 지정(2000*1024)
		upload.setSizeMax(2000*1024);
		
		//사용자의 request 분석(List : 차례대로 담겠다)
		List<FileItem> fileItems = upload.parseRequest(request);
		
		String fieldName = null, fileName=null, value = null;
		
		//향상된 for문으로 작성 가능하다.
		/* for(FileItem item:fileItems){
			if(item.isFormField()){
				fieldName = item.getFieldName();
				value = item.getString("utf-8");
				out.print("<h3>일반 데이터</h3>");
				out.print(fieldName+" : "+value+"<br>");
			}else { //type이 file로 넘어오는 경우에만 해당
				fieldName = item.getFieldName();
				fileName= item.getName();
				long size = item.getSize();
				out.print("<h3>파일 데이터</h3>");
				out.print(fieldName+" : "+fileName+"<br>");
				out.print("파일크기 : "+size);
				
			}
			
		} */
			
		Iterator<FileItem> iter = fileItems.iterator(); // 담는 방식
		while(iter.hasNext()) {//가지고 나올 구조가 있으면
			FileItem item = iter.next();
			
			//if ~ else 구문
			// text,password,checkbox....
			if(item.isFormField()){
				//요소명
				fieldName = item.getFieldName(); //필드명을 가지고 오는 것(uploadForm.jsp에 File to upload에서 name="upfile"를 가져오는 것)
				//요소 안에 들어있는 value 값
				value = item.getString("utf-8");
				//출력한 값
				out.print("<h3>일반 데이터</h3>");
				out.print(fieldName+" : "+value+"<br>");
			}else { //type이 file로 넘어오는 경우에만 해당
				//요소명
				fieldName = item.getFieldName();
				//파일명
				fileName= item.getName();
				//업로드된 파일 사이즈
				long size = item.getSize();
				
				
				File file = null;
				if(!fileName.isEmpty()){ //파일이 비어있지 않으면
				//파일 저장(로컬디스크 (C:)에 upload 파일에 넣기(path 값))
				String path = "c:\\upload\\";
				
				//중복되지 않는 고유한 키 값 생성 
				UUID uuid = UUID.randomUUID();
				
				//c:\\upload\\(path 값)고유값_업로드 파일명
				file = new File(path+uuid.toString()+"_"+fileName); 
				item.write(file);				
				}
				
				//출력한 값
				out.print("<h3>파일 데이터</h3>");
				out.print(fieldName+" : "+fileName+"<br>");
				out.print("파일크기 : "+size);
				
				//파일다운로드 - 다운로드 시킬 파일명 전송
				out.print("<p>");
				out.print("<a href='download.jsp?fileName="+file.getName()+"'>"+fileName+"</a>");
				out.print("</p>");				
			}
		}
		
	}
%>
</body>
</html>
