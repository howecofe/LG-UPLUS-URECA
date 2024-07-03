package ch09_최단경로;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// [1번 회사 --> K번 회사 --> X번 회사]에 대한 최단 경로 문제
// 회사별 이동 시간(비용) 모두 1 <= 가중치가 동일하므로 bfs로도 가능 (1 -> K, K -> X)
// 모든 정점에서 다른 모든 정점으로 가는 최단 경로 알고리즘을 적용
// 플로이드워셜 O(N^3) 3중 for문 <= N이 적을 때 사용해야 한다.(500 미만)
// 자료구조 : 인접행렬 matrix 는 최초 입력 테케로 초기화가 된 후, 3중 for문에 의해 최소 비용으로 갱신
public class 미래도시_플로이드워셜 {

//	static final int INF = Integer.MAX_VALUE; // overflow 발생
	static final int INF = 100 * 100;
	static int n, m, x, k;
	static int[][] matrix;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 정점(도시) 수
		m = Integer.parseInt(st.nextToken()); // 간선(도로) 수 비용 1
		
		matrix = new int[n + 1][n + 1];
		
		// matrix 초기화
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) matrix[i][j] = 0; // i == j 0으로 초기화
				else matrix[i][j] = INF; // 충분히 큰 값으로 전체 초기화
			}
		}
		
		// m개의 간선(도로)
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 양방향
			matrix[a][b] = 1;
			matrix[b][a] = 1;
		}
		
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		// 풀이: 플로이드워셜
		for (int k = 1; k <= n; k++) { // 경유지가 항상 첫번째 for문이어야 한다.
			for (int i = 1; i <= n; i++) { // 행
				for (int j = 1; j <= n; j++) { // 열
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
				}
			}
		}
		
		int distance = matrix[1][k] + matrix[k][x]; // k를 경유해야 함!
		
		if (distance >= INF) bw.write(-1 + "");
		else bw.write(distance + "");
		
		br.close();
		bw.flush();
		bw.close();
	}

}

/*
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5

=> 3
*/
