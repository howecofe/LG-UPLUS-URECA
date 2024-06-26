package ch05_DFS_BFS;

import java.util.Stack;

public class 스택1 {

	public static void main(String[] args) {
		// 정수를 stack 에 넣고 빼고 들여다 보고 ...
		Stack<Integer> s = new Stack<>();
		
		// push(), pop(), peek()
		s.push(5);
		s.push(2);
		s.push(3);
		s.push(7);
		s.pop(); // 7 제거
		s.push(1);
		s.push(4);
		s.pop(); // 4 제거
		
		// 5 - 2 - 3 - 7(x) - 1 - 4(x)
		while (!s.empty()) {
//			System.out.println(s.peek()); // 꺼내진 않는다.
			System.out.println(s.pop());
		}

	}

}
