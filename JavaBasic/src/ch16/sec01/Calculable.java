package ch16.sec01;

// 추상메서드가 1개인 인터페이스는 함수형 인터페이스!
@FunctionalInterface
public interface Calculable {
	// 추상 메서드 public abstract
	void calculate(int x, int y);
}
