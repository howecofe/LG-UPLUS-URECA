package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1197
public class BJ_최소스패닝트리_내풀이_프림 {
	static int V, E, result;
    static int[][] matrix;
    static boolean[] visit;
    static PriorityQueue<Vertex> pq = new PriorityQueue<>((v1, v2) -> v1.c - v2.c);
    
    static class Vertex {
        int v, c;
        Vertex(int v1, int c) {
            this.v = v1;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        matrix = new int[V + 1][V + 1];
        visit = new boolean[V + 1];

        // 인접행렬 초기화
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            matrix[v1][v2] = c;
            matrix[v2][v1] = c;
        }

        // 풀이: 최소 신장 트리 - 프림
        // 시작 정점 처리
        pq.offer(new Vertex(1, 0));

        // 정점 방문
        int cnt = 0;
        while (!pq.isEmpty()) {
            Vertex vertex = pq.poll();
            // 방문 여부 확인
            if (visit[vertex.v]) continue;
            visit[vertex.v] = true;
            cnt++;
            result += vertex.c; // 비용 업데이트

            // 모든 정점 연결 여부 확인
            if (cnt == V) break;

            // 인접 정점 방문
            for (int i = 1; i <= V; i++) {
                // 간선 여부 및 방문 여부 확인
                if (matrix[vertex.v][i] == 0 || visit[i]) continue;

                // 인접 정점 큐에 추가
                pq.offer(new Vertex(i, matrix[vertex.v][i]));
            }
        }

        // 출력
        bw.write(result + ""); // 최소 비용

        br.close();
        bw.flush();
        bw.close();
    }
}

/*
3 3
1 2 1
2 3 2
1 3 3

==>3
*/
