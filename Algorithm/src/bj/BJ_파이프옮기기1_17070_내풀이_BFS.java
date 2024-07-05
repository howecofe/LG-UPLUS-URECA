package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_파이프옮기기1_17070_내풀이_BFS {
	
	static int N, result;
    static int[][] matrix;
    static class Pipe {
        int y, x, type;
        Pipe(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        N = Integer.parseInt(br.readLine());
        matrix = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 풀이
        bfs();

        // 출력
        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static void bfs() {
        Queue<Pipe> q = new ArrayDeque<>();
        q.offer(new Pipe(1, 2, 0)); // type : 0 가로 1 세로 2 대각선

        while (!q.isEmpty()) {
            Pipe pi = q.poll();

            if (pi.y == N && pi.x == N) {
                result++;
                continue;
            }

            if (pi.type == 0) { // 가로
                // 가로
                if (check(pi.y, pi.x + 1) && matrix[pi.y][pi.x + 1] == 0) {
                    q.offer(new Pipe(pi.y, pi.x + 1, 0));
                }

                // 대각선
                if (check(pi.y + 1, pi.x + 1) && matrix[pi.y][pi.x + 1] == 0 && matrix[pi.y + 1][pi.x + 1] == 0 && matrix[pi.y + 1][pi.x] == 0) {
                    q.offer(new Pipe(pi.y + 1, pi.x + 1, 2));
                }

            } else if (pi.type == 1) { // 세로
                // 세로
                if (check(pi.y + 1, pi.x) && matrix[pi.y + 1][pi.x] == 0) {
                    q.offer(new Pipe(pi.y + 1, pi.x, 1));
                }

                // 대각선
                if (check(pi.y + 1, pi.x + 1) && matrix[pi.y][pi.x + 1] == 0 && matrix[pi.y + 1][pi.x + 1] == 0 && matrix[pi.y + 1][pi.x] == 0) {
                    q.offer(new Pipe(pi.y + 1, pi.x + 1, 2));
                }

            } else if (pi.type == 2) { // 대각선
                // 가로
                if (check(pi.y, pi.x + 1) && matrix[pi.y][pi.x + 1] == 0) {
                    q.offer(new Pipe(pi.y, pi.x + 1, 0));
                }

                // 세로
                if (check(pi.y + 1, pi.x) && matrix[pi.y + 1][pi.x] == 0) {
                    q.offer(new Pipe(pi.y + 1, pi.x, 1));
                }

                // 대각선
                if (check(pi.y + 1, pi.x + 1) && matrix[pi.y][pi.x + 1] == 0 && matrix[pi.y + 1][pi.x + 1] == 0 && matrix[pi.y + 1][pi.x] == 0) {
                    q.offer(new Pipe(pi.y + 1, pi.x + 1, 2));
                }
            }
        }
    }

    static boolean check(int y, int x) {
        if (y < 1 || x < 1 || y > N || x > N) return false;
        return true;
    }
}
