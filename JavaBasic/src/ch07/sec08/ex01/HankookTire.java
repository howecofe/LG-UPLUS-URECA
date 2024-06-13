package ch07.sec08.ex01;

public class HankookTire extends Tire { // is-a 관계
	@Override
	public void roll() {
		System.out.println("HankookTire 회전합니다.");
	}
}
