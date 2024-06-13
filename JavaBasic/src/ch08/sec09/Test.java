package ch08.sec09;

// 다중 인터페이스 구현
public class Test {

	public static void main(String[] args) {
		IFC ifc = new Impl();
		ifc.ma();
		ifc.mb();
		ifc.ma();
		
		IFB ifb = new Impl();
//		ifb.ma();
		ifb.mb(); // IFB에 정의된 메서드만 호출 가능
//		ifb.mc();
		
	}
}