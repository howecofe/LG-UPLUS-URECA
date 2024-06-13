package ch07.sec03;

public class SmartPhoneExample {

	public static void main(String[] args) {
		SmartPhone sPhone = new SmartPhone(true);
		System.out.println(sPhone.isWifi());
		
		SmartPhone sPhone2 = new SmartPhone("galaxy", "red", true);
		sPhone2.internet();
	}
}
