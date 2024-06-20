package iterator.generic;

// 모든 자료구조는 Container 클래스 구현하도록 강제
public interface Container<T> {
	// public abstract 추상 메서드
	Iterator<T> getIterator();
}
