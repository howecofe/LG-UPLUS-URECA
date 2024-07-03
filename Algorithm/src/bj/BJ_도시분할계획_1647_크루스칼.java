package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 최소 신장 트리(MST)
// 크루스칼 + 간선 리스트 (ArrayList)
// https://www.acmicpc.net/problem/1647
public class BJ_도시분할계획_1647_크루스칼 {

	static int N, M, result;
	static int[] parent;
	static List<Edge> edges = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
		
        parent = new int[N + 1];
        
        // 간선 리스트 구성
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int v1 = Integer.parseInt(st.nextToken());
        	int v2 = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	edges.add(new Edge(v1, v2, c));
        }
        
        // 풀이
        makeSet();
        // 간선 정렬
        Collections.sort(edges, (e1, e2) -> e1.c - e2.c); // Comparator
        
        int cnt = 0; // 간선의 개수
        int maxCost = 0; // 유효한 간선의 최댓값
        
        for (int i = 0; i < edges.size(); i++) {
        	int v1 = edges.get(i).v1;
        	int v2 = edges.get(i).v2;
        	int c = edges.get(i).c;
        	
        	if (union(v1, v2)) { // cycle 생기지 않는 유효한 간선 선택
        		result += c;
        		maxCost = c; // 현재까지의 가장 큰 비용
        		
        		cnt++;
        		if (cnt == N - 1) break;
        	}
        }
        
        System.out.println(result - maxCost);
	}
	
	static void makeSet() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int x) {
		if (parent[x] == x) return x;
		return parent[x] = findSet(parent[x]); // path compression
	}
	
	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		// cycle check
		if (px == py) return false;
		
		// union
		if (px < py) parent[py] = px;
		else parent[px] = py;
		
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
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4

==>8
*/
