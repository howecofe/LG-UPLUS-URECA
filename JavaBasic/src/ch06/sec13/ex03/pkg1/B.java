package ch06.sec13.ex03.pkg1;

public class B {
	public void method() {
		A a = new A();
		
		a.field1 = 2; // public
		a.field2 = 3; // default
//		a.field3 = 4; // private
		
		a.method1(); // public
		a.method2(); // default
//		a.method3(); // private
	}
}
