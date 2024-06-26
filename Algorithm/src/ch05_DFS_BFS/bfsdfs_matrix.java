package ch05_DFS_BFS;

import java.util.ArrayDeque;
import java.util.Queue;

// 인접 행렬을 이용한 DFS / BFS 구현
public class bfsdfs_matrix {

	// 정점 1,2,3,4
	// 연결 정보
	// 1 -> 2,4
	// 2 -> 3,4
	// 3 -> 2
	// 4 -> 3
	static boolean[][] matrix;
	static boolean[] visit; // 중복 방문 방지
	public static void main(String[] args) {
		// 자료구조
		matrix = new boolean[5][5]; // 0 dummy
		matrix[1][2] = true;
		matrix[1][4] = true;
		matrix[2][3] = true;
		matrix[2][4] = true;
		matrix[3][2] = true;
		matrix[4][3] = true;

		visit = new boolean[5]; // 0 dummy
		
//		bfs(1);
		dfs(1);
	}
	
	static void bfs(int n) { // n : 시작 정점
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(n); // 시작 정점 넣고
		visit[n] = true; // 방문 처리
		
		while (!q.isEmpty()) {
			// 정점을 꺼낸다.
			int v = q.poll();
			
			// 필요한 처리 수행
			System.out.print(v + " -> ");
			
			// 계속 방문을 이어 간다.
			for (int i = 1; i <= 4; i++) {
				if (!matrix[v][i] || visit[i]) continue;
				
				// 정점 v와 인접한 정점을 큐에 넣고 방문 처리
				q.offer(i);
				visit[i] = true;
			}
		}
	}
	
	// stack 대신 동일한 효과를 내고 더 편한 재귀 호출 이용
	static void dfs(int n) { // n : 시작 정점
		visit[n] = true; // 방문
		
		// 필요한 처리 수행
		System.out.print(n + " -> ");
		
		// 계속 방문을 이어 간다.
		for (int i = 1; i <= 4; i++) {
			if (!matrix[n][i] || visit[i]) continue;
			
			// 정점 n과 인접한 정점을 방문하기 위해 재귀 호출
			dfs(i);
		}
	}
}
