package member.action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 이동 경로와 이동 방식 저장
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ActionForward { //forward : 주소줄은 그대로 나와있으나 보여지는 내용은 같지 않음(주소줄과 보여지는 페이지가 같지 않다)
	private String path; 
	private boolean redirect;
}
