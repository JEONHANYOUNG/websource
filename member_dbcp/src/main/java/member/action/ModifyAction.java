package member.action;

import java.io.Closeable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import member.domain.MemberDTO;
import member.domain.UpdateDTO;
import member.service.ModifyService;

@AllArgsConstructor

public class ModifyAction implements Action {

	private String path; //"/view/loginForm.jsp"
	
	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		// userid 가져오기 - 세션
		// MemberDAO에 있는 islogin에서 사용했고, loginform에서 session을 사용했기에 세션에서 로그인 정보 가져오는 방법
		HttpSession session = request.getSession();
		MemberDTO loginDto = (MemberDTO)session.getAttribute("loginDto");
		String userid = loginDto.getUserid();
		
		
		// modifyForm.jsp에서 사용자 입력 값 가져오기
		String current_password =request.getParameter("current_password");
		String new_password =request.getParameter("new_password");
	    String confirm_password =request.getParameter("confirm_password");
	    UpdateDTO updateDto = new UpdateDTO(userid, current_password, new_password, confirm_password);
		
	    
	    // db작업 서비스에게 부탁
	    if (updateDto.passwordEqualTo(new_password)) {
	    	ModifyService service = new ModifyService();
	    	boolean updateFlag = service.Modify(updateDto);
	    	//성공 => commit, 현재 세션 해제, 로그인 페이지 이동
			if (updateFlag) {
				session.invalidate();
				//path ="/view/loginForm.jsp";
		} else {
			//실패 => rollback, 비밀번호 변경 페이지로 이동
			path = "/view/modifyForm.jsp";
		} 
		
     	//비밀번호 변경 페이지로 이동
	    
	    } else {
	    	path = "/view/modifyForm.jsp";
		}
	    return new ActionForward(path, true); 
	}
	    
	    
	    
	    // db작업 서비스에게 부탁
//	    ModifyService service = new ModifyService();
//	    MemberDTO modifyDto = service.modifyService(current_password, new_password, confirm_password)
//	    
//	    
	    
	    // 결과에 따라서 페이지 이동
//		if (modifyDto !=null) {
//			
//		}
//		

}
