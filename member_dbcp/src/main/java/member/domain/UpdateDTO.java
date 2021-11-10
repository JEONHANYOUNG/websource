package member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import oracle.net.aso.b;

@AllArgsConstructor
@Getter
@Setter

public class UpdateDTO {
	private String userid;
	private String current_password;
	private String new_password;
	private String confirm_password;

	public boolean passwordEqualTo(String confirmPassword) {//password와 confirmpassword가 같은지 물어본 것
		return this.new_password.equals(confirmPassword);
	}
	
}
