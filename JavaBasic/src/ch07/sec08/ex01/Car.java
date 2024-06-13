package ch07.sec08.ex01;

public class Car {
	// 타입의 다형성 : 1) 필드 다형성
	public Tire tire; // has-a 관계, Tire, HankookTire, KumhoTire
	
	public void run() {
		tire.roll();
	}
}
