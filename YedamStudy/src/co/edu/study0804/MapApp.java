package co.edu.study0804;

import java.util.HashMap;
import java.util.Scanner;

//	필드
//	메소드
public class MapApp {

	HashMap<String, String> map = new HashMap<>();
	Scanner sc = new Scanner(System.in);
	String menuNo = "";

//	생성자
	public MapApp() {
		run();
	}

	private void run() {
//		menuNo에 99를 넣었을때
//		menuNO.equals("99") => true가 될 수 있도록.
		while (!menuNo.equals("99")) {
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("1.단어 등록 | 2.단어 전체 조회 | 3.단어 검색 | 4.단어 수정 | 5.단어 삭제 | 99.종료");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("입력> ");
			menuNo = sc.nextLine();

//			단어 등록
			if (menuNo.equals("1")) {
				String word = "";
				while (true) {
					System.out.println("단어를 입력하세요. 종료를 원하면 q를 입력해 주세요.");
					System.out.println("입력>");
					word = sc.nextLine();

					if (word.equals("q")) {
						System.out.println("단어 입력 종료");
						break;
					}
					System.out.println("뜻 입력> ");
					String mean = sc.nextLine();
					map.put(word, mean);
				}
			}
//			단어 전체 조회
			else if (menuNo.equals("2")) {
				if (map.size() == 0) {
					System.out.println("등록된 단어가 없습니다. 단어를 등록해 주세요.");
				} else {
					System.out.println("***단 어 장 ***");
					// 향상된for문을 이용하여 key를 가져오고
					// 가져온 key를 이용하여 value를 가져옴
					for (String key : map.keySet()) {
						String value = map.get(key);
						System.out.println("단어 : " + key + "\n뜻 : " + value + "\n");
					}
				}
			}
//			단어 검색
			else if (menuNo.equals("3")) {
				System.out.println("단어 입력>");
				String key = sc.nextLine();
//				containsKey Map에 key값이 있나없나 조회해주는것.
				if (map.containsKey(key)) {
					String value = map.get(key);
					System.out.println("단어 : " + key + "\n뜻 : " + value);
				} else {
					System.out.println("등록되지 않은 단어입니다.");
				}
			}
//			단어 수정
			else if (menuNo.equals("4")) {
				System.out.println("수정 할 단어 입력");
				String key = sc.nextLine();
				if (map.containsKey(key)) {
					System.out.println("수정할 뜻을 입력하세요>");
					String value = sc.nextLine();
					map.put(key, value);
				} else {
					System.out.println("등록되지 않은 단어입니다.");
				}
			}
//			단어 삭제
			else if (menuNo.equals("5")) {
				System.out.println("1.한 건 삭제 2.전체 삭제");
				System.out.println("입력>");
				String menu = sc.nextLine();
//				한건 삭제.
				if (menu.equals("1")) {
					System.out.println("삭제할 단어 입력>");
					String key = sc.nextLine();
					map.remove(key); // remove 메소드 활용
					if (!map.containsKey(key)) { // 키가 존재하지 않을때 삭제완료 메시ㅣ지
						System.out.println("삭제 완료");
					} else {
						System.out.println("삭제되지 않았습니다. 관리자에게 문의해 주세요");
					}
				}
//				전체 삭제
				else if (menu.equals("2")) {
					map.clear(); // 맵의 데이터를 전체 비우는 메소드
					if (map.size() == 0) {
						System.out.println("전체 삭제 완료");
					} else {
						System.out.println("삭제되지 않았습니다. 관리자에게 문의해 주세요");
					}
				}
			}
//			프로그램 종료
			else if (menuNo.equals("99")) {
				System.out.println("프로그램을 종료합니다.");
			}
		}
		sc.close();
	}
}
