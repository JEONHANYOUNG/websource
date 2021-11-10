package member.service;

import java.sql.Connection;

import static member.persistence.JdbcUtil.*;

import member.domain.UpdateDTO;
import member.persistence.MemberDAO;

public class ModifyService {
	
	public boolean Modify(UpdateDTO updateDto) {
		
	Connection con = getConnection();
	MemberDAO dao = new MemberDAO(con);
	
	boolean updateFlag = dao.update(updateDto); 
	
	if(updateFlag) {
		commit(con);
	} else {
		rollback(con);
	}
	  close(con);
			
		
		
		return updateFlag;
	
	}
	
	
	
//	public boolean ModifyService(String changepassword, String userid, String password) {
//		
//	Connection con = getConnection();
//	MemberDAO dao = new MemberDAO(con);
//	
//	boolean modifyFlag = dao.modify(UpdateDto); 
//			
//	if(modifyFlag) {
//		commit(con);
//	} else {
//		rollback(con);
//	}
//	  close(con);
//			
//			
//		
//		return false;
//	}
}
