package ch07.sec03;

public class SmartPhone extends Phone {
	// 부모 클래스에 없어서 추가로 생성
	private boolean wifi;
	private String color = "blue";
	
	public void internet() {
		System.out.println("인터넷에 연결합니다.");
		System.out.println(super.getModel());
		System.out.println(super.getColor());
		System.out.println(this.getModel());
		System.out.println(this.getColor());
	}
	
	public String getColor() {
		return color;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	
	public SmartPhone(boolean wifi) {
//		super(); // 자동 추가 by 컴파일러
		setWifi(wifi);
	}
	
	// 부모 클래스의 생성자를 만족하는 생성자도 만들어주는 것이 좋다.
	public SmartPhone(String model, String color, boolean wifi) {
		super(model, color); // 부모 클래스 생성자 호출은 무조건 첫번째줄!
		this.setWifi(wifi);
	}
}
