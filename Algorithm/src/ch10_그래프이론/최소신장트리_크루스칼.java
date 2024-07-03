package ch10_그래프이론;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// MST - 크루스칼 알고리즘
// 간선 중심 - 간선 리스트
public class 최소신장트리_크루스칼 {
	
	static int V, E, result; // MST 총 비용
	static int[] parent;
	static Edge[] edges; // 간선 리스트
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parent = new int[V];
		edges = new Edge[E];
		
		// 입력 처리
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(v1, v2, c);
		}
		
		// 크루스칼 알고리즘
		// 간선 정렬
		Arrays.sort(edges, (e1, e2) -> e1.c - e2.c);
		// 집합 배열 처리
		makeSet();
		
		int cnt = 0; // V - 1개 만들면 된다. (cycle이 없는)
		for (Edge edge : edges) {
			// cycle 확인 후 union
			if (union(edge.v1, edge.v2)) { // 간선 선택
				result += edge.c;
				cnt++;
				if (cnt == V - 1) break; // 모든 정점 V개를 cycle 없도록 모두 연결하면 V - 1개 간선이므로
			}
		}
		System.out.println(result);
	}
	
	// 부모 집합 초기화
	static void makeSet() {
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}
	}
	
	// 부모 집합 리턴
	static int findSet(int x) { // 정점의 부모를 찾는 기능
		if (parent[x] == x) return x; // 자기 자신이 부모. 독립된 집합의 대표
		return parent[x] = findSet(parent[x]);
	}
	
	// 두 정점의 합집합
//	static void union(int x, int y) {
//		int px = findSet(x);
//		int py = findSet(y);
//		
//		if (px < py) parent[py] = px;
//		else parent[px] = py; // 이미 같은 집합에 대한 처리 포함
//	}
	
	// 크루스칼 사용 버전 union
	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if (px == py) return false; // cycle 확인
		
		if (px < py) parent[py] = px;
		else parent[px] = py; // 이미 같은 집합에 대한 처리 포함
		
		return true;
	}
	
	static class Edge {
		int v1, v2, c;
		
		Edge(int v1, int v2, int c) {
			this.v1 = v1;
			this.v2 = v2;
			this.c = c;
		}
	}


}

/*
정점수 간선수
시작정점 끝정점 가중치
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1

==>10
----------------------------------
7 11
0 1 3
0 2 17
0 3 6
1 3 5
1 6 12
2 4 10
2 5 8
3 4 9
4 5 4
4 6 2
5 6 14

==>31
 */