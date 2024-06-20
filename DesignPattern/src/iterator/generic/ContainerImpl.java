package iterator.generic;

// iterator pattern : iterator 를 통해 순회 탐색
// String 자료구조 클래스
public class ContainerImpl<T> implements Container<T> {
	
	private T[] array;
	
	public void setArray(T[] array) {
		this.array = array;
	}

	@Override
	public Iterator<T> getIterator() {
		// Iterator interface 를 구현한 객체를 return
		return new IteratorImpl();
	}
	
	private class IteratorImpl implements Iterator<T> {
		int index; // default 0, 현재 위치

		@Override
		public boolean hasNext() {
			if (index < array.length) return true;
			
			return false;
		}

		@Override
		public T next() {
			if (this.hasNext()) return array[index++];
			
			return null;
		}
		
	}

}
