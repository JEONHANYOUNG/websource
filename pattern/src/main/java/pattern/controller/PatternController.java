package pattern.controller;


import java.io.IOException;
import java.io.PrintWriter;

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
		
		request.setCharacterEncoding("utf-8"); //모든 요청이 여기를 거치게 되니까 한번만 작성하면 됨, 한 곳을 모은 상황
		
		// "/index.do" 가 requestUri에 담긴다
		String requestUri = request.getRequestURI(); //받아온 requestUri를 찍어놓으면 getRequestURI로 요청한 url를 찍어나옴 
				
		//ActionFactory를 PatternController에서 호출하려고 할때
		//다른 클래스에서 다른 클래스를 호출하려면 객체 생성
		ActionFactory af = ActionFactory.getInstance(); //외부 클래스에선 이런 코드로 객체 생성받음, 매번 불리지 않고 한번만 써주면 됨 
		// (여기 안에 "/insert.do" 있고 만들어서 돌아온 것이 InsertAction이 돌아옴
		// InsertAction이 execute() 를 호출
		// InsertAction 객체 생성한 후 리턴(PatternController 클래스로 제어권 넘어감) => InsertAction이 실행됨
		Action action = af.action(requestUri); // 보낼테니까 메세지 보내줘, action에 있는 것을 부를 수 있음, 해당하는 것은 

		ActionForward actionForward =null;
		try {
			actionForward = action.execute(request);
		} catch (Exception e) {
			e.printStackTrace();
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
