package ch05.sec03;

public class ReferenceTypeExample {
	
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 10;
		
		String str1 = new String("Hello"); // heap 1000번지
		String str2 = new String("Hello"); // heap 2000번지
		
		System.out.println(num1 == num2); // true
		System.out.println(str1 == str2); // false : 객체 주소 비교
		System.out.println(str1.equals(str2)); // true : 객체 값 비교
		
		// JVM 은 literal 을 최대한 재사용하려고 한다.
		// 문자열 literal 을 코드에서 처음 사용하면 재사용을 위해 별도의 공간에 저장
		String str3 = "Hello"; // new 생성자 x, literal 사용
		String str4 = "Hello"; // new 생성자 x, literal 사용
		System.out.println(str3 == str4); // true : 오잉 heap에 없나? (O)
	}
}

// String은 불변(Immutable). 한 번 만들어지면 재사용!