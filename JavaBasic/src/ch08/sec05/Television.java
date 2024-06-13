package ch08.sec05;

public class Television implements RemoteControl {
	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("tv를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("tv를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		if (volume > RemoteControl.MAX_VALUE) {
			this.volume = RemoteControl.MAX_VALUE;
		} else if (volume < RemoteControl.MIN_VALUE) {
			this.volume = RemoteControl.MIN_VALUE;
		} else {
			this.volume = volume;
		}
		
		System.out.println("현재 TV 볼륨은 " + this.volume);
	}
	
	// 인터페이스의 default 메서드 오버라이딩
	// -> 접근제한자의 범위가 좁아질 수 없으므로, 접근제한자는 public 으로 선언해야 한다!!
	@Override
	public void setMute(boolean mute) {
		if (mute) {
			System.out.println("재정의 TV 무음 처리");
			setVolume(MIN_VALUE); // default 메서드에서 위 추상 메서드 호출, 필드 사용
		} else {
			System.out.println("재정의 TV 무음 해제");
		}
	}
	
}
