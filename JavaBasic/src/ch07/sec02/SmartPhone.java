package ch07.sec02;

public class SmartPhone extends Phone {
	// 부모 클래스에 없어서 추가로 생성
	private boolean wifi;
	
	public void internet() {
		System.out.println("인터넷에 연결합니다.");
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	
	// 생성자가 없으므로 컴파일러가 [기본 생성자 + 부모 생성자 호출 코드] 자동으로 추가
//	public SmartPhone() {
//		super();
//	}
}
