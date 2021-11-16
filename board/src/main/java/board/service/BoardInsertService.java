package board.service;

import static board.persistence.JdbcUtil.*;
import java.sql.Connection;
import board.domain.BoardDTO;
import board.persistence.BoardDAO;

//비즈니스 로직 처리
public class BoardInsertService {
	public boolean boardInsert(BoardDTO insertDto) {
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		boolean insertFlag = dao.insert(insertDto);
		
		if (insertFlag) {
			commit(con);
		}else {
			rollback(con);
			
		}
		close(con);
		return insertFlag;
	}
}
