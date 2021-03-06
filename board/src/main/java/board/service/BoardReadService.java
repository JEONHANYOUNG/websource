package board.service;

import java.sql.Connection;

import board.domain.BoardDTO;
import board.persistence.BoardDAO;

import static board.persistence.JdbcUtil.*;

public class BoardReadService {
	public BoardDTO read(int bno) {
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		BoardDTO dto = dao.getRow(bno);
		
		close(con);
		
		return dto;
	}
}
