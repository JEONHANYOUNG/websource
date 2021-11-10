package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import member.domain.MemberDTO;
import member.service.LoginService;
import static member.persistence.JdbcUtil.*;

@AllArgsConstructor
public class LoginAction implements Action {

	private String path;//외부에서 객체 생성 못함(내부에선 가능)	
	

	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {//action에서 받은 값, public : 외부에서 객체 생성 시 무한정 만들어짐
		// 사용자의 입력 값 가져오기
		String userid = request.getParameter("userid"); //가져오는 개념
		String password = request.getParameter("current_password");
		
		//db작업 부탁 => service
		LoginService service = new LoginService();
		MemberDTO loginDto = service.loginService(userid, password);
		
		
		if (loginDto != null) {
			HttpSession session = request.getSession(); //끌고 다니기 위해 session을 부여(기능의 한가지, 권한 부여 개념)
			session.setAttribute("loginDto", loginDto); //변환해주는 것
		}
		
		return new ActionForward(path, true);
}
}