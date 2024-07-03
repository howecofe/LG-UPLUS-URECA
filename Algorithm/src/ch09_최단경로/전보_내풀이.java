package ch09_최단경로;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 전보_내풀이 {

	static class Node {
		int v;
		int c;

		Node(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}

	static int V, E, start;
	static int[] cost;
	static boolean[] visit;
	static final int INF = Integer.MAX_VALUE;
	static List<List<Node>> adjList = new ArrayList<>();
	static PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.c - n2.c);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 입력
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		cost = new int[V + 1]; // 0 dummy
		visit = new boolean[V + 1]; // 0 dummy

		// 인접리스트 정점 입력
		for (int i = 0; i <= V; i++) { // 0 dummy
			adjList.add(new ArrayList<>());
		}

		// 인접리스트 정점 ~> 연결된 정점까지의 최소 비용(거리) 입력
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adjList.get(v1).add(new Node(v2, c));
		}

		// 풀이: 다익스트라
		Arrays.fill(cost, INF);
		cost[start] = 0;
		pq.offer(new Node(start, cost[start]));

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			// 방문 여부 확인
			if (visit[node.v])
				continue;
			visit[node.v] = true;

			// 인접 정점 최소 비용 갱신
			for (Node adj : adjList.get(node.v)) {
				// 방문 여부 확인
				if (visit[adj.v])
					continue;
				// 최소 비용 갱신
				cost[adj.v] = Math.min(cost[adj.v], node.c + adj.c);
				// 갱신한 인접 정점을 큐에 넣기
				pq.offer(new Node(adj.v, cost[adj.v]));
			}
		}

		// 출력
		int cnt = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 1; i < cost.length; i++) {
			if (cost[i] == INF)
				continue;

			cnt++;
			max = Math.max(max, cost[i]);
		}

		// 받은 도시만 계산해야 해서 시작 도시는 뺀다. (-1)
		bw.write((cnt - 1) + " " + max);

		br.close();
		bw.flush();
		bw.close();
	}
}

/*
 * 3 2 1 1 2 4 1 3 2 => 2 4
 */
