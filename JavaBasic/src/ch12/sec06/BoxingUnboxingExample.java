package ch12.sec06;

public class BoxingUnboxingExample {
	
	// wrapper 클래스
	public static void main(String[] args) {
		// Boxing
		Integer obj = 100; // primitive -> wrapper
		System.out.println(obj);
		System.out.println(obj.intValue());
		
		// Unboxing
		int value = obj; // wrapper -> primitive
		System.out.println(value);
		
		// Unboxing auto
		int result = obj + 100;
		System.out.println(result);
	}
	
}
