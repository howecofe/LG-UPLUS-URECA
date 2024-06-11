package ch05.sec06;

import java.util.Scanner;

public class ArrayExample3 {
	
	// 배열 + 반복문(for)
	public static void main(String[] args) {
		// 사용자의 입력을 받은 문자열을 char 배열로 저장
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();	
		
//		char[] charArr = new char[input.length()];
//	
//		for (int i = 0; i < input.length(); i++) {
//			charArr[i] = input.charAt(i);
//		}
		
		char[] charArr = input.toCharArray();
		
		for (char c : charArr) {
			System.out.print(c);
		}
	}

}