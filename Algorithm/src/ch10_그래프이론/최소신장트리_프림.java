package ch10_그래프이론;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// MST - Prim 알고리즘
// 정점 중심 - 인접 리스트, 인접 행렬
// 시작점을 PQ에 넣고 시작
// PQ에 담긴 (고려하는) 정점 중 가장 비용이 적은 정점을 꺼내서, 갈 수 있는 새로운 정점을 다시 PQ에 넣고 이 과정을 반복한다.
// 비용이 가장 작은 정점 선택이 V개 선택

// 그래프 : 인접행렬 + 입력 테케(2차원 배열)
// PriorityQueue
// visit
public class 최소신장트리_프림 {
	
	static int V, result;
	static int[][] matrix;
	static boolean[] visit;
	static PriorityQueue<Vertex> pq = new PriorityQueue<>((v1, v2) -> v1.c - v2.c);
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		matrix = new int[V][V];
		visit = new boolean[V];
		
		// 인접 행렬 초기화
		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < V; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 풀이 : 프림 알고리즘
		// #1
//		pq.offer(new Vertex(0, 0)); // 0번 정점에서 비용 0으로 출발
//		int cnt = 0; // 정점의 개수이므로 V개
		
		// #2
		visit[0] = true;
		for (int i = 0; i < V; i++) {
			if (matrix[0][i] == 0) continue;
			pq.offer(new Vertex(i, matrix[0][i]));
		}
		int cnt = 1;
		
		while (!pq.isEmpty()) {
			Vertex vertex = pq.poll();
			if (visit[vertex.v]) continue;
			// MST를 구성하는 정점이 선택됨
			visit[vertex.v] = true;
			
			result += vertex.c;
			cnt++;
			if (cnt == V) break;
			
			// 꺼낸 정점으로부터 갈 수 있고 아직 방문하지 않은 정점이 있으면 pq에 추가
			for (int i = 0; i < V; i++) {
				if (matrix[vertex.v][i] == 0 || visit[i]) continue;
				
				pq.offer(new Vertex(i, matrix[vertex.v][i])); // 정점번호 i, 비용 vertex.v -> i (인접정점) <- 다익스트라는 시작정점으로부터의 비용
				// 다익스트라와 비슷하지만, 시작정점으로부터의 비용이 아닌 인접 정점으로부터의 비용을 고려하고, 최소 비용 갱신하는 부분이 없으므로 훨씬 단순
			}
		}
		System.out.println(result);
		
	}
	
	static class Vertex {
		int v, c;
		
		Vertex(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}
}
/*
5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0

==>10

------
7
0 29 0 0 75 0 0
29 0 35 0 0 34 0
0 35 0 7 0 0 0
0 0 7 0 0 23 13
75 0 0 0 0 53 0
0 34 0 23 53 0 25
0 0 0 13 0 25 0
==> 159
*/