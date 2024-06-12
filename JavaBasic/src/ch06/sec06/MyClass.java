package ch06.sec06;

// compiler 가 자동으로 해주는 것!
// 1. java.lang 자동 import
// 2. class 에 생성자가 없으면 기본 생성자를 추가
// 	 -> 기본 생성자란? 파라미터가 없는 생성자

// heap 에 생성
public class MyClass {
	// field
	int n; // 선언만 <= 0에 준하는 default value
	int n2 = 10; // 선언 + 초기화
	String s;
	String s2 = new String("Hello");
	
	
	// constructor
	// 생성자 오버로딩 (이름은 동일하지만 파라미터가 다르다.)
	// 무분별한 생성자를 여러개 만드는 것은 지양
	// Pattern <= builder 패턴을 이용해서 필요하고 가독성이 높은 형태로 전환 필요
	public MyClass() {} // 기본 생성자
	
	public MyClass(int n) {
		this.n = n;
	}

	public MyClass(int n, int n2, String s, String s2) {
//		this.n = n;
		this(n); // 자신의 생성자 호출
		this.n2 = n2;
		this.s = s;
		this.s2 = s2;
		
//		this(n); // 생성자 내에서 다른 생성자를 호출할 때는 반드시 첫 번째로 호출되어야 한다.
	}
	// this 구분하기
	// this. <= this : heap 에 만들어진 instance 를 지칭, 자기 자신 객체
	// this() <= 자신의 생성자를 호출
	
	
	// method
	// 메소드 오버로딩
	// return 값이 없으면 void
	public void m1() {
		System.out.println(this.n + this.n2);
	}
	
	public void m1(String message) {
//		return; return 문 이후로는 실행 x, 메서드 종료
		if (message.equals("Quit")) return;
		
		System.out.println(message + this.s2);
	}
	
	public boolean m2() {
		return this.n > 4;
	}
	
}

// 다형성 2가지
// 1. type 다형성 : 1개의 type(부모)이 여러 개의 type(자식)을 받을 수 있다.
// 2. method 다형성 : 오버로딩, 오버라이딩(상속)
// -> 오버로딩 : 동일한 이름으로 다양한 메소드를 만들 수 있다.