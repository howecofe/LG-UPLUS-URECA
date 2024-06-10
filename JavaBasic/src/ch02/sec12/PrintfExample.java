package ch02.sec12;

public class PrintfExample {

	public static void main(String[] args) {
		int value = 1234;
		int value2 = 2024;
		String str = "Hello";
		double pi = 3.141592;
		
		System.out.printf("상품의 가격은 %-10d원입니다. %d년에 만들어졌습니다. %s 문자열이예요.", value, value2, str);
		System.out.println();
		System.out.printf("현재 파이는 %10.5f", pi);
	}
}