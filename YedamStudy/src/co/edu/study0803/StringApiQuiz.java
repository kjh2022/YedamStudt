package co.edu.study0803;

import java.util.Scanner;

public class StringApiQuiz {
//	주민등록번호 6자리 - 7자리 를 스캐너로 받았을 때 나이와 성별 구하기
//			ex)991212 - 1924~2073~~살 남, 981212-1578987, 010228 - 275475~~살. 여, 0000815- 38574 ~~살, 남
//	올해 기준으로 100년의 값이 넘어간 경우 제외,220509  5월 9일 x 2022년 5월 9일 ㅇㅋ
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String num = sc.nextLine();
		String yearStr = num.substring(0, 2);
		int yearInt = 0;

		if (num.indexOf(0) == 0) {
			yearInt = num.indexOf(1);
		} else {
			yearInt = Integer.parseInt(yearStr);
		}

		int age;
		if (23 <= yearInt && yearInt <= 99) {
			age = 100 - yearInt + 22 + 1;
		} else {
			age = 22 - yearInt + 1;
		}

		System.out.println("나이 결과");
		System.out.println("입력한 생년월일: " + num.substring(0, 6) + " 나이: " + age);

	}
}
