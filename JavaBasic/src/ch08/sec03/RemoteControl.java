package ch08.sec03;

// 전원 켜는 기능에 대한 약속, 규칙 공유
public interface RemoteControl {
	int MAX_VALUE = 10; // public static final 생략 (상수)
	int MIN_VALUE = 0;
	
	void turnOn(); // public abstract 생략 (추상 메서드)
}
