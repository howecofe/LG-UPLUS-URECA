package ch08.sec05;

// 전원 켜는 기능에 대한 약속, 규칙 공유
public interface RemoteControl {
	
	// public static final 생략 (상수)
	int MAX_VALUE = 10;
	int MIN_VALUE = 0;
	
	// public abstract 생략 (추상 메서드)
	void turnOn(); 
	void turnOff();
	void setVolume(int volume);
	
	// public 생략 (default 메서드: 구현부를 가진 메서드)
	// 인터페이스 default 메서드 : 접근 제한자의 default 와 다르다.
	default void setMute(boolean mute) {
		if (mute) {
			System.out.println("무음 처리");
			setVolume(MIN_VALUE); // default 메서드에서 위 추상 메서드 호출, 필드 사용
		} else {
			System.out.println("무음 해제");
		}
	}
}
