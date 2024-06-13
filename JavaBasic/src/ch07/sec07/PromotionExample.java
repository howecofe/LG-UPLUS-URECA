package ch07.sec07;

// 자동 타입 변환 <- 타입의 다형성!
public class PromotionExample {
	
	public static void main(String[] args) {
		B b = new B();
		B b2 = new C();
		B b3 = new D();
		
//		B b4 = new A(); 자식 클래스 타입으로 부모 클래스를 받을 수 없다.
		C c = new D();
		Object o = new A();
		
	}

}
// 아무것도 상속받은 것이 없을 때는 최상위 클래스인 Object를 추가해준다.
// 모든 클래스는 Object 클래스를 상속받는다.
// 즉, Object 타입으로 모든 클래스를 받을 수 있다.
// class A extends Object {} 
class A {} 
class B extends A {}
class C extends B {}
class D extends C {}

// A - B - C - D