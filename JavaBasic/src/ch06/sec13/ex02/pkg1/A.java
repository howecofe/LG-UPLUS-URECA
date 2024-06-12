package ch06.sec13.ex02.pkg1;

// 접근 제한자 : 생성자
public class A {
	A a1 = new A(true);
	A a2 = new A(1);
	A a3 = new A("문자열");
	
	public A(boolean b) {} // public 생성자 
	A(int b) {} // default 생성자 
	private A(String s) {} // private 생성자 
}
