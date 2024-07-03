package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1197
public class BJ_최소스패닝트리_내풀이_크루스칼 {
	static int V, E, result;
    static int[] parent;
    static  Edge[] edges;
    static class Edge {
        int v1, v2, c;
        Edge(int v1, int v2, int c) {
            this.v1 = v1;
            this.v2 = v2;
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
        parent = new int[V + 1];
        edges = new Edge[E];

        // 간선 배열 초기화
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(v1, v2, c);
        }

        // 풀이: 최소 신장 트리 - 크루스칼
        // 정점의 부모 배열 초기화
        makeSet();

        // 간선 정렬
        Arrays.sort(edges, (e1, e2) -> e1.c - e2.c);

        // 모든 정점 연결 여부 확인(간선 개수 : V - 1)
        int cnt = 0;
        for (Edge edge : edges) {
            // cycle 확인 후 union
            if (union(edge.v1, edge.v2)) {
                result += edge.c;
                cnt++;
            }

            if (cnt == V - 1) break;
        }

        // 출력
        bw.write(result + ""); // 최소 비용

        br.close();
        bw.flush();
        bw.close();
    }

    // 정점(index)의 부모 배열 초기화
    static void makeSet() {
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
    }

    // 정점의 루트노드 리턴
    static int findSet(int v) {
        if (parent[v] == v) return v;
        return parent[v] = findSet(parent[v]);
    }

    // cycle 확인 후 Union
    static boolean union(int x, int y) {
        // 루트노드가 같은지 확인
        int px = findSet(x);
        int py = findSet(y);
        if (px == py) return false; // cycle 확인

        // 작은 값으로 합친다.
        if (px < py) parent[py] = px;
        else parent[px] = py;

        return true;
    }

}

/*
3 3
1 2 1
2 3 2
1 3 3

==>3
*/
