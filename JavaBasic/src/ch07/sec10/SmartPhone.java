package ch07.sec10;

public class SmartPhone extends Phone {
	
	SmartPhone(String owner) {
		super(owner);
	}
	
	void internetSearch() {
		System.out.println("internet search");
	}

	// 추상메서드 구현
	@Override
	void turnOn() {
		System.out.println("SmartPhone turn on");
	}
}
