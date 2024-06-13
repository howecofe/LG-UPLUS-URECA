package ch07.sec10;

public class PhoneExample {

	public static void main(String[] args) {
//		Phone phone = new Phone("홍길동"); // 추상 클래스는 객체를 생성할 수 없다.
//		phone.turnOff();
//		System.out.println(phone.owner);
		
		SmartPhone sPhone = new SmartPhone("유관순");
		sPhone.turnOn();
		sPhone.internetSearch();
		sPhone.turnOff();
		System.out.println(sPhone.owner);
	}

}
