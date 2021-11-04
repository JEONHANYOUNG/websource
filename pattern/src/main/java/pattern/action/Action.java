package pattern.action;

import javax.servlet.http.HttpServletRequest;

public interface Action { //메소드 생성
	public ActionForward execute(HttpServletRequest request) throws Exception;
		
	
}
