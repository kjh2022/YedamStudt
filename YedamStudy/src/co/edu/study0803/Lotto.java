package co.edu.study0803;

public class Lotto {

	private int[] lottoNo;
	private String name;
	public int[] getLottoNo() {
		return lottoNo;
	}
	public void setLottoNo(int[] lottoNo) {
		this.lottoNo = lottoNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
/*
while (run) {
	

	switch (choice) {
	case 1:
		System.out.println("금액을 투입해 주세요.");
		money = Integer.parseInt(scan.next());
		if (money < 1000) {
			System.out.println("금액은 1천원 이상, 1천원 단위로 투입해 주세요.");
			continue;
		}

		
		System.out.println("번호 출력 완료");
					break;

	case 2:
		System.out.println("구매 한 금액> " + money + "원");
		int game = money / 1000;
		for (int i = 0; i < 5; i++) {
			System.out.println(i + "번>" + lotto[i]);
			
			System.out.println("");
		}
		break;
	case 3:
		run = false;
		System.out.println("프로그램 종료");
	default:
		System.out.println("올바르지 않은 입력입니다. 다시 입력해 주세요.");
}
}
//System.out.println("프로그램을 종료합니다.");scan.close();
}}
*/