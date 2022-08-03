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
		}
	}

	private void showInfo() {
		System.out.println("구매 한 금액>" + (list.size() * 1000) + "원");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i % 5 + 1) + "번");
			for (int j = 0; j < 6; j++) {
				System.out.println(list.get(i)[j] + " ");
			}
			System.out.println();
			if ((i + 1) != 0 && (i + 1) % 5 == 0) {
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			}
		}
	}

	private int[] makeNumber() {
		int[] lottoNo = new int[6];

		for (int i = 0; i < 6; i++) {

			int randomNo = (int) (Math.random() * 45) + 1;

			if (i > 0) {
				for (int j = 0; j < i; j++) {
					if (lottoNo[j] == randomNo) {
						i -= 1;
						System.out.println("중복제거");
						break;
					}else if ((j+1) == i) {
						
					}
				}
			
			}
		}
		return lottoNo;
	}
}
