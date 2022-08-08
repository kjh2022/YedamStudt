package com.bank.app0805;

import java.util.Scanner;

import com.bank.account0805.AccountService;
import com.bank.loan0805.LoanService;
import com.bank.member0805.MemberService;

public class ManageMent {
	Scanner sc = new Scanner(System.in);
	int menuNo = 0;
	MemberService ms = new MemberService();
	AccountService as = new AccountService();
	LoanService ls = new LoanService();

	public ManageMent() {
		bankJob();
	}

//은행원 업무 메뉴
	private void bankJob() {

		while (true) {
			menuInfo();
//			여기에는 메소드만 불러올거임
			if (MemberService.memberInfo.getRole().equals("1")) {
				// 1.고객 등록
				if (menuNo == 1) {
					ms.registerCustomer();
				} // 2.계좌 개설
				else if (menuNo == 2) {
					as.makeAccount();
				} // 3.입출금
				else if (menuNo == 3) {
					as.money();
				} // 4.계좌 이체
				else if (menuNo == 4) {
					as.transfer();
				} // 5.계좌 해지
				else if (menuNo == 5) {
					as.deleteAccount();
				} // 6.대출
				else if (menuNo == 6) {
					System.out.println("1.대출 승인 | 2.대출 정보(상태) 변경");
					int menu = Integer.parseInt(sc.nextLine());

					if (menu == 1) {
						ls.insertLoan(); // 대출 승인
					} else if (menu == 2) {
						ls.updateLoan(); // 대출 상태 변경
					}
				} else if (menuNo == 7) {
					ms.logout();
					return;
				}

			} // 일반 고객 메뉴
			else if (MemberService.memberInfo.getRole().equals("0")) {
				if (menuNo == 1) { // 계좌 조회
					as.getAccount();
				} else if (menuNo == 2) { // 입출금
					as.money();
				} else if (menuNo == 3) { // 계좌 이체
					as.transfer();
				} else if (menuNo == 4) { // 대출
					// 1.상환 update
					// 2.대출 조회 select
					System.out.println("1.상환 | 2.대출 조회");
					int menu = Integer.parseInt(sc.nextLine());
					// 상환
					if (menu == 1) {
						ls.updateMoney();

					} // 대출 조회
					else if (menu == 2) {
						ls.loanInfo();
					}
				} else if (menuNo == 5) {
					ms.logout();
					return;
				}
			}
		}

	}

	private void menuInfo() {
		// role == 1, 은행원(관리자) 메뉴
		if (MemberService.memberInfo.getRole().equals("1")) {
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("은행원 업무입니다.");
			System.out.println("1.고객 등록 | 2.계좌 개설 | 3.입금 및 출금 | 4.계좌 이체 " //
					+ "| 5.계좌 해지 | 6.대출 | 7.로그아웃");
			// role == 0, 일반 사용자
		} else if (MemberService.memberInfo.getRole().equals("0")) {
			System.out.println("1.계좌 조회 | 2.입, 출금 | 3.계좌 이체 | 4.대출 | 5.로그아웃");

		}
		System.out.println("입력> ");
		menuNo = Integer.parseInt(sc.nextLine());
	}

}
