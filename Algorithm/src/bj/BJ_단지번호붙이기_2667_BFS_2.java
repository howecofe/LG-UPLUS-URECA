package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

// https://www.acmicpc.net/problem/2667

// bfs + no visit
public class BJ_단지번호붙이기_2667_BFS_2 {

	static int N, cnt; // 단지별 수
	static char[][] map;
//	static boolean[][] visit;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static List<Integer> list = new ArrayList<>(); // 각 단지별 수 추가, 나중에 정렬
	static Queue<Node> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][];
//		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
		
		// 풀이
		// 2차원 배열을 순회하면서 새로운 영역이 나오면 dfs 수행
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != '1') continue;
                
                bfs(i, j);
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
	
	static void bfs(int y, int x) {
		cnt = 1; // 처음 호출되면 새로운 단지가 만들어지므로 1로 초기화
//		visit[y][x] = true; // 방문 처리
		map[y][x] = '0'; // 방문 처리
		q.offer(new Node(y, x));
		
		while (!q.isEmpty()) {
			Node node = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				
				if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
				if (map[ny][nx] != '1') continue;
				
				cnt++;
//				visit[ny][nx] = true;
				map[ny][nx] = '0'; // 방문 처리
				q.offer(new Node(ny, nx));
			}
		}
	}
	
	static class Node {
		int y, x;
		
		Node(int y, int x) {
			this.y = y;
			this.x = x;
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
