package ch02.sec13;

import java.util.Scanner;

// compiler 가 자동으로 해주는 작업 
// #1. java.lang package 는 자동으로 import 해준다. (그 외는 import해서 사용해야 한다.)
// -> ex) String class는 import 하지 않아도 사용 가능하다.

public class ScannerExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // command + shift + o : 자동 import
		System.out.printf("정수 값 입력 : ");
		
		int input = sc.nextInt();
		System.out.println("입력 받은 값 : " + input);
	}
}