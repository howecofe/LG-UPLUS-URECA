package ch02.sec09;

public class StringConcatExample {
	
	public static void main(String[] args) {
		// 숫자 연산
		int result1 = 10 + 2 + 8;
		System.out.println(result1);
		
		// 결합 연산
		String result2 = 10 + 2 + "8"; // 12 + "8" -> "12" + "8" -> "128"
		System.out.println(result2);
		
		String result3 = 10 + "2" + 8; // "102" + 8 -> "1028"
		System.out.println(result3);
		
		String result4 = "10" + 2 + 8;
		System.out.println(result4);
		
		String result5 = "10" + (2 + 8);
		System.out.println(result5);
	}
}

// 문자열과 다른 문자열, 숫자가 + 연산자로 계산되면 문자열로 간주되고 합쳐진다.