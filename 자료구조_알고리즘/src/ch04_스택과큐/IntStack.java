package ch04_스택과큐;

// 중요 키포인트!! : ptr은 항상 다음 빈 곳을 가리킨다.

public class IntStack {

	private int[] stk; // 스택 자료를 위한 배열
	private int capacity; // 스택의 크기(용량)
	private int ptr; // 스택 포인터
	
	// 생성자
	public IntStack(int maxLen) {
		ptr = 0; // empty한 곳 가리킨다.
		capacity = maxLen;
		
		// 지나치게 큰 용량에 대해서 OutOfMemoryError 처리
		try {
			stk = new int[capacity];
		} catch(OutOfMemoryError e) {
			capacity = 0;
		}
	}
	
	// push
	// 이미 용량이 찬 경우 예외 발생 (Overflow 예외)
	public int push(int x) {
		if (ptr >= capacity) { // stk 범위 : 0 ~ capacity - 1
			throw new OverflowIntStackException();
		}
		
//		stk[ptr] = x;
//		ptr++;
//		return x;
		return stk[ptr++] = x;
	}
	
	// pop
	// 용량이 비워져 있을 때 예외 발생
	public int pop() {
		if (ptr <= 0) {
			throw new EmptyIntStackException();
		}
		
		return stk[--ptr];
	}
	
	// peek
	public int peek() {
		if (ptr <= 0) {
			throw new EmptyIntStackException();
		}
		
		return stk[ptr - 1]; // 삭제하는 것이 아니므로 ptr 값이 바뀌면 안 된다. 
	}
	
	// clear : 초기화
	public void clear() {
		ptr = 0; // 초기화
	}
	
	// indexOf : 검색 + index
	public int indexOf(int x) {
		// 위(탑)부터 찾기 (스택은 위에서부터 index 시작이니까!)
		for (int i = ptr - 1; i >= 0; i--) {
			if (stk[i] == x) return i;
		}
		
		return -1;
	}
	
	// 용량
	public int getCapacity() {
		return capacity;
	}
	
	// 사이즈
	public int size() {
		return ptr; // 하나도 없을 때는 ptr == 0, 1개 들어 있을 때는 ptr 0에 넣고 1 증가. 
	}
	
	public boolean isEmpty() {
		return ptr <= 0; // ptr == 0
	}
	
	public boolean isFull() {
		return ptr >= capacity; // ptr == capacity
	}
	
	public void dump() {
		if (ptr <= 0) {
			System.out.println("스택이 비어 있습니다.");
			return;
		}
		
		for (int i = ptr - 1; i >= 0; i--) {
			System.out.println(stk[i] + " ");
		}
		System.out.println();
	}
	
	// 사용자 정의 예외
	// RuntimeException은 auto throws
	public class OverflowIntStackException extends RuntimeException { // RuntimeException 계열이므로 unchecked 예외
		public OverflowIntStackException() {}
	}
	
	public class EmptyIntStackException extends RuntimeException { // RuntimeException 계열이므로 unchecked 예외
		public EmptyIntStackException() {}
	}
	
}
