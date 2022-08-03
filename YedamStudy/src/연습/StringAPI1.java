package 연습;

import java.util.Scanner;

public class StringAPI1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String num  = scan.nextLine();
		String yearStr = num.substring(0, 2);
		int yearInt = 0;
		
		if (num.indexOf(0) == 0) {
			yearInt = num.indexOf(1);
		}else {
			yearInt = Integer.parseInt(yearStr);
		}
		int age;
		if (23 <= yearInt && yearInt <= 99) {
			age = 100 - yearInt + 22 + 1;
		}
		
	}

}
