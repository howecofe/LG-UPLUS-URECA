package ch06.sec13.ex02.pkg1;

public class B {
	
	A a1 = new A(true); // public 생성자
	A a2 = new A(1); // default 생성자 (같은 패키지라 접근 가능)
//	A a3 = new A("문자열"); // private 생성자 (다른 클래스 객체라 접근 불가)

}
