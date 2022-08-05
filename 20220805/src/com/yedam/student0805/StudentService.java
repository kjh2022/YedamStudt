package com.yedam.student0805;

import java.util.Scanner;

public class StudentService {
	Scanner sc = new Scanner(System.in);

	// 1.학생 등록 메소드 만들기
	public void insertStudent(StudentDTO std) {
//	1.	int result = StudentManage.getInstance().insertStudent(std); 둘 중에 뭘써도 상관없음
//		return result;

//	2.	return StudentManage.getInstance().insertStudent(std);

		int result = StudentManage.getInstance().insertStudent(std);
		if (result == 1) {
			System.out.println("학생 정보 입력 완료");
		} else {
			System.out.println("학생 정보 입력 실패");
		}
	}

	public void insertSubject(StudentDTO std) {
		// 1.성적 입력 ㅡ> 1.국어 2.영어 3.수학
		int menu = 0;
		System.out.println("========성적 입력========");
		System.out.println("1.국어 | 2.영어 | 3.수학");
		menu = Integer.parseInt(sc.nextLine());

		System.out.println("점수입력> ");

		if (menu == 1) {
			int kor = Integer.parseInt(sc.nextLine());
			std.setStudentKor(kor);
			
			checkResult(StudentManage.getInstance().insertKor(std)); //변수를 사용하지 않고 결과값을 메소드로 넣은것

		} else if (menu == 2) {
			int eng = Integer.parseInt(sc.nextLine());
			std.setStudentEng(eng);
			
			int result = StudentManage.getInstance().insertEng(std);
			checkResult(result);
			
		} else if (menu == 3) {
			int math = Integer.parseInt(sc.nextLine());
			
			std.setStudentMath(math);
			checkResult(StudentManage.getInstance().insertMath(std));

		} else {
			System.out.println("잘못된 입력입니다. 1~3번 중에서 선택해 주세요.");
		}
	}

//	학생 정보 수정
	public void updateTel() {
		StudentDTO std = new StudentDTO();
		System.out.println("ID 입력> ");
		int id = Integer.parseInt(sc.nextLine());

		System.out.println("변경할 전화번호 입력");
		String tel = sc.nextLine();
		
		std.setStudentId(id);
		std.setStudentTel(tel);

		int result = StudentManage.getInstance().updateTel(std);
		checkResult(result);
	}
//	학생 정보 조회
	public StudentDTO getStudent(StudentDTO std) {

		return StudentManage.getInstance().getStudent(std.getStudentId());
		/*위 문장은StudentDTO std = StudentManage.getInstance().getStudent(id);
		 * 		return std; 두줄의 문장과 같은 의미*/
	}
	
	
	public void checkResult(int value) {
		if(value == 1) {
			System.out.println("완료");
		}else {
			System.out.println("실패");
		}
	}

}
