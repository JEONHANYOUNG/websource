package member.controller;

import member.action.Action;
import member.action.DuplicationAction;
import member.action.JoinAction;
import member.action.LeaveAction;
import member.action.LoginAction;
import member.action.LogoutAction;
import member.action.ModifyAction;

public class MemberActionFactory {
	//singleton 객체 생성
	private static MemberActionFactory maf;// 여기서만 사용할 수 있다.
	private Action action;
	
	private MemberActionFactory() {}
	public static MemberActionFactory getInstance() {
		if (maf == null) {
			maf = new MemberActionFactory(); 
			
		}
		return maf;
	}
	
	
	public Action action(String cmd) {
	    //action 이 성공한 후 가야할 페이지
	    if(cmd.equals("/login.do")) { //login할거면 여기로 가라
	      action = new LoginAction("/view/loginForm.jsp");
	    }else if(cmd.equals("/logout.do")) {
	      action = new LogoutAction("/index.jsp");
	    }else if(cmd.equals("/leave.do")) {
	    	action = new LeaveAction("/index.jsp");   	
	    }else if(cmd.equals("/modify.do")) {
	    	action = new ModifyAction("/view/loginForm.jsp");   				
	    }else if (cmd.equals("/join.do")) {
	    	action = new JoinAction("/view/loginForm.jsp");
	    } else if(cmd.equals("/dupId.do")) {
			action = new DuplicationAction("/view/dupid.jsp");
		}
		
	    return action;
	   
	
}
}
