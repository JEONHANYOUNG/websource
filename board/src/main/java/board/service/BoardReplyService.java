package board.service;

import java.sql.Connection;

import board.domain.BoardDTO;
import board.persistence.BoardDAO;
import static board.persistence.JdbcUtil.*;

public class BoardReplyService {
	public boolean reply(BoardDTO dto) {
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);

		//replyUpdate
		dao.replyUpdate(dto);
		commit(con);

		//InsertUpdate
		boolean InsertFlag = dao.replyInsert(dto);
		
		if (InsertFlag) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return InsertFlag;
	
	
	}
}
