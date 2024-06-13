package ch07.sec03;

public class Phone {
	// encapsulation 생각을 늘 합시다!! -> 필드는 private & getter, setter
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
	
	// guide: 자식 클래스에서 super() 호출되기 때문에 기본 생성자를 반드시 넣어주자!
	// 결론: 상속받을 가능성이 있으므로 기본 생성자는 항상 추가해주자.
	public Phone() {}
	
	public Phone(String model, String color) {
		this.setModel(model);
		this.setColor(color);
	}
	
}