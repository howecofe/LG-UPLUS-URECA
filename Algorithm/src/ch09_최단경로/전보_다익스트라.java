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

public class 전보_다익스트라 {

	static class Node {
        int v; // 정점
        int t; // 시간
        Node(int v, int t) {
            this.v = v;
            this.t = t;
        }
    }
	
	static int n, m, c;
	static final int INF = Integer.MAX_VALUE;
	static List<List<Node>> adjList = new ArrayList<>();
	static PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.t - n2.t);
	static int[] cost;
	static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        // 인접리스트 정점 입력
        for (int i = 0; i <= n; i++) { // n + 1개, 0: dummy
            adjList.add(new ArrayList<>());
        }
        
        cost = new int[n + 1]; // 0 dummy
        visit = new boolean[n + 1]; // 0 dummy

        // 간선 -> 인접 리스트 완성
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            
            adjList.get(x).add(new Node(y, z));
        }

        // 풀이: 다익스트라
        dijkstra(c);
        
        // 출력: 도착한 도시 수(INF가 아닌 도시 수), 총 걸린 시간 (최단 시간 중 max)
        int recieveCnt = 0;
        int maxTime = 0;
        
        for (int i = 1; i <= n; i++) {
        	if (cost[i] == INF) continue;
        	
        	recieveCnt++;
        	maxTime = Math.max(maxTime, cost[i]);
        }
        
        // 받은 도시만 계산해야 해서 시작 도시는 뺀다. (-1)
        bw.write((recieveCnt - 1) + " " + maxTime);

        br.close();
        bw.flush();
        bw.close();
    }
    
    static void dijkstra(int s) {
    	Arrays.fill(cost, INF);
    	
    	cost[s] = 0;
    	pq.offer(new Node(s, 0));
    	
    	while (!pq.isEmpty()) {
    		Node node = pq.poll();
    		if (visit[node.v]) continue;
    		visit[node.v] = true;
    		
    		for (Node n : adjList.get(node.v)) {
    			if (visit[n.v]) continue;
    			
    			cost[n.v] = Math.min(cost[n.v], node.t + n.t);
    			pq.offer(new Node(n.v, cost[n.v]));
    		}
    	}
    }
}

/*
3 2 1
1 2 4
1 3 2
=> 2 4
*/
