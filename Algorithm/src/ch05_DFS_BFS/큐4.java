package ch05_DFS_BFS;

import java.util.Arrays;
import java.util.PriorityQueue;

// PriorityQueue (우선 순위 - 정렬된 결과를 추출, heap 구조) 연습
public class 큐4 {
	
	public static void main(String[] args) {
		{
			// Integer
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			pq.offer(3);
			pq.offer(2);
			pq.offer(7);
			pq.offer(5);
			pq.offer(9);
			
//			while (!pq.isEmpty()) {
//				System.out.println(pq.poll()); // 넣은 순서와 무관하게 작은 요소부터 나온다. (오름차순 정렬)
//			}
			
			// foreach 문 : 입력순 X, 정렬 X
			for (Integer i : pq) {
				System.out.println(i);
			}
		}
		
		System.out.println();
		
		{
			// String
			PriorityQueue<String> pq = new PriorityQueue<>();
			pq.offer("b3");
			pq.offer("a2");
			pq.offer("x7");
			pq.offer("d5");
			pq.offer("s9");
			
			while (!pq.isEmpty()) {
				System.out.println(pq.poll()); // 넣은 순서와 무관하게 작은 요소부터 나온다. (오름차순 정렬)
			}
		}
		
		System.out.println();
		
		{
			// user defined class + lambda
			// 정렬 조건 추가 3가지 : class 에 Comparable 구현, anonymous 객체, lambda를 생성자에 전달
			PriorityQueue<Node> pq2 = new PriorityQueue<>((o1, o2) -> o1.y == o2.y ? o1.x - o2.x : o1.y - o2.y);
			pq2.offer(new Node(3, 5, 2));
			pq2.offer(new Node(7, 1, 4));
			pq2.offer(new Node(5, 2, 9));
			pq2.offer(new Node(3, 1, 5));
			
			while (!pq2.isEmpty()) {
				System.out.println(pq2.poll());
			}
		}
		
		System.out.println();
		
		{
			// user defined class + lambda
			// 정렬 조건 추가 3가지 : class 에 Comparable 구현, anonymous 객체, lambda를 생성자에 전달
			PriorityQueue<int[]> pq2 = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
			pq2.offer(new int[] {3, 5, 2});
			pq2.offer(new int[] {7, 1, 4});
			pq2.offer(new int[] {5, 2, 9});
			pq2.offer(new int[] {3, 1, 5});
			
			while (!pq2.isEmpty()) {
				System.out.println(Arrays.toString(pq2.poll()));
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
	
//	static class Node implements Comparable<Node> {
//		int y, x, c;
//		
//		Node(int y, int x, int c) {
//			this.y = y;
//			this.x = x;
//			this.c = c;
//		}
//
//		@Override
//		public String toString() {
//			return "[y=" + y + ", x=" + x + ", c=" + c + "]";
//		}
//
//		@Override
//		public int compareTo(Node o) {
//			return this.y == o.y ? this.x - o.x : this.y - o.y;
//		}
//	}
	
}
