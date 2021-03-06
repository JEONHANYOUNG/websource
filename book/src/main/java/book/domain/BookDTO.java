package book.domain;
//생성자 역할
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter


public class BookDTO {
	private String code;
	private String title;
	private String writer;
	private int price;
}
