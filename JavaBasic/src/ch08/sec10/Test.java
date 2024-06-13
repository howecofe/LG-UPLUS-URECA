package ch08.sec10;

// 강제 형변환, 다형성
public class Test {

	public static void main(String[] args) {
		// Impl : IFC의 구현 클래스
		IFB ifb = new Impl();
//		ifb.mc(); // IFB에 정의된 메서드가 아니라 호출 불가
		
		// 강제 형변환
		if (ifb instanceof IFC) { // 객체 타입 확인
			IFC ifc = (IFC) ifb;
			ifc.mc(); // 형변환 후 호출 가능
		}
		
		IFC ifc2 = new Impl();
		ifc2.mb();
		
		System.out.println("-----------");
		
		// 다형성
		IFC ifc3 = new SubImpl();
		ifc3.mb();
	}
}