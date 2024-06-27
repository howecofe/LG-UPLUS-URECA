package ch05_DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Node cnt
public class 미로탈출_BFS_2 {
	
	static class Node {
	    int x;
	    int y;
	    int cnt;

	    Node(int x, int y, int cnt) {
	        this.x = x;
	        this.y = y;
	        this.cnt = cnt;
	    }
	}
	
	public static int n, m, ans;
    public static int[][] graph;
    public static boolean[][] visit;

    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우) 
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static void bfs() {
        // 큐(Queue) 구현을 위해 queue 라이브러리 사용 
        Queue<Node> q = new LinkedList<>();
        visit[0][0] = true;
        q.offer(new Node(0, 0, 1));
        
        // 큐가 빌 때까지 반복하기
        while(!q.isEmpty()) {
            Node node = q.poll();
            int y = node.y;
            int x = node.x;
            int cnt = node.cnt;
            
            // 현재 위치에서 4가지 방향으로의 위치 확인
            for (int d = 0; d < 4; d++) {
            	int ny = y + dy[d];
                int nx = x + dx[d];
                
                // 미로 찾기 공간을 벗어난 경우 무시, 방문했거나 벽인 경우 무시
                if (ny < 0 || nx < 0 || ny >= n || nx >= m || visit[ny][nx] || graph[ny][nx] == 0) continue;
                
                // 도착 지점 확인
                if (ny == n - 1 && nx == m - 1) {
                	ans = cnt + 1;
                	return;
                }
                
                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                visit[ny][nx] = true;
                q.offer(new Node(nx, ny, cnt + 1));
            } 
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M을 공백을 기준으로 구분하여 입력 받기
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visit = new boolean[n][m];

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // BFS를 수행한 결과 출력
        bfs();
        System.out.println(ans);
    }

}

/*
5 6
101010
111111
000001
111111
111111

10
*/
