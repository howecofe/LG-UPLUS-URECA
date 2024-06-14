package ch12.sec03.ex01;

public class MemberExample {

	public static void main(String[] args) {
		Member obj1 = new Member("blue");
		Member obj2 = new Member("blue");
		Member obj3 = new Member("red");
		
		// println(객체) -> 객체.toString() 호출
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);
		
		System.out.println("----------------");
		
		// == : 객체의 참조(주소, 번지) 값 비교
		System.out.println(obj1 == obj2); // false
		System.out.println(obj2 == obj3); // false
		
		System.out.println("----------------");
		
		// * blue 에 대한 equals() 비교
		
		// 1. before 오버라이딩
		// equals() : Object 의 equals() 상속 (객체의 참조값 비교)
		// Object 의 equals() 는 == 사용
		System.out.println(obj1.equals(obj2)); // false
		
		// 2. after 오버라이딩
		// equals() : id 값 비교
		System.out.println(obj1.equals(obj2)); // true
		
		
	}

}
