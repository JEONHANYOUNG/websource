package book.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import book.domain.BookDTO;
import book.service.BookListService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookListAction implements BookAction {

	private String path; //   "/view/all.jsp"
	
	@Override
	public BookActionForward execute(HttpServletRequest request) throws Exception {
		//서비스 호출
		BookListService service = new BookListService();
		List<BookDTO> list = service.getList();
		
		request.setAttribute("list", list); //이 구문을 쓰면 false해줘라
		
				
		return new BookActionForward(path, false);
	}

}
