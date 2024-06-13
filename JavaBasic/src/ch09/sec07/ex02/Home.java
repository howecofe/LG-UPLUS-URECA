package ch09.sec07.ex02;

// 익명 객체(동적 객체) - 익명 인터페이스
public class Home {
	// RemoteControl 인터페이스 객체의 익명 구현 객체
	private RemoteControl rc = new RemoteControl() {
		@Override
		public void turnOn() {
			System.out.println("익명 인터페이스 turnOn");
		}
	};
	
	public void use() {
		rc.turnOn();
	}
	
	public void use2(RemoteControl rc) {
		rc.turnOn();
	}
}
