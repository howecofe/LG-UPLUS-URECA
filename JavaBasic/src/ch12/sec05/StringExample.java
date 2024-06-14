package ch12.sec05;

import java.util.StringTokenizer;

public class StringExample {

	// String class
	public static void main(String[] args) {
		// 아래와 같은 String concat 작업 지양하기! <- 비효율적
		String result = "Hello" + "World" + "AAA";
		
		// 1. StringBuilder
//		StringBuilder sb = new StringBuilder("Hello");
		StringBuilder sb = new StringBuilder();
		
		// old style
		sb.append("Hello");
		sb.append("World");
		sb.append("AAA");
		
		// method chain pattern
		sb = new StringBuilder();
		sb.append("Hello")
			.append("World")
			.append("AAA");
		
		System.out.println(sb);
		
		// 반복문
		StringBuilder ans = new StringBuilder();
		
		for (int i = 0; i < 10; i++) {
			String str = " " + i;
			ans.append(str);
		}
		System.out.println(ans);
		
//		// 2. StringTokenizer
		String str = "홍길동,이길동,삼길동";
		StringTokenizer st = new StringTokenizer(str, ",");
		
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
		
		int N = 5;
		String input = "10 27 5 4 19";
//		String[] strArr = input.split(" "); // split()과 StringTokenizer 성능은 크게 차이 없다.
		StringTokenizer st2 = new StringTokenizer(input);
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st2.nextToken());
			System.out.println(num);
		}
	}
}
