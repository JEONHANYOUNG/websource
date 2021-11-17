package board.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import board.domain.BoardDTO;
import board.service.BoardUpdateService;
import board.util.UploadUtil;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardUpdateAction implements BoardAction {

	private String path;
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {

		// request를 UploadUtil 넘기기
		UploadUtil uploadUtil = new UploadUtil();
		Map<String, String> map = uploadUtil.requestParse(request);
				
	    // map에서 값 가져오기
		BoardDTO insertDto = new BoardDTO();
		insertDto.setBno(Integer.parseInt(map.get("bno")));
		insertDto.setName(map.get("name"));
		insertDto.setTitle(map.get("title"));
		insertDto.setContent(map.get("content"));
		insertDto.setPassword(map.get("password")); 
		//파일 첨부
		insertDto.setAttach(map.get("attach"));
		
		// 서비스(insert service)에게 작업을 요청
		BoardUpdateService service = new BoardUpdateService();
		boolean updateFlag = service.update(insertDto);
		
		if (updateFlag) {
			//path = "/read.do?bno=1"
			path += "?bno="+insertDto.getBno();
		}else {
			path = "/modify.do?bno="+insertDto.getBno(); 
		}
		
		// 결과에 따라 이동 if (!insertFlag) {path = "/view/qna_board_write.jsp"; } 실패하면 /modify.do
		return new BoardActionForward(path, true);
	}

}
