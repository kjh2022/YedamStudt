package co.edu.study0803;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringAPI2 {
	public static void main(String[] args) {
		// 1.단어 입력 2.대소문자 변환 3.단어 총 길이 4.단어 자르기 5.단어 자르기 2
		Scanner scan = new Scanner(System.in);
		int MenuNo = 0;
		List<String> list = new ArrayList<>();

		while (MenuNo != 99) {
			System.out.println("기능을 선택해주세요.");
			System.out.println("1.단어 입력 2.대, 소문자 변환 3.단어 길이 4.단어 자르기 5.단어 자르기(2) 99.프로그램 종료");
			System.out.println("입력>");
//		nextLine = String + CRLF 캐리지 리턴 라인피드?(= Enter)
//		Enter기준으로 인식
//		nextInt() => 5 + Enter ->오류나게되서 integer.parseint(~를 많이 쓴다
			MenuNo = Integer.parseInt(scan.nextLine());

			switch (MenuNo) {
			case 1:
				while (true) {
					System.out.println("단어를 입력하세요. 종료를 원하면 q를 입력하세요");
					String word = scan.nextLine();
					if (word.equals("q")) {
						break;
					}
					list.add(word);
				}
				for (String str : list) {
					System.out.println(str + " ");
				}
				break;
			case 2:
				if (list == null || list.size() == 0) {
					System.out.println("단어를 먼저 등록해 주세요.");
					return;
				}
				System.out.println("1.대문자 2.소문자");
				int menu = Integer.parseInt(scan.nextLine());
				if (menu == 1) {
					for (String str : list) {
						System.out.println(str.toUpperCase() + " ");
					}
				} else if (menu == 2) {
					for (String str : list) {
						System.out.println(str.toLowerCase() + " ");
					}
				}
				break;
			case 3:
				StringBuilder sb = new StringBuilder();

				for (int i = 0; i < list.size(); i++) {
					sb.append(list.get(i));
				}
				System.out.println("입력한 문자의 총 길이 : " + sb.length() + "입니다.");
				break;
			case 4:
				System.out.println("자르고 싶은 단어의 인덱스를 입력하세요.");
				int i = 0;
				for (String str : list) {
					System.out.println(i + "번째 단어 : " + str);
					i++;
				}
				
				System.out.println("입력> ");
				int idx = Integer.parseInt(scan.nextLine());
				
				String word = list.get(idx);
//				단어의 가운데부터 끝까지 자르기를 하기위한 문장 만들기 
				/*(Math.round(word.length()/2))
				 * 1. word.length() / 2 = 문자 총 길이중 절반(가운데)
				 * 2.Math.round = 소수점을 없애기 위해서 반올림
				 * 3. word.substring(단어의 한 가운데 인덱스) ㅡ> 단어의 가운데부터 끝까지
				 * */
				System.out.println(word.substring(Math.round(word.length()/2)));
				break;
			case 5:
				System.out.println("단어 입력>");
				String str =scan.nextLine();
				System.out.println("입력하신 단어: " + str);
				System.out.println("자르고 싶은 구분자 입력.");
				String splits = scan.nextLine();
				String[]token = str.split(splits);
				for(String str2  : token) {
					System.out.println(str2);
				}
//				split() 안에 들어가는 문자를 기준으로 잘라냄 /, 공백, * 등
				break;
			case 99:
				System.out.println("프로그램 종료.");
				break;
			}
		}
		scan.close();
	}
}
