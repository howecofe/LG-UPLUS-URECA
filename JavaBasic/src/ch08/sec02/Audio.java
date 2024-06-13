package ch08.sec02;

public class Audio implements RemoteControl {
//	public void turnOnAudio() {
//		System.out.println("audio를 켭니다.");
//	}

	@Override
	public void turnOn() {
		System.out.println("audio를 켭니다.");
	}

	public void m() {}
}
