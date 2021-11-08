package pattern.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pattern.domain.MemberDTO;
import pattern.service.LoginService;

@AllArgsConstructor
@Getter

public class LoginAction implements Action { //pattern.action을 걸어준 것
	
	private String path; // "/index.jsp" 담겨져 있음
		

	@Override
	//execute의 리턴 타입이 ActionForward(path와 redirect을 채워서 넘겨줘야한다.)이어야 한다.
	//execute를 부르면 ActionForward으로 리턴 타입이므로 PatternController으로 넘긴 것
	public ActionForward execute(HttpServletRequest request) throws Exception { 
		// getParameter 인자를 가져올 수 있다. 
	    // 원래는 get 방식이나 form 방식은 다음 페이지까지 request할 수 있으나 지금은 클래스로 받고 있기 때문에 가능하다.
			
		//사용자가 넘기는 값 가져오기
//		String no = request.getParameter("no");
//		System.out.println("no " +no);
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		
		// 서비스 작업(id와 name 
		LoginService service = new LoginService();
		MemberDTO loginDto= service.loginService(userid,password);
		
		
		// 결과에 따라 ActionForward 객체 생성
		if (loginDto==null){ //로그인 실패
			path ="/view/login.jsp"; //로그인 폼 보여주기
		} else { // 로그인 성공 => 세션에 값 담기, 성공은 index
			HttpSession session = request.getSession();
			session.setAttribute("loginDto", loginDto);//로그인 값은 무조건 session에 값을 담는다.
		} 
		
		//로그인 실패 return new ActionForward("/view/login.jsp", true);
		//로그인 성공 return new ActionForward("/index.jsp", true);
		
		//true에 sendRedirectd이다.
		return new ActionForward(path, true); //ActionForward를 생성을 하고 어느 방향으로 갈건지 return 하는 것, 괄호 안에 path는 이동할 경로가 담긴 것
		
	}

}
