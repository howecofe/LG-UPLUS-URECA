package ch10_그래프이론;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정점과 간선 정보 <= 집합 소속 관계
// Path Compression 기법 적용 (경로 압축 기법) : find할 때 루트 노드(최상단 부모)만 배열에 저장되도록!
public class 기본적인서로소집합_2 {

	static int v, e; // 정점, 간선
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		parent = new int[v + 1]; // 1번 정점부터
		
		makeSet(); // 자료구조를 집합관계로 만들어라. // 각 정점은 모두 서로소 // parent[3] => 4 : 3 정점은 4가 부모인 집합에 포함
		
		// 간선 정보 입력 -> 합집합
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			union(x, y);
		}
		
		// 인덱스 : 정점
		for (int i = 1; i <= v; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		// 부모집합
		for (int i = 1; i <= v; i++) {
			System.out.print(findSet(i) + " ");
		}
		System.out.println();
		
		// parent 배열
		for (int i = 1; i <= v; i++) {
			System.out.print(parent[i] + " ");
		}
		System.out.println();
		
		
	}
	
	// 부모 집합 초기화
	static void makeSet() {
		for (int i = 1; i <= v; i++) {
			parent[i] = i;
		}
	}
	
	// 부모 집합 리턴
	static int findSet(int x) { // 정점의 부모를 찾는 기능
		if (parent[x] == x) return x; // 자기 자신이 부모. 독립된 집합의 대표
		return parent[x] = findSet(parent[x]);
	}
	
	// 두 정점의 합집합
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if (px < py) parent[py] = px;
		else parent[px] = py; // 이미 같은 집합에 대한 처리 포함
	}

}

/*
6 4
1 4
2 3
2 4
5 6
=>
1 2 3 4 5 6 
1 1 1 1 5 5 
1 1 1 1 5 5 
*/