package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14502
public class BJ_연구소_14502_내풀이_BFS_순열 {
	static int N, M, max;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 풀이
        // 1. 벽을 3개 세운다. (dfs - 순열)
        // 2. -> 순열 1개가 완성되면, bfs로 바이러스 퍼지게 하기
        // 3. 0인 부분 카운트하며 안전영역 최댓값 갱신
        perm(0);

        // 출력
        bw.write(max + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static void perm(int depth) {
        if (depth == 3) { // 3 == tgt.length
            // 순열 1개 완성(벽을 세울 좌표 3개 완성)되면 bfs 수행
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) { // 빈 칸이면 (벽을 세울 수 있으면)
                    map[i][j] = 1; // 벽 세우기
                    perm(depth + 1);
                    map[i][j] = 0; // 백트래킹 (원복, 벽 허물기)
                }
            }
        }

    }

    static void bfs() {
        // 큐 초기화
        Queue<int[]> q = new ArrayDeque<>();

        // 배열 복사
        int[][] copied = new int[N][M];
        for (int i = 0; i < N; i++) {
            copied[i] = Arrays.copyOf(map[i], map[i].length);
        }

        // 큐에 바이러스 좌표 넣기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copied[i][j] == 2) q.offer(new int[]{i, j});
            }
        }

        // 인접 좌표 방문하며 바이러스 전파
        while (!q.isEmpty()) {
            int[] virus = q.poll();

            for (int d = 0; d < 4; d++) {
                int ny = virus[0] + dy[d];
                int nx = virus[1] + dx[d];

                // 경계값 체크, 빈칸인지 체크
                if (ny < 0 || nx < 0 || ny >= N || nx >= M || copied[ny][nx] != 0) continue;

                copied[ny][nx] = 2; // 바이러스 전파
                q.offer(new int[]{ny, nx});
            }
        }

        // 전파가 다 끝나면 안전영역 카운트
        countSafeZone(copied);
    }

    static void countSafeZone(int[][] matrix) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 0) cnt++;
            }
        }

        // 최댓값 갱신
        max = Math.max(max, cnt);
    }
}
