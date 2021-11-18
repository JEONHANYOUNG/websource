package board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import board.domain.BoardDTO;
import board.domain.SearchDTO;
import board.service.BoardSearchService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardSearchAction implements BoardAction {

	private String path;
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		
		//검색 폼에서 넘긴 값 가져오기
		SearchDTO searchDto = new SearchDTO();
		searchDto.setCriteria(request.getParameter("criteria"));
		searchDto.setKeyword(request.getParameter("keyword"));
		
		
		BoardSearchService service = new BoardSearchService();
		List<BoardDTO> searchList =  service.search(searchDto);
			
		
		// ""안에 들어있는 것은 qna_board_list에서 <c:forEach var="dto" items="${list}"> 이부분에 해당하는 것이고, 
		// 뒤에 searList는 BoardSearchAction에 해당하는 것이다.
		// 이동시키는 구문
		request.setAttribute("list", searchList); 
		request.setAttribute("searchDto", searchDto); 
				
		
		return new BoardActionForward(path, false);
	}

}