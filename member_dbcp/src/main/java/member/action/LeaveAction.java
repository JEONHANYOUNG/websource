package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import member.domain.MemberDTO;
import member.service.LeaveService;

@AllArgsConstructor
public class LeaveAction implements Action {

	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {//HttpServletRequest: 사용자의 요청을 받을 수 있다.
		// 사용자 입력값 가져오기
		String userid = request.getParameter("userid");
		String password = request.getParameter("current_password");
		
		// db 작업 서비스에게 부탁
		LeaveService service = new LeaveService();
		boolean deleteFlag = service.leave(userid, password);
		
		// 결과에 따라서 페이지 이동
		if (deleteFlag) {
			//세션 해제
			HttpSession session = request.getSession(); //http 프로토콜의 stateless 를 보완하는 방법
			session.removeAttribute("loginDto"); //removeAttribute: 특정세션제거
		}else {
			path = "/view/leaveForm.jsp";
		} 
		return new ActionForward(path, true);
			
	}

}
