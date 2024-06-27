package ch05_DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 음료수얼려먹기_내풀이 {
	static int N, M, result;
	static boolean[][] matrix, visit;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new boolean[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == '0') matrix[i][j] = true;
				else matrix[i][j] = false;
			}
		}
		
		// 풀이 (인접행렬 이용)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				if (dfs(i, j)) { // 모든 노드 dfs 호출
					result++; // true 반환 시 result +1
				}
			}
		}
		
		// 출력
		bw.write(result + "");
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static int cnt = 0;
	static boolean dfs(int y, int x) {
		// 경계 체크
		if (!isInBounds(y, x)) return false;
		
		
		// 상하좌우 방문
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			// 벽으로 막혀 있거나, 이미 방문했으면 continue
			if (matrix[y][x] || !visit[y][x]) continue;
			
			// 그게 아니면 방문 처리 + 상하좌우 방문
			visit[y][x] = true;
			dfs(ny, nx);
		}
		
		return true;
	}
	
	static boolean isInBounds(int y, int x) {
		if (y < 0 || x < 0 || y >= N || y >= M) return false;
		return true;
	}

}

/*
3 3
001
010
101

3
*/
