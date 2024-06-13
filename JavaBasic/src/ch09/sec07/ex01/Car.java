package ch09.sec07.ex01;

// 익명 객체(동적 객체) - 익명 클래스
public class Car {
	// 필드
	private Tire tire1 = new Tire();
	
	// Tire 클래스의 익명 자식 객체 생성 <= 이 객체는 이곳에서만 쓰고 말 거다. 일회용!! 재사용 X
	private Tire tire2 = new Tire() {
		@Override
		public void roll() {
			System.out.println("익명 타이어가 굴러갑니다.");
		}
	};
	
	public void run() {
		tire1.roll();
		tire2.roll();
	}
}
