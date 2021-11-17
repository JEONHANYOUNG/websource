package board.service;

import java.sql.Connection;

import board.domain.BoardDTO;
import board.persistence.BoardDAO;
import static board.persistence.JdbcUtil.*;

public class BoardRemoveService {
	public boolean remove(int bno, String password) {
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		boolean	deleFlag = dao.delete(bno, password);
		
		if (deleFlag) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return deleFlag;
				
	}
}
