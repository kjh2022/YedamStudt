package com.bank.app0805;

import java.util.Scanner;

import com.bank.member0805.MemberService;

public class Application {
	Scanner sc = new Scanner(System.in);
	int menuNo = 0;
	MemberService ms = new MemberService();

	// 0.로그인
	public Application() {
		run();
	}

	private void run() {
		System.out.println("1.로그인 | 2.종료");
		menuNo = Integer.parseInt(sc.nextLine());
		switch (menuNo) {
		case 1:
//			로그인 하는 기능 입력
			ms.doLogin();
			if (MemberService.memberInfo != null) {
				new ManageMent();

			}

			break;
		case 2:
			// 고민중
			ms.logout();
			System.out.println("로그아웃 되었습니다.");
			break;

		}
	}
}
