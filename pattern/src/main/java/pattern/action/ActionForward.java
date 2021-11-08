package pattern.action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ActionForward {
	//이동 경로와 이동 방식 저장
	private String path;
	public	boolean redirect; // true로 선택하면 sendRedirect, false로 선택하면 forward
}
