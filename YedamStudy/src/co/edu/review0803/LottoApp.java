package co.edu.review0803;
//컴퓨터의 사고 이해
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoApp {

	Scanner sc = new Scanner(System.in);

	int menu = 0;

	List<int[]> list = new ArrayList<>();
//	로또 앱이라는 생성자에 run()이라는 메소드를 실행시키는것
	public LottoApp() {
		run();
	}
//	캡슐화, 정보은닉을 위해서
	private void run() {

		while (menu != 99) {

			menuInfo();	//메뉴를 출력하는 메소드 호출
			menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				makeLotto(); //로또생성
				break;
			case 2:
				showInfo(); //로또번호 조회
				break;

			case 99:
				System.out.println("프로그램 종료");
				break;
			}
		}

	}

	private void menuInfo() {
		System.out.println("메뉴를 선택해주세요.\n");
		System.out.println("1. 로또생성 2. 로또조회 99. 프로그램 종료");
	}

	private void makeLotto() {
		
		System.out.println("금액을 투입해주세요.");
		
		int money;
		
		money = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < (money / 1000); i++) {
			list.add(makeNumber()); //리스트에 완성된 로또번호 넣기, makeNumber이라는 메소드에서 로또번호 생성
		}
		
		System.out.println("번호 출력 완료\n");
	}

	private void showInfo() {
		
		System.out.println("구매 한 금액> " + (list.size() * 1000) + "원");
		
		for (int i = 0; i < list.size(); i++) {
			// 1번, 2번
			System.out.print((i % 5 + 1) + "번>");
			// 로또 번호 출력
			for (int j = 0; j < 6; j++) {
				System.out.print(list.get(i)[j] + " ");
			}
			
			System.out.println();
			//&&, &
			               // i=0, i % 5 == 0
			if ((i+1) % 5 == 0) { //리스트의 길이를 받아와서 5개씩 잘라 쓰는것
				System.out.println("-------------------------------------");
			}
		}
	}

	private int[] makeNumber() {
		
		int[] lottoNo = new int[6];

		for (int i = 0; i < 6; i++) {
			
			int randomNo = (int) (Math.random() * 45) + 1;
			
			//첫번째 값은 중복체크 할 필요 없음.
			if (i > 0) {
			                  // j =0, i번째까지, i = 3(index = 0,1,2,3)
				for (int j = 0; j < i; j++) {
				//40, 30, 20 <-배열에 들어있는 값
				//20 <- randomNo
					//i=2
					if (lottoNo[j] == randomNo) {
						i -= 1;
						System.out.println("중복제거!");
						break;
					}else if((j+1)==i) {
						lottoNo[i] = randomNo;
					}
				}
			}else {
				lottoNo[i] = randomNo;
			}
		}
		
		return lottoNo;
	}
}
