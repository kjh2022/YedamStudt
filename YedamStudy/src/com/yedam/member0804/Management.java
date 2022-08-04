package com.yedam.member0804;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common0804.DAO;

public class Management extends DAO {


	public Management() {
//		전체 조회
		showInfo();
//		한건 조회
		getMember();
//		한 건 입력 insert
		insertInfo();
//		수정
		updateInfo();
//		삭제
		deleteInfo();
	}
	
//	삭제
	private void deleteInfo(){
		int result = 0;
		try {
			conn();
			String sql = "delete member where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "A");
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		if(result == 1) {
			System.out.println(result + "건이 삭제되었습니다.");
		}else {
			System.out.println("삭제되지 않았습니다.");
		}
	}
	
//	수정
	private void updateInfo() {
		int result = 0;
		try {
			//1.DB연결
			conn();
			//2.query작성
			String sql = "update member set pw = ? where id = ?";
			//3.창구 및 쿼리 생성
			pstmt = conn.prepareStatement(sql);
			//4.데이터 입력
			pstmt.setString(1, "4321");
			pstmt.setString(2, "A");
			//5.실행
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		if(result == 1) {
			System.out.println(result + "건이 수정되었습니다.");
		}else {
			System.out.println("수정되지 않았습니다.");
		}
	}

//	한 건 입력
	private void insertInfo() {
		int result = 0;
		try {
			// 1.db연결
			conn();
			// 2query
			String sql = "insert into member values (?,?,?)";
			// 3.창구 생성
			pstmt = conn.prepareStatement(sql);
			// 4.query 데이터 입력
			pstmt.setString(1, "G");
			pstmt.setString(2, "1234");
			pstmt.setString(3, "고담");
//			DML (insertm updatem delete) ㅡ> executeUpdate()만 사용
//			Select ㅡ> executeQuery()만 써야함
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		if (result == 1) {
			System.out.println("정상 입력 되었습니다.");
		} else {
			System.out.println("입력실패");
		}
	}
//	한 건 조회 메소드
	private void getMember() {
		Member member = null;
		try {
			// 1.conn(); 메소드로 DB연결
			conn();

			// 2.query문 작성
			String sql = "select * from member where id = ?";

			// 3.실행, 연결된(java~DB) DB에 쿼리문을 보낼 수 있는 창구 생성
//			창구를 만듦과 동시에 데이터를 바로 전송함
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "A");
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
		System.out.println(member.toString());
	}

//	전체 조회
//	member에 대한 정보 여러건을 받아오기
	private void showInfo() {
		List<Member> list = new ArrayList<>();
		Member mem = null;

		try {
//			1.conn(); 메소드로 DB연결 
			conn();

//			2.query문 작성
			String sql = "select * from member";

//			3.연결된(java~DB) DB에 쿼리문을 보낼 수 있는 창구 생성
			stmt = conn.createStatement();

//			4.3번에서 만든 창구로 쿼리문 전송
//			ResultSet(rs) select조회할때만 사용
//			한건~여러건 데이터 양만큼 조회됨
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				mem = new Member();
				mem.setId(rs.getString("id"));
				mem.setName(rs.getString("name"));
				mem.setPw(rs.getString("pw"));
				list.add(mem);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// try / catch문 성공 유무와 상관없이 뒤의 문장을 무조건 실행하게 만듦
			disconnect();
		}
		for (Member member : list) {
			System.out.println(member.toString());
		}
	}
}
