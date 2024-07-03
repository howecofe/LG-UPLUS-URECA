package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최소 신장 트리 (MST)
// 프림 + 인접 행렬 <= 메모리 초과 : 2차원 배열이 너무 커진다. 10만 * 10만
// https://www.acmicpc.net/problem/1647
public class BJ_도시분할계획_1647_프림 {
	static int N, M, result;
	static int[][] matrix;
	static boolean[] visit;
	static PriorityQueue<Vertex> pq = new PriorityQueue<>((v1, v2) -> v1.c - v2.c);
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
		
        matrix = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
 
        // 인접 행렬 구성
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int v1 = Integer.parseInt(st.nextToken());
        	int v2 = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	matrix[v1][v2] = c;
        	matrix[v2][v1] = c;
        }
        
        // 풀이
        // 1번 정점과 연결된 정점을 pq 에 넣기
        for (int i = 1; i <= N; i++) {
        	if (matrix[1][i] != 0) pq.offer(new Vertex(i, matrix[1][i]));
        }
        
        int cnt = 1; // 선택된 정점의 수
        int maxCost = 0;
        
        
        while (!pq.isEmpty()) {
        	Vertex vertex = pq.poll();
        	
        	if (visit[vertex.v]) continue;
        	visit[vertex.v] = true;
        	
        	result += vertex.c;
        	maxCost = Math.max(maxCost, vertex.c);
        	cnt++;
        	
        	if (cnt == N) break;
        	
        	for (int i = 1; i <= N; i++) {
        		if (matrix[vertex.v][i] == 0 || visit[i]) continue;
        		
        		pq.offer(new Vertex(i, matrix[vertex.v][i]));
        	}
        }

        System.out.println(result - maxCost);
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
