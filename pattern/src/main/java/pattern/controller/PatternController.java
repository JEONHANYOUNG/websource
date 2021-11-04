package pattern.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PatternController
 */
@WebServlet("*.do")
//끝에 do로 끝나는 모든 요청은 내가 처리하겠어
//어떤 페이지로 하던간에 한곳으로 보낼게요 .do 로만 보내주면 patternController 로 보내준대
//http://localhost:8080/hello.do
//http://localhost:8080/insert.do

public class PatternController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //모든 요청이 오게 되므로 한번만 작성하면 됨
		
		String requestUri	= request.getRequestURI(); //받아온 requestUri를 찍어놓으면 getRequestURI로 찍어나옴
		
		response.setContentType("text/html;charset=utf=8"); 
		PrintWriter out = response.getWriter();	
		
		out.print("requestUri "+requestUri);
		
		if (requestUri.equals("/insert.do")) {
			out.print("insert.jsp가 보낸값");
		} else if (requestUri.equals("/update.do")) {
			out.print("update.jsp가 보낸 값");
		} else if (requestUri.equals("/index.do")) {
			out.print("index.jsp가 보낸 값");
			
		}
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
