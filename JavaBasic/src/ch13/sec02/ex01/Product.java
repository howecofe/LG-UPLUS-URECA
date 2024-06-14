package ch13.sec02.ex01;

// generic class
public class Product <K, M> { // generic 타입 여러 개
	private K kind;
	private M model;
	
	// getter, setter
	public K getKind() {
		return this.kind;
	}
	
	public void setKind(K kind) {
		this.kind = kind;
	}
	
	public M getModel() {
		return this.model;
	}
	
	public void setModel(M model) {
		this.model = model;
	}
}
