package co.cofe;

import co.coffee.common.DAO;
import lombok.Data;
import lombok.ToString;
//@NoArgsConstructor //매개변수가 없는 기본 생성자 만들어줌
//@AllArgsConstructor //모든 필드를 가져와서 만드는 생성자
@ToString //오버라이딩과 비슷
@Data // 앞의 모든 명령어를 한번에 다 넣어줌

public class Coffee extends DAO {
	private String coffeeMenu;
	private int coffeePrice;
	private String coffeeExplain;
	private int coffeeSales;
}
