package ch07.sec02;

public class SmartPhoneExample {

	public static void main(String[] args) {
		// 부모 객체
		Phone phone = new Phone();
		phone.setModel("galaxy");
		System.out.println(phone.getModel());
		
		// 자식 객체
		SmartPhone sPhone = new SmartPhone();
		sPhone.setModel("galaxy");
		System.out.println(sPhone.getModel());
		
		// 부모 클래스로부터 상속받은 메서드
		sPhone.bell();
		sPhone.receiveVoice("Hello...");
		
		// 자식 클래스에서 새로 추가된 메서드
		sPhone.setWifi(true);
		System.out.println(sPhone.isWifi());
		sPhone.internet();
		
	}
}
