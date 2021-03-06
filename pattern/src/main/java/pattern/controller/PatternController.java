package pattern.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pattern.action.Action;
import pattern.action.ActionForward;

/**
 * Servlet implementation class PatternController
 */
@WebServlet("*.do") //~라고 접근할거야 라고 주는 것(접근 가능, 붙히기 나름)
// "*" 이 오면 어떤 것이 와도 상관없음, "*.do"는 어떤 모든 것을 .do로 끝나는 것은 모두 받겠다라는 의미)
//끝에 do로 끝나는 모든 요청은 내가 처리하겠어
//어떤 페이지로 하던간에 한곳으로 보낼게요 .do 로만 보내주면 patternController 로 보내준대
//http://localhost:8080/hello.do
//http://localhost:8080/insert.do

public class PatternController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); //모든 요청이 여기를 거치게 되니까 한번만 작성하면 됨, 한 곳을 모은 상황, 요청에 대한 한글 처리
		
		// 어디서 요청이 왔는지 찾기
		// "/index.do" 가 requestUri에 담긴다
		String requestUri = request.getRequestURI(); //받아온 requestUri를 찍어놓으면 getRequestURI로 요청한 url를 찍어나옴 
		String contextPath = request.getContextPath(); 
		String cmd = requestUri.substring(contextPath.length()); //.do만 뽑아내는 것 
				
	
		//ActionFactory를 PatternController에서 호출하려고 할때
		//다른 클래스에서 다른 클래스를 호출하려면 객체 생성
		ActionFactory af = ActionFactory.getInstance(); //외부 클래스에선 이런 코드로 객체 생성받음, 매번 불리지 않고 한번만 써주면 됨 
		// 요청에 따라서 해당 action 생성(통제 센터)
		// (여기 안에 "/insert.do" 있고 만들어서 돌아온 것이 InsertAction이 돌아옴
		// InsertAction이 execute() 를 호출
		// InsertAction 객체 생성한 후 리턴(PatternController 클래스로 제어권 넘어감) => InsertAction이 실행됨
		Action action = af.action(cmd); // 보낼테니까 메세지 보내줘, action에 있는 것을 부를 수 있음, 생성된 action이다. action에 loginaction이 있다. 

		
		ActionForward actionForward =null;
		try { 
			// 생성된 Action에게 일을 시킴 => 결과를 ActionForward 객체로 넘겨 받음
			actionForward = action.execute(request);// request를 호출해줌
		} catch (Exception e) { // 오류 발생하는 것을 잡으려고
			e.printStackTrace();
		}
		
		//로그인 실패 return new ActionForward("/view/login.jsp", true);
		//로그인 성공 return new ActionForward("/index.jsp", true);
		
		// sendRedirect 방식은 이동한 페이지를 보여주는 것
		// forward 방식은 페이지를 안보여주는 것
		//넘겨 받은 ACtionForward가 가지고 있는 값에 따라서 페이지 이동
		if(actionForward.isRedirect()) {//어떤 방식으로 해주는지 물어보는 것. isredirect(forward , sendredirect)= boolean 타입 형식 
			response.sendRedirect(actionForward.getPath());//true 
		} else {
			RequestDispatcher rd = request.getRequestDispatcher(actionForward.getPath());
			rd.forward(request, response); //false
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
