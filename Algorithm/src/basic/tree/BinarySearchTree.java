package basic.tree;

import java.util.ArrayDeque;
import java.util.Queue;

// 1차원 배열로 2진 트리 표현
/*
                1
           2          3
        4    5     6     7
      8  9 10 11 12 13 14 15
*/
// 1차원 배열로 이루어진 이진트리를 bfs(), dfs() 로 탐색해 본다.
// 2진트리 구조에서 부모 -> 자식을 찾아갈 때 : 왼쪽 자식은 부모*2, 오른쪽 자식은 부모*2+1 <= index 기준
// 자식 -> 부모를 찾아갈 때 : 자식(왼, 오 포함) / 2 (몫)
public class BinarySearchTree {
	static int[] tree = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		bfs(1);
		System.out.println(sb);
		
		sb.setLength(0); // sb 비우기(초기화)
		
		dfs(1);
		System.out.println(sb);
	}
	
	static void bfs(int idx) {
		Queue<Integer> q = new ArrayDeque();
		
		q.offer(idx);
		
		while (!q.isEmpty()) {
			int curIdx = q.poll();
			
			// 탐색 순서 출력
			sb.append(tree[curIdx]).append(" ");
			
			int lcIdx = curIdx * 2;
			int rcIdx = curIdx * 2 + 1;
			
			if (lcIdx < tree.length) q.offer(lcIdx);
			if (rcIdx < tree.length) q.offer(rcIdx);
		}
	}
	
	static void dfs(int idx) {
		// 기저 조건
		if (idx >= tree.length) return;
		
		// 탐색 순서 출력
		sb.append(tree[idx]).append(" ");
		
		dfs(idx * 2); // 왼쪽 노드
		dfs(idx * 2 + 1); // 오른쪽 노드
	}
}
