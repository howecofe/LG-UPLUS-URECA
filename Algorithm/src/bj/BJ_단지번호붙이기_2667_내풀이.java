package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// https://www.acmicpc.net/problem/2667
public class BJ_단지번호붙이기_2667_내풀이 {

    static int N, cnt;
    static List<Integer> list = new ArrayList<>();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static char[][] graph;
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
        N = Integer.parseInt(br.readLine());
        graph = new char[N][];

        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        // 풀이 2가지 : DFS, BFS
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == '1') {
                    cnt = 0; // 단지 내 집의 수 초기화
//                    dfs(i, j);
                    bfs(i, j);
                    list.add(cnt); // 단지 내 집의 수 추가
                }
            }
        }

        // 출력
        bw.write(list.size() + "\n");
        list.sort(Comparator.naturalOrder());
        for (int n : list) bw.write(n + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int y, int x) {
        // 해당 노드 방문 처리
        graph[y][x] = '0';

        // 필요한 수행 처리 : 단지 내 집의 수 증가
        cnt++;

        // 상하좌우 방문
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            // 경계값 검사 및 집의 여부 체크
            if (ny < 0 || nx < 0 || ny >= N || nx >= N || graph[ny][nx] != '1') continue;

            dfs(ny, nx);
        }
    }

    static void bfs(int y, int x) {
        // 큐에 넣고 방문 처리
        q.offer(new Node(y, x));
        graph[y][x] = '0';

        while (!q.isEmpty()) {
            Node node = q.poll();

            // 필요한 수행 처리 : 단지 내 집의 수 증가
            cnt++;

            // 상하좌우 방문
            for (int d = 0; d < 4; d++) {
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];

                // 경계값 검사 및 집의 여부 체크
                if (ny < 0 || nx < 0 || ny >= N || nx >= N || graph[ny][nx] != '1') continue;

                // 큐에 넣고 방문 처리
                q.offer(new Node(ny, nx));
                graph[ny][nx] = '0';
            }
        }
    }

}