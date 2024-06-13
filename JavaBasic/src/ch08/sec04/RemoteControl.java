package ch08.sec04;

// 전원 켜는 기능에 대한 약속, 규칙 공유
public interface RemoteControl {
	
	// public static final 생략 (상수)
	int MAX_VALUE = 10;
	int MIN_VALUE = 0;
	
	// public abstract 생략 (추상 메서드)
	void turnOn(); 
	void turnOff();
	void setVolume(int volume);
}
