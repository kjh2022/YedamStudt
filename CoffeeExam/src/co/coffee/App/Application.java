package co.coffee.App;

import java.util.Scanner;

import co.cofe.CoffeeService;

public class Application {
	Scanner sc = new Scanner(System.in);
	CoffeeService cs = new CoffeeService();

	public Application() {
		start();
	}

	private void start() {
		while (true) {
			System.out.println("1.메뉴 조회 | 2.메뉴 상세 조회 | 3.메뉴 등록 |" //
					+ " 4.판매 | 5.메뉴 삭제 | 6.매출 | 7.종료");
			int menuNo = Integer.parseInt(sc.nextLine());

			if (menuNo == 1) {
				cs.getCoffee();
			} else if (menuNo == 2) {
				cs.getDetailCoffee();
			} else if (menuNo == 3) {
				cs.insertCoffee();
			} else if (menuNo == 4) {
				
			} else if (menuNo == 5) {
				cs.deleteCoffee();
			} else if (menuNo == 6) {
				cs.salesCoffee();
			} else if (menuNo == 7) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}
