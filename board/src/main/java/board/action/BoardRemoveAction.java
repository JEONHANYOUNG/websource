package board.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import lombok.AllArgsConstructor;
import board.domain.BoardDTO;
import board.persistence.BoardDAO;
import board.service.BoardRemoveService;

@AllArgsConstructor
public class BoardRemoveAction implements BoardAction {

	private String path;
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		
		int bno = (Integer.parseInt(request.getParameter("bno")));
		String password = request.getParameter("password");
						 
		BoardRemoveService service = new BoardRemoveService();
		boolean deleFlag = service.remove(bno, password);
		
		if (!deleFlag) {
			path = "/view/qna_board_pwdCheck.jsp?bno="+bno;
		}
		
		return new BoardActionForward(path, true);
	}

}
