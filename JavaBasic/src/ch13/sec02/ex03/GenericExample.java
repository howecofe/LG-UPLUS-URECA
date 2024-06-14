package ch13.sec02.ex03;

public class GenericExample {

	public static void main(String[] args) {
		Box<String> box1 = new Box<>();
		box1.content = "100";
		
		Box<String> box2 = new Box<>();
		box2.content = "100";
		
		System.out.println(box1.compare(box2)); // true
		
		
		Box<Integer> box3 = new Box<>();
		box3.content = 100;
		
		Box<Integer> box4 = new Box<>();
		box4.content = 100;
		
		System.out.println(box3.compare(box4)); // true
		
		
		Box<MyClass> box5 = new Box<>();
		box5.content = new MyClass();
		box5.content.str = "즐거운 금요일";
		
		Box<MyClass> box6 = new Box<>();
		box6.content = new MyClass();
		box6.content.str = "즐거운 금요일";
		
		System.out.println(box5.compare(box6)); // true
		// MyClass에 equals() 오버라이딩하지 않으면 객체 주소 비교라 false 출력
	}

}
