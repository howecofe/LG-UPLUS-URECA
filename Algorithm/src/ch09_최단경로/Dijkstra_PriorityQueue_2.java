package ch09_최단경로;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 그래프 자료구조 (인접행렬, 인접리스트)
// 비용관리 배열 (시작점으로부터 각 정점까지의 최소비용(최단거리))
// 최소비용으로 고려했던(방문했던) 정점 관리 visit
// PriorityQueue에 담을 Vertex(Node) 클래스 (정점 번호, 시작점으로부터의 비용)
public class Dijkstra_PriorityQueue_2 {
	
	static class Node {
		int v; // 정점 번호
		// 인접 리스트에 Node 를 사용할 경우 : 인접리스트 정점 ~> v 정점까지의 비용(거리)
		// PriorityQueue 에 Node 를 사용할 경우 : 시작정점으로부터의 최소비용(거리)
		int c; 
		
		Node(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}
	
	static int V, E, start, end;
	static List<List<Node>> adjList = new ArrayList<>();
	static int[] cost; // 시작점으로부터 각 정점까지의 최소비용
	static boolean[] visit;
	static final int INF = Integer.MAX_VALUE; // cost 배열 초기화용
	static PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.c - n2.c);
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		start = 0;
		end = V - 1;
		
		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}
		cost = new int[V];
		visit = new boolean[V];
		
		// 입력 E개 -> 인접리스트 구성
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adjList.get(v1).add(new Node(v2, c));
		}
		
		// 비용 테이블 충분히 큰 값으로 초기화
		Arrays.fill(cost, INF);
		
		// 다익스트라
		cost[start] = 0;
		pq.offer(new Node(start, 0)); // 시작 정점을 pq에 넣고 다익스트라 진행
		
		while (!pq.isEmpty()) { // 전체를 모두 끝내면 모든 정점에 대한 최단경로(최소비용)가 완성
			Node node = pq.poll(); // 우선순위 큐이기 때문에 최소비용인 정점이 꺼내진다.
			
			// 방문 여부 확인
			if (visit[node.v]) continue; // 이미 방문한 정점 skip
			visit[node.v] = true; // 방문하지 않았다면 방문 처리
			
			// 모든 정점이 아니라 목표하는 정점만 따질 경우
			if (node.v == end) break; // 모든 정점 고려할 경우 주석 처리
			
			for (Node n : adjList.get(node.v)) {
				if (visit[n.v]) continue;
				
				cost[n.v] = Math.min(cost[n.v], node.c + n.c); // 최소 비용 갱신 (n.v)
				pq.offer(new Node(n.v, cost[n.v])); // pq에 넣기
				
			}
		}
		
		bw.write(cost[end] + "");
		
		br.close();
		bw.flush();
		bw.close();
	}

}

/*
5
20
0 1 2
0 2 2
0 3 5
0 4 9
1 0 2
1 2 3
1 3 4
1 4 8
2 0 2
2 1 3
2 3 7
2 4 6
3 0 5
3 1 4
3 2 7
3 4 5
4 0 9
4 1 8
4 2 6
4 3 5
==> 8

4
12
0 1 94
0 2 53
0 3 16
1 0 79
1 2 24
1 3 18
2 0 91
2 1 90
2 3 98
3 0 26
3 1 51
3 2 92
==> 16
*/