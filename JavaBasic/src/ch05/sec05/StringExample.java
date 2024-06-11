package ch05.sec05;

import java.util.Scanner;

public class StringExample {

	public static void main(String[] args) {
		// equals()
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		System.out.println(str1 == str2 );
		System.out.println(str1.equals(str2));
		
		// length()
		System.out.println(str1.length());
		
		// charAt()
		System.out.println(str2.charAt(2));
//		System.out.println(str2.charAt(5)); // java.lang.StringIndexOutOfBoundsException
		
//		Scanner sc = new Scanner(System.in);
//		String input = sc.nextLine();
//		
//		for (int i = 0; i < input.length(); i++) {
//			System.out.println(input.charAt(i));
//		}
		
		// replace()
		String str = "Hello, Java!!!";
		str2 = str.replace("ll", "LL"); // String은 불변이므로, str은 변하지 않는다.
		System.out.println(str);
		System.out.println(str2);
		
		// indexOf()
		// 없으면 -1 리턴
		str = "abcdefghijk";
		int idx = str.indexOf('c');
		System.out.println(idx);
		
		idx = str.indexOf("dexf");
		System.out.println(idx);
		
		if (idx == -1) {
			System.out.println("찾지 못했습니다.");
		}
		
		// 존재 유무 contains()
		boolean result = str.contains("dexf");
		System.out.println(result);
		
		if (str.contains("def")) {
		
		} else {
		
		}
		
	}
}
