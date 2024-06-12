package ch06.sec06;

public class ABCTest {

	public static void main(String[] args) {
		C c = new C();
		B b = new B();
		A a = new A();
		
		System.out.println(a.b); // heap memory 상의 참조값
		System.out.println(a.b.c); // A has a B has a C -> has 관계
	}

}