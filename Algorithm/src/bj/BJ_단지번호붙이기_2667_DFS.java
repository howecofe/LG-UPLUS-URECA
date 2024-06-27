package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.acmicpc.net/problem/2667

// dfs + visit
public class BJ_단지번호붙이기_2667_DFS {

	static int N, cnt; // 단지별 수
	static char[][] map;
	static boolean[][] visit;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static List<Integer> list = new ArrayList<>(); // 각 단지별 수 추가, 나중에 정렬
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
		
		// 풀이
		// 2차원 배열을 순회하면서 새로운 영역이 나오면 dfs 수행
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != '1' || visit[i][j]) continue;
                
                cnt = 0; // 최초 호출 시 초기화
                dfs(i, j);
                list.add(cnt);
            }
        }
		
		Collections.sort(list); // 정렬
		
		// 출력
		int size = list.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	static void dfs(int y, int x) {
		cnt++; // 호출될 때마다 증가
		visit[y][x] = true; // 방문 처리
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
			
			if (map[ny][nx] != '1' || visit[ny][nx]) continue;
			
			dfs(ny, nx);
		}
	
	}

}

/*
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

3
*/