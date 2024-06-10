package ch02.sec10;

public class PrimitiveAndStringConversionExample {
	
	// 문자열 -> int, int -> 문자열
	public static void main(String[] args) {
//		String str = "10z"; // 숫자로 변환하지 못하는 문자열인 경우 : java.lang.NumberFormatException 발생
		String str = "10";
		int value1 = Integer.parseInt(str); // String -> int
		System.out.println(value1);
		
		String str2 = String.valueOf(value1); // int -> String
		System.out.println(str2);
	}
}
