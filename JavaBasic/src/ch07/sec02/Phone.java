package ch07.sec02;

public class Phone {
	// encapsulation 생각을 늘 합시다!!
	private String model;
	private String color;
	
	public void bell() {
		System.out.println("벨이 울립니다.");
	}
	
	public void sendVoice(String message) {
		System.out.println("본인 : " + message);
	}
	
	public void receiveVoice(String message) {
		System.out.println("상대방 : " + message);
	}
	
	public void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
// 상속
// is-a 관계, 본질적으로 같다.
// (필드 : has-a 관계, 기능적으로 의존 관계이다.)
// 컴파일러가 자동으로 해주는 기능
// : 상속 관계에 있는 자식 클래스의 생성자 안에서 부모 클래스의 생성자를 명시적으로 호출하지 않으면, 컴파일러가 super() 자동 추가
// 이로 인해 자식 객체 생성 시, heap 에 부모 객체가 먼저 생성된 다음에 자식 객체 생성 (객체 2개 존재 X, 1개의 객체이고 파트가 2개라고 이해하기)
// 자식 클래스에서 super()가 호출되기 때문에 부모 클래스 기본 생성자를 명시적으로 넣어주자! (guide)
// 부모 클래스의 생성자를 만족하는 자식 클래스 생성자도 만들어주는 것이 좋다.
// 부모 클래스 생성자 호출은 무조건 첫번째줄!

// Object 클래스
// 모든 클래스의 최상위 클래스는 Object
// 아무것도 상속받은 것이 없을 때는 최상위 클래스인 Object를 추가해준다.
// 모든 클래스는 Object 클래스를 상속받는다.
// 즉, Object 클래스로 모든 클래스를 받을 수 있다.
// class A extends Object {} 

// super. VS super()
// super. : 부모 클래스 객체 참조
// super() : 부모 클래스 생성자 호출