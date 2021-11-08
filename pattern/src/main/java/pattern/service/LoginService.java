package pattern.service;

import java.sql.Connection;

import javax.security.auth.login.AppConfigurationEntry.LoginModuleControlFlag;

import pattern.domain.MemberDTO;
import pattern.persistence.MemberDAO;

import static pattern.persistence.JdbcUtil.*;

public class LoginService {
	public MemberDTO loginService(String userid, String password) {
		//db작업 => 비즈니스 로직(mvc의 모델)
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		
		//usreid와 name이 입력받음
		MemberDTO loginDto = dao.login(new MemberDTO(userid ,password));
			
		return loginDto;
	}
}
