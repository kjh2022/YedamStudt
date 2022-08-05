package com.yedam.member0804;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common0804.DAO;

//여기를 싱글톤으로 만들 것
public class MemberManagement extends DAO {
//	싱글톤 생성
	private static MemberManagement mm = null; // mm = 어디서든 공유가 가능하게 만듦

//	private 생성자
	private MemberManagement() {
	}

//	단 하나의 객체를 사용할 수 있도록 메소드 생성
	public static MemberManagement getInstance() {
		if (mm == null) {
			mm = new MemberManagement();
			return mm;
//			return new MemberManagement();
		} else {
			return mm;
		}
	}

	// CRUD만들기
	// 1.전체 조회
	public List<Member> getMemberList() {
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			// 1.db연결
			conn();
			// 2.쿼리작성
			String sql = "select * from member";
			// 3.db연결 후 조회 할 수 있는 창구 생성해야함
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			// 4.출력 데이터여러건이라
			while (rs.next()) {
				member = new Member();
				member.setId(rs.getNString("id"));
				member.setName(rs.getString("name"));
				member.setPw("pw");
				list.add(member);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 2.단건 조회 primary key를 가진 id로 조회?
	public Member getMember(String id) {
		Member member = null;
		try {
			conn();
			String sql = "select * from member where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); // 매개변수 타입이 string이라서 매개변수를 통한 데이터 조회를 하기위해서는 타입이 같아야함
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPw(rs.getString("pw"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return member;
	}

	// 3.입력
	public int insertMember(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "insert into member values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	// 4.수정
	public int updateMember(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "update member set pw = ? where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	// 5.삭제
	public int deleteMember(String id) {
		int result = 0;
		try {
			conn();
			String sql = "delete from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
}
