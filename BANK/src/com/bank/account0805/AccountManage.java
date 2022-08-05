package com.bank.account0805;

import com.bamk.common0805.DAO;

public class AccountManage extends DAO {
//	싱 글 톤 톤 
	private static AccountManage am = new AccountManage();

	private AccountManage() {

	}

	public static AccountManage getInstance() {
		return am;
	}

//	계좌 개설 메소드 생성
	public int insertAccount(Account account) {
		int result = 0;
		try {
			conn();
			String sql = "insert into account (account_id, member_id)\r\n" + "values ('?', '?')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getAccountId());
			pstmt.setString(2, account.getMemberId());

			result = pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			disconnect();
		}
		return result;
	}

//	입출금					매개변수 추가
	public int updateMoney(Account account, int cmd) {
		int result = 0;
		try {
			conn();
			/*
			 * 입출금 ㅡ> update 계산한 데이터를 바로 넣어주면 된다 다른 연산 필요없ㄱ이 가능함 현재 잔고를 가져오는 query문이 필요해짐
			 */
			String sql2 = "SELECT balance FROM account WHERE account_id";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, account.getAccountId());
			rs = pstmt.executeQuery();

			int balance = 0;
			if (rs.next()) {
				balance = rs.getInt("balance");
			}
			// 잔고 계산
			// 입금 = 1, 출금 = 2
			if (cmd == 1) {
				// balance =>현재 잔고
				// account.getBalance() =>새로 입금하고자 하는 금액
				// balance + account.getBlance() => 입금한 금액
				account.setBlance(balance + account.getBlance());

				String sql = "UPDATE account SET balance = ? WHERE account_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, account.getBlance());
				pstmt.setString(2, account.getAccountId());
				result = pstmt.executeUpdate();

			} else if (cmd == 2) { // 0일 경우도 발생할 수 있기때문에 >= 으로 맞춤
				if (balance - account.getBlance() >= 0) {
					account.setBlance(balance - account.getBlance());

					String sql = "UPDATE account SET balance = ? WHERE account_id = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, account.getBlance());
					pstmt.setString(2, account.getAccountId());

					result = pstmt.executeUpdate();

				} else { // 잔고 < 출금액
					System.out.println("잔액이 부족합니다. 다시 입력해 주세요.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

//	3.계좌 해지 매소드 만들기
	public int delAccount(String accountId) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM account WHERE account_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountId);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

//	4.계좌 이체 //toAccount = 받는 사람, formAccount = 보내는 사람, balacne 금액
	public void transferMoney(String toAccount, String fromAccount, int balance) {

		int result = 0;
		try {
			conn();

			// 보내는 사람의 계좌에는 돈을 출금 해주는 query 필요
			String sql2 = "UPDATE account SET balance = balance - ? WHERE account_id = ?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, balance);
			pstmt.setString(2, fromAccount);
			result = pstmt.executeUpdate();

			if (result == 1) {
				System.out.println("정상 출금");

				// 받는 사람의 계좌에 돈을 넣어주는 sql문
				String sql = "UPDATE account SET balance = balance + ? WHERE account_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, balance);
				pstmt.setString(2, toAccount);
				int result2 = pstmt.executeUpdate();
				if (result2 == 1) {
					System.out.println("계좌 이체 완료");
				} else {
					System.out.println("계좌 이체 실패");
				}
			} else {
				System.out.println("출금 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}
