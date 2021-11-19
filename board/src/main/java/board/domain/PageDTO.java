package board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

//페이지 나누기와 관련된 정보
public class PageDTO {
	
	private int startPage;  //시작 페이지
	private int endPage;    //마지막 페이지
	private boolean prev;   //이전버튼 활성화여부
	private boolean next;   //다음버튼 활성화여부
	private int total;      //전체 게시물
	
		
	private int page; //현재 페이지 번호
	private int amount; //페이지당 게시물 수(10)
	
	private SearchDTO searchDto;
	
	public PageDTO(int page, int amount) {
		super();
		this.page = page;
		this.amount = amount;
	}

	public PageDTO(int total, int page, int amount, SearchDTO searchDto) {
		super();
		this.total = total;         // ex) 400 => 총 400개의 페이지
		this.page = page;           // ex) 3 => 왼쪽은 1이고 현재 페이지, 오른쪽 마지막 페이지를 보여주는 항목 3개
		this.amount = amount;       // ex) 10 => 화면 상에는 10개만 보여주는 것
		this.searchDto = searchDto; // ex) 기준 => 전체 페이지를 기준한 것 
	
		//마지막 페이지 계산
		endPage= (int)(Math.ceil(this.page/10.0))*10;
		//시작 페이지 계산
		startPage = endPage-9;
		
		//끝나는 페이지는 10개가 안될 수도 있기 때문에 다시 계산
		int realEnd = (int)(Math.ceil(this.total/1.0)/this.amount);
		
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		} 
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
	}
	
	
	
}
