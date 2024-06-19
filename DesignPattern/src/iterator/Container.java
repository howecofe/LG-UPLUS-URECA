package iterator;

// 모든 자료구조는 Container 클래스 구현하도록 강제
public interface Container {
	// public abstract 추상 메서드
	Iterator getIterator();
}
