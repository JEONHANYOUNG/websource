package board.action;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import board.domain.BoardDTO;
import board.domain.PageDTO;
import board.domain.SearchDTO;
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
		
		
		//페이지 나누가 후 추가(받은 것)
		String page = map.get("page");
		String amount = map.get("amount");
		String criteria = map.get("criteria");
		String keyword = URLEncoder.encode(map.get("keyword"),"utf-8");
				
		//----------------------------------------------
		
		// 서비스(insert service)에게 작업을 요청
		BoardUpdateService service = new BoardUpdateService();
		boolean updateFlag = service.update(insertDto);
		
		if (updateFlag) {
			//path = "/read.do?bno=1"
			path += "?page="+page+"&amount="+amount+"&criteria="+criteria
					  +"&keyword="+keyword+"&bno="+insertDto.getBno();
		}else {
			path = "/modify.do?page="+page+"&amount="+amount+"&criteria="+criteria
					  +"&keyword="+keyword+"&bno="+insertDto.getBno(); 
		}
		
		// 결과에 따라 이동 if (!insertFlag) {path = "/view/qna_board_write.jsp"; } 실패하면 /modify.do
		return new BoardActionForward(path, true);
	}

}
