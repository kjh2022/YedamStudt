package com.bank.loan0805;

import java.util.ArrayList;
import java.util.List;

import com.bamk.common0805.DAO;

public class LoanManage extends DAO {
	private static LoanManage loanManage = null;

	private LoanManage() {

	}

//	필요할때만 사용할 수 있게끔 만드는것
	public static LoanManage getInstance() {
		if (loanManage == null) {
			loanManage = new LoanManage();
		}
		return loanManage;
	}

//	은행원은행원 대출)
//	1.대출 승인 insert
//	2.대출 정보 변경(잘 갚을 경우 y, 연체되는 고객은 n으로 표기) update
	public int insertLoan(Loan loan) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO loan VALUES (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loan.getLoanId());
			pstmt.setString(2, loan.getMemberId());
			pstmt.setDate(3, loan.getLoanDate());
			pstmt.setString(4, loan.getState());
			pstmt.setInt(5, loan.getLoanMoney());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

//	일반 고객 대출)
//	1.상환 update
	public int updateMoney(Loan loan) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE loan SET loan_money = loan_money - ? WHERE loan_id = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, loan.getLoanMoney());
			pstmt.setString(2, loan.getLoanId());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	
//	대출 상태 변경 y, n 정상채납, 불량채납 구분
	public int updateLoan(Loan loan) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE loan SET state = ? WHERE loan_id = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, loan.getState());
			pstmt.setString(2, loan.getLoanId());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

//	일반 고객 2.대출 조회
//	loan table column추가 loan_money
//	조회시 출력값 고객이름, 대출자id, 대출금액, 대출날짜 
//	loan table에 없는 정보를 가져오기 위해서 join 작업 필요함
	public List<Loan> getLoanInfo(String memberId) {
		List<Loan> list = new ArrayList<Loan>();
		Loan loan = null;

		try {
			conn();
			String sql = "SELECT b.member_name member_name , l.loan_id loan_id," //
					+ " l.loan_money loan_money, l.loan_date loan_date\r\n" //
					+ "FROM bankmember b join loan l\r\n" //
					+ "ON b.member_id = l.member_id;\r\n" //
					+ "WHERE b.member_id = '1'\r\n"; //
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				loan = new Loan();
				// member_name, loan_id, loanMoney, loanDate

				loan.setMemberId(rs.getString("member_name"));
				loan.setLoanId(rs.getString("loan_id"));
				loan.setLoanMoney(rs.getInt("loan_money"));
				loan.setLoanDate(rs.getDate("loan_daye"));

				list.add(loan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

}
