package ch09.sec07.ex02;

public class Test {

	public static void main(String[] args) {
		Home home = new Home();
		home.use();
		
		System.out.println("-------------------");
		
		// 익명 객체 파라미터
		// 메서드 호출 완료 시점에 익명 객체 파라미터는 garbage 가 된다.
		// 클래스에 정의된 익명 객체보다 라이프사이클이 짧아, 일회성의 성격이 더 짙다.
		home.use2(new RemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("익명 인터페이스 파라미터 turnOn");
			}
		});

	}

}
