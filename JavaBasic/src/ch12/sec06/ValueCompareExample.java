package ch12.sec06;

public class ValueCompareExample {
	
	public static void main(String[] args) {
		Integer obj1 = 300;
		Integer obj2 = 300;
		
		// Wrapper 클래스의 객체는 primitive type value 비교를 위해서는 equals() 사용해야 한다.
		System.out.println(obj1 == obj2); // 주소 비교 false
		System.out.println(obj1.equals(obj2)); // 값 비교 true
		
		Integer obj3 = 100;
		Integer obj4 = 100;
		
		// 단, JVM이 작은 범위 (-128~127) 는 동일 객체로 관리한다.
		System.out.println(obj3 == obj4); // 주소 비교 true
		System.out.println(obj3.equals(obj4)); // 값 비교 true
	}
	
}
