package ch11.sec02.ex01;

// 예외
public class ExceptionTest {

	public static void main(String[] args) {
		System.out.println("예외 테스트");
		printLength("java");
		
		String s = null;
		printLength(s); // java.lang.NullPointerException <= RuntimeException 계열 == non-checked Exception

	}
	
	public static void printLength(String data) {
		int result = data.length();
		System.out.println("문자 수: " + result);
	}

}
