package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3109
public class BJ_빵집_3109_내풀이_DFS {
	
	static int R, C, result;
    static char[][] matrix;
    static boolean[][] visit;
//    static int[] dy = {-1, 0, 1}; // 우상, 우, 우하
//    static int[] dx = {1, 1, 1}; // 우상, 우, 우하

    static int[] dy = {1, 0, -1}; // 우하, 우, 우상
    static int[] dx = {1, 1, 1}; // 우하, 우, 우상
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        matrix = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            matrix[i] = br.readLine().toCharArray();
        }

        // 풀이
        // 위에서부터 시작
//        for (int i = 0; i < R; i++) {
//            if (!visit[i][0] && dfs(i, 0)) result++;
//        }

        // 밑에서부터 시작
        for (int i = R - 1; i >= 0; i--) {
            if (!visit[i][0] && dfs(i, 0)) result++;
        }

        // 출력
        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static boolean dfs(int y, int x) {
        // 해당 노드 방문 처리
        visit[y][x] = true;

        // 기저조건
        // 빵집(마지막 열)에 도착하면 return
        if (x == C - 1) return true;

        // 인접 노드 방문: 우상, 우, 우하
        for (int d = 0; d < 3; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            // 경계값 체크
            if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
            // 방문 여부 및 건물 여부 체크
            if (visit[ny][nx] || matrix[ny][nx] == 'x') continue;

            // 방문
            if (dfs(ny, nx)) return true;
        }

        return false;
    }
}
