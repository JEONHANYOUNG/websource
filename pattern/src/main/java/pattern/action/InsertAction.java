package pattern.action;

import javax.servlet.http.HttpServletRequest;

public class InsertAction implements Action { //pattern.action을 걸어준 것

	@Override
	//execute의 리턴 타입이 ActionForward(path와 redirect을 채워서 넘겨줘야한다.)이어야 한다.
	//execute를 부르면 ActionForward으로 리턴 타입이므로 PatternController으로 넘긴 것
	public ActionForward execute(HttpServletRequest request) throws Exception { 
		
		return new ActionForward("insert.jsp" , false); // ActionForward를 생성을 하고 어느 방향으로 갈건지 return 하는 것
	}

}
