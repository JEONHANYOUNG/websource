package pattern.controller;



import pattern.action.Action;
import pattern.action.LoginAction;

public class ActionFactory {
	
	//객체 생성을 하나만 하는 방식(singleton pattern(패턴)), 정형화 되어있음
	private static ActionFactory af; //af가 null일때만 한번 만들어라는 if문 작성
		
	private ActionFactory() {}
	public static ActionFactory getInstance() {// getInstance라는 메소드 호출, 열어놓음, 원래는 private는 내부에서만 생성 가능하나 static이 있어서 외부도 가능 
		if (af == null) { //null일 경우만 객체 생성
			 af = new ActionFactory();
		}
		return af; //기존에 한번 만든 것이 있으면, null 아니면 af로 return 한다
	}
	
	//메세지는 안넘기고 우리가 작성한 것을 Pattern에 넘긴 것
	Action action=null;
	
	public Action action(String cmd) {
		//action 작업이 성공하면 움직일 페이지 기록
		if (cmd.equals("/login.do")) {
			action = new LoginAction("/index.jsp"); //InsertAction 객체가 만들어진것, loginAction이 담당
		} else if (cmd.equals("/update.do")) {
			
		} else if (cmd.equals("/index.do")) {
		
			
		}
				
		return action; //실행하면 PatternController, InsertAction이 리턴된 것
		
		
		
		
	}
	
	
	
}

