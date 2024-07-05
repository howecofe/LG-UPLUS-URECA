package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 완탐 (dfs)
public class BJ_파이프옮기기1_17070_DFS {

	static int N, cnt;
	static int[][] map;
	// 이동규칙이 담긴 delta
	static int[][][] delta = { // 0: 현재 이동방향, 1: y 변화량, 2: x 변화량
			{{1, 1}, {0, 1}, {1, 0}}, // 대각선 : 대각선, 가로, 세로
			{{1, 1}, {0, 1}, {0, 0}}, // 가로 : 대각선, 가로, 세로는 dummy
			{{1, 1}, {0, 0}, {1, 0}} // 세로 : 대각선, 가로는 dummy, 세로
	};
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N + 1][N + 1]; // 0: dummy
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 풀이 Dfs()
		dfs(1, 2, 1);

		System.out.println(cnt);
	}
	
	// visit? 필요 X
	// 문제가 모든 좌표를 한 번만 방문하는 문제 X
	// 모든 가짓수를 따지는 문제 <- 어느 y, x 에 도달하기 이전에 다른 좌표를 거쳐서 올 수 있다.
	
	static void dfs(int y, int x, int d) {
		// 기저조건
		if (y == N && x == N) {
			cnt++;
			return;
		}
		
		// 규칙이 적용된 delta 를 이용해서 계속 가 본다.
		for (int i = 0; i < 3; i++) {
			int ny = y + delta[d][i][0];
			int nx = x + delta[d][i][1];
			
			// dummy check
			if (ny == y && nx == x) continue;
			
			// 경계 체크 및 벽 체크
			if (ny > N || nx > N || map[ny][nx] == 1) continue; // 우하로 계속 증가하므로 0보다 작은 경계는 체크할 필요 없다.
			
			// 대각선일 경우 스치는 두 부분도 체크
			if (i == 0 && (map[ny][nx - 1] == 1 || map[ny - 1][nx] == 1)) continue;
			
			dfs(ny, nx, i);
		}
	}

}
