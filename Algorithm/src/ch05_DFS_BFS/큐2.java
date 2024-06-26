package ch05_DFS_BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class 큐2 {
	
	public static void main(String[] args) {
		// offer(), poll(), peek()
		Queue<Integer> q = new ArrayDeque<>();
		
		q.offer(5);
		q.offer(2);
		q.offer(3);
		q.offer(7);
		q.poll();
		q.offer(1);
		q.offer(4);
		q.poll();
		
		// 5(x) - 2(x) - 3 - 7 - 1 - 4
		while(!q.isEmpty()) {
//			System.out.println(q.peek());
//			q.poll();
			System.out.println(q.poll());
		}
	}
	
}
