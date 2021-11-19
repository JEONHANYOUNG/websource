package board.action;

import java.net.URLEncoder;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import board.service.BoardCountUpdateService;
import lombok.AllArgsConstructor;

@AllArgsConstructor

public class BoardCountUpdateAction implements BoardAction {

	private String path;
	
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		//페이지 나누가 후 추가(받은 것)
		String page = request.getParameter("page");
		String amount = request.getParameter("amount");
		String criteria = request.getParameter("criteria");
		String keyword = URLEncoder.encode(request.getParameter("keyword"), "utf-8");
		
		
		//----------------------------------------------

		
		//조회수 변경
		BoardCountUpdateService updateService = new BoardCountUpdateService();
		updateService.readUpdate(bno);
	
     	//path += "?bno="+bno;
		
		//페이지 나누기 후(보내는 것)
		path += "?page="+page+"&amount="+amount+"&criteria="+criteria+"&keyword="+keyword+"&bno="+bno;
				
		return new BoardActionForward(path, true);
	}

}
