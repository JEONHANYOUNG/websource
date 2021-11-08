package pattern.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberDTO {
		private String userid;
		private String password;
		private String changepassword;
		private String name;
		private String gender;
		private String email;
		public MemberDTO(String userid, String password) {
			this.userid=userid;
			this.password=password;
 }
}
