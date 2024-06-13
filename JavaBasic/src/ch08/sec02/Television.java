package ch08.sec02;

public class Television implements RemoteControl {
//	public void turnOnTv() {
//		System.out.println("tv를 켭니다.");
//	}
	
	@Override
	public void turnOn() {
		System.out.println("tv를 켭니다.");
	}
	
	public void m() {}
}
