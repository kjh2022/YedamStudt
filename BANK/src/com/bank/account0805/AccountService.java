package com.bank.account0805;

import java.util.Scanner;

/*1.계좌 개설 2.입금&출금 4.계좌 해지 5.계좌 이체*/
public class AccountService {
	Scanner sc = new Scanner(System.in);

	public void makeAccount() {
		Account ac = new Account();

		// 계좌 개설에 필요한 정보 ) 계좌번호, 멤버id, 날짜
		System.out.println("계좌 번호> ");
		String accountId = sc.nextLine();
		System.out.println("고객 ID> ");
		String customId = sc.nextLine();

		ac.setAccountId(accountId);
		ac.setMemberId(customId);
	}

//	2.입출금
	public void money() {
		Account account = new Account();

		System.out.println("1.입금 | 2.출금");
		int cmd = Integer.parseInt(sc.nextLine());

		System.out.println("계좌번호 입력> ");
		String accountId = sc.nextLine();
		if (cmd == 1) {
			System.out.println("입금할 금액 입력> ");

		} // 출금
		else if (cmd == 2) {
			System.out.println("출금할 금액 입력> ");
		}

		int money = Integer.parseInt(sc.nextLine());

		account.setAccountId(accountId);
		account.setBlance(money);

//		싱글톤 불러오기
		int result = AccountManage.getInstance().updateMoney(account, cmd);

		if (result == 1 && cmd == 1) {
			System.out.println("입금 완료");
		} else if (result == 1 && cmd == 2) {
			System.out.println("출금 완료");
		}
	}

//	5.계좌 해지 ->delete
	public void deleteAccount() {
		System.out.println("======계좌 해지======");
		System.out.println("해지하려는 계좌번호 입력");
		String accountId = sc.nextLine();

		int result = AccountManage.getInstance().delAccount(accountId);
		if (result == 1) {
			System.out.println("계좌 정상 해지 완료");
		} else {
			System.out.println("해지되지 않았습니다.");
		}
	}
	
//	4.계좌 이체
	//1.받는 사람 계좌 번호
	//2.보내는 사람 계좌 번호
	//3.보내는 사람의 계좌 비밀번호 | join사용, select 이용하여 계좌와 비밀번호가 맞는지 확인
	// ㄴ == 데이터 유효성 검사
	//4.출금 금액
	public void transfer() {
		System.out.println("======계좌 이체======");
		
		System.out.println("받는 사람 계좌");
		String toAccountId =  sc.nextLine();
		
		System.out.println("보내는 사람 계좌");
		String FromAccounId = sc.nextLine();
		
		System.out.println("출금 금액");
		int balance = Integer.parseInt(sc.nextLine());
		
		AccountManage.getInstance().transferMoney(toAccountId, FromAccounId, balance);
	}
	
	
}
