package board.action;

import javax.servlet.http.HttpServletRequest;

import board.domain.BoardDTO;
import board.service.BoardCountUpdateService;
import board.service.BoardReadService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardReadAction implements BoardAction {

	private String path; // /read.do로 가라
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		//list.do?bno=1 bno값 가져오기
		
		//java.lang.NumberFormatException: null => Integer.parseInt 이걸 쓰면 나옴(숫자여서 값이 안올라옴)
		int bno = Integer.parseInt(request.getParameter("bno")); //이 부분이 안넘어오면 
		
		// 서비스 요청
		BoardReadService service = new BoardReadService();
		BoardDTO dto = service.read(bno);
		
		// 이동
		request.setAttribute("dto", dto);
		
		return new BoardActionForward(path, false);
	}

}
