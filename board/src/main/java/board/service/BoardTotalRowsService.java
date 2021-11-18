package board.service;

import java.sql.Connection;

import board.domain.SearchDTO;
import board.persistence.BoardDAO;

import static board.persistence.JdbcUtil.*;

public class BoardTotalRowsService {
		public int totalRows(SearchDTO searchDto) {
			Connection con = getConnection();
			BoardDAO dao = new BoardDAO(con);
			
			int total = dao.totalRows(searchDto);
			
			close(con);
			
			return total;
		}


}
