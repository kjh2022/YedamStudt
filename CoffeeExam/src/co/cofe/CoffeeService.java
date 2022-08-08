package co.cofe;

import java.util.List;
import java.util.Scanner;

public class CoffeeService {
	Scanner sc = new Scanner(System.in);

	public void getCoffee() {
		List<Coffee> list = CoffeeDAO.getInstance().getCoffee();
//		상품 조회, 메뉴 가격 나오게
		for (Coffee coffee : list) {
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("상품명 : " + coffee.getCoffeeMenu() + //
					", 상품 가격 : " + coffee.getCoffeePrice());
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		}
	}

//	상품 상세 조회 검색으로 메뉴, 가격, 설명이 나오게
	public void getDetailCoffee() {
		System.out.println("메뉴 입력> ");
		String menu = sc.nextLine();
		List<Coffee> list = CoffeeDAO.getInstance().getDetailCoffee(menu);
//		list.get(0).getCoffeeMenu() + //
//		list.get(0).getCoffeePrice() + 
		System.out.println(list.get(0).getCoffeeExplain());

		for (int i = 0; i < list.size(); i++) {
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("상품명 : " + list.get(i).getCoffeeMenu() + //
					", 가격 : " + list.get(i).getCoffeePrice() + //
					", 설명 : " + list.get(i).getCoffeeExplain());
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		}
	}
	
//	메뉴 등록
	public void insertCoffee() {
		Coffee coffee = new Coffee();
		System.out.println("메뉴 입력>");
		String coffeeName = sc.nextLine();
		System.out.println("가격 입력>");
		int coffeePrice = Integer.parseInt(sc.nextLine());
		System.out.println("설명 입력>");
		String coffeeExplain = sc.nextLine();
		
		coffee.setCoffeeMenu(coffeeName);
		coffee.setCoffeePrice(coffeePrice);
		coffee.setCoffeeExplain(coffeeExplain);
		
		int result = CoffeeDAO.getInstance().insertCoffee(coffee);
		
		if(result == 1) {
			System.out.println("등록 성공");
		}else {
			System.out.println("등록 실패");
		}
	}

//	메뉴 삭제 기능
	public void deleteCoffee() {
		System.out.println("삭제할 커피 메뉴명 입력>");
		String menu = sc.nextLine();

		int result = CoffeeDAO.getInstance().delCoffee(menu);

		if (result == 1) {
			System.out.println("메뉴 삭제 완료");
		} else {
			System.out.println("메뉴 삭제 실패");
		}
	}

	
//	매출
	public void salesCoffee() {
		List<Coffee> list = CoffeeDAO.getInstance().getCoffee();
		int sum = 0;
		for (Coffee coffee : list) {
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("메뉴 : " + coffee.getCoffeeMenu() + //
					", 판매 개수 : " + coffee.getCoffeeSales() + //
					", 판매 금액 : " + coffee.getCoffeePrice());
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			
			sum += coffee.getCoffeePrice()*coffee.getCoffeeSales();
		}
		System.out.println("총 매출액 : " + sum + "원");
	}
}
