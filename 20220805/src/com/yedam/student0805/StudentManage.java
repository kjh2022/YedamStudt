package com.yedam.student0805;


public class StudentManage extends com.yedam.common0805.DAO {
//	싱글톤 만들기
	private static StudentManage SM = new StudentManage();

	private StudentManage() {
	}

	public static StudentManage getInstance() {
		return SM;
	}

//	학생 등록
	public int insertStudent(StudentDTO stu) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO student (student_id, student_name, student_class, student_addr, student_tel)\r\n"
					+ "VALUES (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stu.getStudentId());
			pstmt.setString(2, stu.getStudentName());
			pstmt.setString(3, stu.getStudentClass());
			pstmt.setString(4, stu.getStudentAddr());
			pstmt.setString(5, stu.getStudentTel());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

//	성적 입력
//	국어
	public int insertKor(StudentDTO stu) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE student SET student_kor = ? WHERE student_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stu.getStudentKor());
			pstmt.setInt(2, stu.getStudentId());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

//	영어 성적
	public int insertEng(StudentDTO stu) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE student SET student_eng = ? WHERE student_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stu.getStudentEng());
			pstmt.setInt(2, stu.getStudentId());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

//	수학 점수
	public int insertMath(StudentDTO stu) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE student SET student_math = ? WHERE student_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stu.getStudentMath());
			pstmt.setInt(2, stu.getStudentId());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

//	학생 정보 변경
//	전화번호 변경
	public int updateTel(StudentDTO stu) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE student SET student_tel = ? WHERE student_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu.getStudentTel());
			pstmt.setInt(2, stu.getStudentId());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

//	학생 정보 조회
	public StudentDTO getStudent(int id) {
		StudentDTO std = null;
		try {
			conn();
			String sql = "SELECT * FROM student WHERE student_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				std = new StudentDTO();
				std.setStudentId(rs.getInt("student_id"));
				std.setStudentName(rs.getString("student_name"));
				std.setStudentTel(rs.getString("student_tel"));
				std.setStudentAddr(rs.getString("student_addr"));
				std.setStudentClass(rs.getString("student_class"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return std;
	}
}
