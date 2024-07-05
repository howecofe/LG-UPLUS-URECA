package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1600
public class BJ_말이되고픈원숭이_1600_내풀이_BFS {
	
	static int K, W, H;
    static int[][] matrix;
    static boolean[][][] visit;
    
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[] hdy = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] hdx = {1, -1, 2, -2, 2, -2, 1, -1};
    
    static class Node {
        int y, x, k, cnt;
        Node(int y, int x, int k, int cnt) {
            this.y = y;
            this.x = x;
            this.k = k;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken()); // col
        H = Integer.parseInt(st.nextToken()); // row

        // 1 x 1 인 경우 이동 횟수 0 출력
        if (W == 1 && H == 1) {
            System.out.println(0);
            return;
        }

        matrix = new int[H][W];
        visit = new boolean[H][W][K + 1]; // 말의 이동 횟수를 고려하여 방문 기록

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 풀이
        int result = bfs();

        // 출력
        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static int bfs() {
        Queue<Node> q = new ArrayDeque<>();

        // 시작 노드 넣고 방문 처리
        q.offer(new Node(0, 0, 0, 0));
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            // 노드 꺼내기
            Node node = q.poll();

            // 다음 노드 방문
            // 1. 말 움직임으로 이동
            if (node.k < K) {
                for (int d = 0; d < 8; d++) {
                    int ny = node.y + hdy[d];
                    int nx = node.x + hdx[d];

                    // 경계값, 장애물, 방문 여부 체크
                    if (ny < 0 || nx < 0 || ny >= H || nx >= W || matrix[ny][nx] == 1 || visit[ny][nx][node.k + 1]) continue;

                    // 목적지 확인
                    if (ny == H - 1 && nx == W - 1) return node.cnt + 1;

                    // 갈 수 있으면 이동
                    q.offer(new Node(ny, nx, node.k + 1, node.cnt + 1)); // k 증가
                    visit[ny][nx][node.k + 1] = true;
                }
            }

            // 2. 원숭이 움직임으로 이동
            for (int d = 0; d < 4; d++) {
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];

                // 경계값, 장애물, 방문 여부 체크
                if (ny < 0 || nx < 0 || ny >= H || nx >= W || matrix[ny][nx] == 1 || visit[ny][nx][node.k]) continue;

                // 목적지 확인
                if (ny == H - 1 && nx == W - 1) return node.cnt + 1;

                // 갈 수 있으면 이동
                q.offer(new Node(ny, nx, node.k, node.cnt + 1)); // k 그대로
                visit[ny][nx][node.k] = true;
            }
        }

        return -1;
    }
}
