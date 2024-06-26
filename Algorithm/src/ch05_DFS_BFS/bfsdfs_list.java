package ch05_DFS_BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// 인접 리스트를 이용한 DFS / BFS 구현
public class bfsdfs_list {

	// 정점 1,2,3,4
	// 연결 정보
	// 1 -> 2,4
	// 2 -> 3,4
	// 3 -> 2
	// 4 -> 3
	static List<List<Integer>> adjList = new ArrayList<>(); 
	static boolean[] visit; // 중복 방문 방지
	public static void main(String[] args) {
		// 자료구조
		for (int i = 0; i < 5; i++) { // 0 dummy List
			adjList.add(new ArrayList<Integer>()); // 0, 1, 2, 3, 4 ArrayList 객체가 만들어 진다.
		}

		adjList.get(1).add(2); // 1번 정점이 갈 수 있는 정점 2를 연결
		adjList.get(1).add(4);
		adjList.get(2).add(3);
		adjList.get(2).add(4);
		adjList.get(3).add(2);
		adjList.get(4).add(3);
		
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
			List<Integer> list = adjList.get(v);
			
			
			for (Integer i : list) {
				if (visit[i]) continue;
				
				// 정점 v와 인접한 정점을 큐에 넣고 방문 처리
				q.offer(i);
				visit[i] = true;
			}
		}
	}
	
//	 stack 대신 동일한 효과를 내고 더 편한 재귀 호출 이용
	static void dfs(int n) { // n : 시작 정점
		visit[n] = true; // 방문
		
		// 필요한 처리 수행
		System.out.print(n + " -> ");
		
		// 계속 방문을 이어 간다.
		List<Integer> list = adjList.get(n);
		
		
		for (Integer i : list) {
			if (visit[i]) continue;
			
			// 정점 n과 인접한 정점을 방문하기 위해 재귀 호출
			dfs(i);
		}
	}
}
