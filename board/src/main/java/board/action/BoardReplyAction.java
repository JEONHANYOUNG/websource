package board.action;

import javax.servlet.http.HttpServletRequest;

import board.domain.BoardDTO;
import board.service.BoardReplyService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardReplyAction implements BoardAction {

	private String path;
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		
		BoardDTO dto = new BoardDTO();
		//댓글에 대한 정보
		dto.setName(request.getParameter("name"));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setPassword(request.getParameter("password"));
		//원본 글에 대한 정보
		dto.setRe_ref(Integer.parseInt(request.getParameter("re_ref")));
		dto.setRe_seq(Integer.parseInt(request.getParameter("re_seq")));
		dto.setRe_lev(Integer.parseInt(request.getParameter("re_lev")));
		
		BoardReplyService service = new BoardReplyService();
		boolean replyFlag = service.reply(dto);
		
		if (!replyFlag) {
			path = "/read.do?bno="+request.getParameter("bno");
		} 
		
		return new BoardActionForward(path, true);
	}

}
