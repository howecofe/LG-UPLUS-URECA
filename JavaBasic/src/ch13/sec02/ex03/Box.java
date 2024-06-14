package ch13.sec02.ex03;

// 지네릭 객체의 비교
public class Box<T> {
	public T content;
	
	// 두 Box 객체의 비교를 위한 메서드
	// equals()로 내용 비교
	public boolean compare(Box<T> other) {
		return this.content.equals(other.content);
	}
}
