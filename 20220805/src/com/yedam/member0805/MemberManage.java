package com.yedam.member0805;


//member 관련 sql(database)을 모두 작성
public class MemberManage extends com.yedam.common0805.DAO {
//	싱글톤 정의
	private static MemberManage mm = null;

//	생성자 추가 생성 막기
	private MemberManage() {
	}

	public static MemberManage getInstance() {
		if (mm == null) {
			mm = new MemberManage();
//		} else {
//			return mm;
		}
		return mm;
	}

//	로그인시 사용하는 쿼리문
	public MemberDTO Login(MemberDTO member) {
		MemberDTO mem = null;
		try {
			// 1.db
			conn();
//2.sql 쿼리문을 이용한 로그인 조회, 아래 문장 자체가 id pw입력햇을때 존재하면 리턴 = 계쩡 정보 존재 알 수 있음.
			String sql = "SELECT * FROM member WHERE member_id = ? AND member_pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mem = new MemberDTO();
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberPw(rs.getString("member_pw"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setMemberBelong(rs.getString("member_belong"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return mem;
	}

}
