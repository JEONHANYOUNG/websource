package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.BoardAction;
import board.action.BoardActionFactory;
import board.action.BoardActionForward;
import oracle.net.aso.af;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request 인코팅 설정(post)
		request.setCharacterEncoding("utf-8");

		// http://localhost:8080/insert.do
		String requesrUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmd = requesrUri.substring(contextPath.length());
		
		//cmd에 따라 action을 생성
		BoardActionFactory baf = BoardActionFactory.getInstance();//객체를 생성하는 new와 같은 역할, 하나의 객체만 생성해서 그거로만 쓰겠다.(singleton 방식)
		BoardAction action = baf.action(cmd);
		
		//생성된 action에게 일 시키기
		BoardActionForward af = null;
		try {
			af = action.execute(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//return 받은 af에 따라서 이동
		if (af.isRedirect()) {//true => sendRedirect
			response.sendRedirect(af.getPath());
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response);
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
