package ch07.sec08.ex00;

public class Test {

	public static void main(String[] args) {
//		A a = new B(); // 타입의 다형성
//		a.m();
//		a.m2(); // 부모 클래스가 가진 메서드가 아니므로(자식 클래스에서 추가된 메서드이므로) 호출 불가능
		
//		A x = new D();
//		x.m();
		
		B x2 = new C();
		x2.m(10);
		// B에는 없지만 A에서 상속받은 메서드라 호출 가능. C에서 이를 오버라이딩했기 때문에 C에 재정의 메서드가 호출된다.
		// C의 메서드를 주석처리하면, A의 메서드 호출된다.
		
		A a = new A();
		B b = new B();
		C c = new C();
		D d = new D();
		
		
		// instanceof : 객체 타입 확인
//		System.out.println(b instanceof A); // true
//		System.out.println(b instanceof B); // true
//		System.out.println(b instanceof C); // false
//		System.out.println(b instanceof D); // false
		
//		A x = getInstance(); // new C();
//		System.out.println(x instanceof A); // true
//		System.out.println(x instanceof B); // true
//		System.out.println(x instanceof C); // true
//		System.out.println(x instanceof D); // false
		
		A x = getInstance();
		// A 객체이면 aa 하고... , B 객체이면 bb 하고...
		if (x instanceof D) { System.out.println("D 객체야!"); }
		else if (x instanceof C) {
			System.out.println("C 객체야!");
//			cObj.c(); // 형변환 전이므로 에러
			C cObj = (C) x; // instanceof 로 객체 타입 확인 후 강제형변환
			cObj.c();
		} else if (x instanceof B) System.out.println("B 객체야!");
		else if (x instanceof A) System.out.println("A 객체야!");
		else if (x instanceof Object) System.out.println("Object 객체야!");
	}
	
	public static A getInstance() { // 타입의 다형성! (리턴타입을 A로 받음)
		return new C(); // 실제 객체는 자식 클래스인 C
	}

}

// A <- B <- C <- D 상속
class A {
	public void m() { System.out.println("A m()"); }
	public void m(int n) { System.out.println("A m(int n)"); }
}

class B extends A {
	public void m() { System.out.println("B m()"); }
	public void m2() { System.out.println("B m2()"); }
}

class C extends B {
//	public void m(int n) { System.out.println("C m(int n)"); }
	public void c() { System.out.println("C c()"); }
}

class D extends C {
	public void m() { System.out.println("D m()"); }
}