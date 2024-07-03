package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1238
public class BJ_파티_1238_내풀이 {
	static class Node {
        int v;
        int c;
        Node(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
    static int n, m, x, max;
    static final int INF = 1000 * 1000;
    static List<List<Node>> adjList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        // 인접리스트 정점 입력
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>()); // 0 dummy
        }

        // 인접리스트 간선 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList.get(v1).add(new Node(v2, c));
        }

        // 풀이: 다익스트라
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dijkstra(i, x) + dijkstra(x, i));
        }

        // 출력
        bw.write(max + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static int dijkstra(int start, int end) {
        int[] cost = new int[n + 1]; // 0 dummy
        boolean[] visit = new boolean[n + 1]; // 0 dummy
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.c - n2.c);

        Arrays.fill(cost, INF);
        cost[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            // 방문 여부 확인
            if (visit[node.v]) continue;
            visit[node.v] = true;

            // 목적지 도달 여부 확인
            if (node.v == end) break;

            // 인접 정점 최소 비용 갱신
            for (Node n : adjList.get(node.v)) {
                if (visit[n.v]) continue;
                // 최소 비용 갱신 후 큐에 넣기
                cost[n.v] = Math.min(cost[n.v], node.c + n.c);
                pq.offer(new Node(n.v, cost[n.v]));
            }
        }

        return cost[end];
    }
}

/*
4 8 2
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3

=>10
*/