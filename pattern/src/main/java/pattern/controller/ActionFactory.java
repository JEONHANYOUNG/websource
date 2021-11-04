package pattern.controller;

public class ActionFactory {
	
	//객체 생성을 하나만 하는 방식(singleton pattern(패턴))
	private static ActionFactory af;
		
	private ActionFactory() {}
	public static ActionFactory getInstance() {
		if (af == null) { //null일 경우만 객체 생성
			 af = new ActionFactory();
		}
		return af; //return 한다
	}
	
}

