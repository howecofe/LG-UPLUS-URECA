package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 두 개 그룹으로 나누는 문제(A, B)
// 부분집합 : 선택된 그룹(A), 선택되지 않은 그룹(B)
// 부분집합의 경우의 수가 완성되면
// 		유효성 : 모두 연결 <= 2차원 배열의 그래프 인접행렬을 구성 <= bfs()
// 				A 따로, B 따로. 갈 수 있는 인접 구역을 모두 방문 (visit[])
//              visit[]이 모두 true로 되어 있으면 두 그룹 모두 방문 가능
// 		두 그룹의 인구 수의 차이를 min
public class BJ_게리멘더링_17471 {
	
	static int N, min;
	static int[][] matrix; // 그래프의 인접 행렬 i, j 모두 정점, 이 문제는 j 가 index, 정점 X
	static boolean[] select, visit; // select (부분집합), visit (bfs 연결구조파악)
	static Queue<Integer> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		matrix = new int[N + 1][N + 1]; // 0: dummy <- 인구 수
		select = new boolean[N + 1];
		visit = new boolean[N + 1];
		
		// 인구 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			matrix[i][0] = Integer.parseInt(st.nextToken());
			
		}
		
		// 정점별 이웃하는 정점
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // i 구역이 인접한 구역의 수
			for (int j = 1; j <= n; j++) {
				int v = Integer.parseInt(st.nextToken());
				matrix[i][j] = v;
			}
		}
		
		// 풀이
		min = Integer.MAX_VALUE;
		subset(1);
		
		if (min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	
	static void subset(int srcIdx) {
		// 기저 조건 & complete code
		if (srcIdx == N + 1) {
			// 부분집합 1개 완성
			check();
			
			return;
		}
		
		select[srcIdx] = true;
		subset(srcIdx + 1);
		select[srcIdx] = false;
		subset(srcIdx + 1);
	}
	
	static void check() {
		// A, B 따로 각각 모두 연결 확인 : bfs 이용해서 visit 배열 완성
		Arrays.fill(visit, false);
		q.clear();
		
		// A : select 배열 중 true
		// 시작점 넣기
		for (int i = 1; i <= N; i++) {
			if (select[i]) {
				visit[i] = true;
				q.offer(i);
				break;
			}
		}
		
		if (q.size() == 0) return; // 공집합
		
		while (!q.isEmpty()) {
			int v = q.poll();
			
			for (int i = 1; i <= N; i++) {
				int adj = matrix[v][i];
				if (adj != 0 && !visit[adj] && select[adj]) {
					visit[adj] = true;
					q.offer(adj);
				}
			}
		}
		
		// B : select 배열 중 false
		for (int i = 1; i <= N; i++) {
			if (!select[i]) {
				visit[i] = true;
				q.offer(i);
				break;
			}
		}
		
		while (!q.isEmpty()) {
			int v = q.poll();
			
			for (int i = 1; i <= N; i++) {
				int adj = matrix[v][i];
				if (adj != 0 && !visit[adj] && !select[adj]) {
					visit[adj] = true;
					q.offer(adj);
				}
			}
		}
		
		// A, B 각각 visit[]를 갱신했지만 전체가 true 이어야 모두 연결
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) return;
		}
		
		// 유효검증 통과
		int sumA = 0;
		int sumB = 0;
		
		for (int i = 1; i <= N; i++) {
			if (select[i]) sumA += matrix[i][0];
			else sumB += matrix[i][0];
		}
		
		min = Math.min(min, Math.abs(sumA - sumB));
		
	}

}
