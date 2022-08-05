package com.bank.app0805;

import java.util.Scanner;

import com.bank.account0805.AccountService;
import com.bank.member0805.MemberService;

public class ManageMent {
	Scanner sc = new Scanner(System.in);
	int menuNo = 0;
	MemberService ms = new MemberService();
	AccountService as = new AccountService();

	public ManageMent() {
		bankJob();
	}

	private void bankJob() {
		menuInfo();

		while (true) {
//			여기에는 메소드만 불러올거임
			if (MemberService.memberInfo.getRole().equals("1")) {
				//1.고객 등록
				if (menuNo == 1) {
					ms.registerCustomer();
				}//2.계좌 개설
				else if (menuNo == 2) {
					as.makeAccount();
				}//3.입출금
				else if (menuNo == 3) {
					as.money();
				}//4.계좌 이체
				else if (menuNo == 4) {
					as.transfer();
				}//5.계좌 해지
				else if (menuNo == 5) {
					as.deleteAccount();
				}//6.대출
				else if (menuNo == 6) {

				}

			} else if (MemberService.memberInfo.getRole().equals("0")) {

			}
		}

	}

	private void menuInfo() {
		if (MemberService.memberInfo.getRole().equals("1")) {
			System.out.println("은행원 업무입니다.");
			System.out.println("1.고객 등록 | 2.계좌 개설 | 3.입금 및 출금 | 4.계좌 이체" //
					+ "| 5.계좌 해지 | 6.대출");

		} else if (MemberService.memberInfo.getRole().equals("0")) {
			System.out.println("1.계좌 조회 | 2.입금 | 3.출금 | 4.계좌 이체 | 5.대출");

		}
		System.out.println("입력> ");
		menuNo = Integer.parseInt(sc.nextLine());
	}

}
