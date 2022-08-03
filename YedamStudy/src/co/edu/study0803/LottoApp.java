package co.edu.study0803;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoApp {
	Scanner scan = new Scanner(System.in);

	int menu = 0;
	List<int[]> list = new ArrayList<>();

	public LottoApp() {
		run();
	}

	private void run() {
		while (menu != 99) {
			menuInfo();
			menu = Integer.parseInt(scan.nextLine());

			switch (menu) {
			case 1:
				makeLotto();
				break;
			case 2:
				showInfo();
				break;
			case 99:
				System.out.println("프로그램 종료");
				break;
			}
		}
	}

	private void menuInfo() {
		System.out.println("메뉴를 선택해 주세요.\n");
		System.out.println("1.로또생성 2.로또조회 99.프로그램 종료");
	}

	private void makeLotto() {
		System.out.println("금액을 투입해 주세요.");
		int money;
		money = Integer.parseInt(scan.nextLine());

		for (int i = 0; i < (money) / 1000; i++) {
			list.add(makeNumber());
		}
		System.out.println("번호 출력 완료\n");
	}

	private void showInfo() {
		System.out.println("구매한 금액> " + (list.size() * 1000) + "원");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i % 5 + 1) + "번>");
			for (int j = 0; j < 6; j++) {
				System.out.print(list.get(i)[j] + " ");
			}
			System.out.println();

			if ((i + 1) % 5 == 0) {
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			}
		}
	}

	private int[] makeNumber() {
		int[] lottoNo = new int[6];
		
		for (int i=0; i<6; i++) {
			
			int randomNo = (int) (Math.random() * 45) + 1;
			
			if(i>0) {
				for(int j=0; j<i; j++) {
				if (lottoNo[j] == randomNo) {
					i -= 1;
					System.out.println("중복 제거 완료");
					break;
				}else if ((j+1)==i) {
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