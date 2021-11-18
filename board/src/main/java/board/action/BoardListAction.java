package board.action;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import board.domain.BoardDTO;
import board.domain.PageDTO;
import board.domain.SearchDTO;
import board.service.BoardListService;
import board.service.BoardTotalRowsService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardListAction implements BoardAction {

	private String path; // /view/qna_board_list.jsp
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception { 
		
		//페이지 나누기 개념
		
		//사용자가 선택한 페이지 번호
		int page = 1;
		if (request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		
		}
		//한 페이지에 보여줄 게시물 수
		int amount = 10;
		
		//검색 기준과 검색어
		SearchDTO searchDto = new SearchDTO();
		searchDto.setCriteria(request.getParameter("criteria"));
		searchDto.setKeyword(request.getParameter("keyword"));
		
		BoardTotalRowsService rowsservice = new BoardTotalRowsService();
		int total = rowsservice.totalRows(searchDto);
		
		PageDTO pageDto = new PageDTO(total, page, amount, searchDto);

		request.setAttribute("searchDto", searchDto); 
		request.setAttribute("pageDto", pageDto);
		
		//-------------------- 페이지 나누기
		
		BoardListService service = new BoardListService();
		List<BoardDTO> list = service.all(pageDto);
		
		request.setAttribute("list", list); // 전체를 담은 것
		
		return new BoardActionForward(path, false);
	}

}
