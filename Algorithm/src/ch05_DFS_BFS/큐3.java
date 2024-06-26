package ch05_DFS_BFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

// Queue 연습
public class 큐3 {
	
	public static void main(String[] args) {
		{
			// user defined class
			Queue<Node> q = new ArrayDeque<>();
			q.offer(new Node(3, 0, 1));
			q.offer(new Node(1, 2, 3));
			q.offer(new Node(7, 4, -3));
			q.offer(new Node(6, 5, 7));
			
			while (!q.isEmpty()) {
				System.out.println(q.poll());
			}
		}
		
		{
			// user defined class
			Queue<int[]> q = new ArrayDeque<>();
			q.offer(new int[]{3, 0, 1});
			q.offer(new int[]{1, 2, 3});
			q.offer(new int[]{7, 4, -3});
			q.offer(new int[]{6, 5, 7});
			
			while (!q.isEmpty()) {
				System.out.println(Arrays.toString(q.poll())); // 1차원 배열 출력
			}
		}
	}
	
	static class Node {
		int y, x, c;
		
		Node(int y, int x, int c) {
			this.y = y;
			this.x = x;
			this.c = c;
		}

		@Override
		public String toString() {
			return "[y=" + y + ", x=" + x + ", c=" + c + "]";
		}
	}
	
}
