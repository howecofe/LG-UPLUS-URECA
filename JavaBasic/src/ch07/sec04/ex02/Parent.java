package ch07.sec04.ex02;

// 메서드 오버라이딩 규칙
public class Parent {
	public A m1() { return new A(); }
	public B m2() { return new B(); }
	
	public void m3() throws RuntimeException {}
}

// 규칙 1. 메서드 오버라이딩을 하면서 리턴 타입이 부모보다 상위 타입을 가지면 안 된다.
//class Child extends Parent {
//	@Override
//	public B m1() { return new B(); }
	// 리턴타입이 달라도 오버라이딩 가능하다.
	// why? A와 B는 상속 관계이므로 본질적으로 같다. 하위 타입으로 호환 가능하다.
	
//	@Override
//	public A m2() { return new A(); }
	// -> 에러 발생! 
	// why? 리턴 타입이 B보다 상위타입이기 떄문에.
//}

// 규칙 2. 메서드 오버라이딩을 하면서 접근제한자가 부모보다 좁아서는(강하면) 안 된다.
//class Child extends Parent {
//	@Override
//	B m2() { return new B(); } // public -> default (X)
//}


class Child extends Parent {
//	@Override
//	public void m3() throws RuntimeException {}
	
//	@Override
//	public void m3() throws Exception {} // 상위 예외라 에러 발생
	
	@Override
	public void m3() throws NullPointerException {} // 하위 예외라 OK
}

// 규칙 3. 메서드 오버라이딩을 하면서 부모보다 더 상위 예외를 throws 할 수 없다.
// Object > Throwable > Exception > RuntimeException > NullPointerException