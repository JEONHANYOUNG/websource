package board.action;

import java.net.URLEncoder;
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

		//페이지 나누가 후 추가(받은 것)
		String page = request.getParameter("page");
		String amount = request.getParameter("amount");
		String criteria = request.getParameter("criteria");
		String keyword = URLEncoder.encode(request.getParameter("keyword"), "utf-8");
		//----------------------------------------------
		
		BoardRemoveService service = new BoardRemoveService();
		boolean deleFlag = service.remove(bno, password);
		
		if (!deleFlag) {
			path = "/view/qna_board_pwdCheck.jsp?page="+page+"&amount="+amount+"&criteria="
					+criteria+"&keyword="+keyword+"&bno="+bno;
		} else {
			path += "?page="+page+"&amount="+amount+"&criteria="+criteria
					+"&keyword="+keyword+"&bno="+bno;
		}
		
		return new BoardActionForward(path, true);
	}

}
