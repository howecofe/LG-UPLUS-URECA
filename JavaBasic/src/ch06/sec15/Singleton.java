package ch06.sec15;

public class Singleton {
	private static Singleton instance = new Singleton();
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		return instance; // static 이라 사용 가능
	}

}

//싱글톤 패턴
//객체가 1개만 만들어지도록 제한하는 패턴
//private 생성자 -> private static 객체 생성 -> public static getInstance()
//-> private 생성자로 제한해서 외부에서 객체를 생성하지 못하도록 막고, 클래스 로드될때 만들어진 static 객체만 호출하도록 한다.