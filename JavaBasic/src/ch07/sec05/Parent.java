package ch07.sec05;

// final method : 오버라이딩 불가
public class Parent {
	public void m1() {}
	public final void m2() {} // final method
	
	protected void m3() {} // protected
	void m4() {} // default
	private void m5() {} // private
}
