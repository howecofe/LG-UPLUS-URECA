package ch05_DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탈출_내풀이 {

	static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Queue<Node> q = new ArrayDeque<>();
    static class Node {
        int y, x;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1]; // 0 dummy
        visit = new boolean[N + 1][M + 1]; // 0 dummy

        for (int i = 1; i <= N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                map[i][j] = arr[j - 1] - '0';
            }
        }

        // 풀이
        bfs(1, 1);

        // 출력
        bw.write(map[N][M] + "");

        br.close();
        bw.flush();
        bw.close();
    }
    
    static void bfs(int y, int x) {
        // 큐에 넣고 방문 처리
        q.offer(new Node(y, x));
        visit[y][x] = true;

        while (!q.isEmpty()) {
            // 꺼낸다.
            Node node = q.poll();

            // 상하좌우 방문
            for (int d = 0; d < 4; d++) {
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];

                // 경계값 검사
                if (ny < 1 || nx < 1 || ny > N || nx > M) continue;

                // 괴물 여부, 방문 여부 검사
                if (map[ny][nx] == 0 || visit[ny][nx]) continue;

                // 검사 통과하면 큐에 넣고 방문 처리
                q.add(new Node(ny, nx));
                visit[ny][nx] = true;

                // 새로운 위치의 값을 이전 위치값에서 1 증가시킨 값으로 갱신
                map[ny][nx] = map[node.y][node.x] + 1;
            }
        }
    }

}
