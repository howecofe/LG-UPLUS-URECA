package basic.delta;

import java.util.Arrays;

// 2차원 배열 (문자)
// if - else 구조의 사방 탐색은 개발자의 실수를 많이 유발
// -> 상하좌우 이동에 대한 변화량을 미리 배열로 계산.
// 배열 : 상(-1, 0) 하(+1, 0) 좌(0, -1) 우(0, 1+)
public class DeltaTest1 {

	static char[][] map = new char[5][5];
	public static void main(String[] args) {
		char ch = 'A';
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = ch++;
			}
		}
		
		// 출력
		for (int i = 0; i < 5; i++) {
			// 일차원 배열 출력
			System.out.println(Arrays.toString(map[i]));
		}
		
		// 다차원 배열 출력
//		System.out.println(Arrays.deepToString(map).replace("], ", "]\n"));
		
//		// y = 3, x = 3 자리의 상하좌우 출력
//		print4_no_delta(3, 3);
		
		// 전체 사방탐색
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
//				print4(i, j); // 사방탐색
//				print4x(i, j); // 대각선탐색
				print8(i, j); // 팔방탐색
			}
		}
		
	}
	
	// 사방탐색 (상하좌우)
	static void print4_no_delta(int y, int x) {
		
		// 상 y-1, x
		if (y - 1 >= 0) {
			System.out.println(map[y - 1][x]);
		}
		
		// 하 y+1, x
		if (y + 1 < 5) {
			System.out.println(map[y + 1][x]);
		}
		
		// 좌 y, x-1
		if (x - 1 >= 0) {
			System.out.println(map[y][x - 1]);
		}
		
		// 우 y, x+1
		if (x + 1 < 5) {
			System.out.println(map[y][x + 1]);
		}
	
	}
	
	// delta
	// 상, 하, 좌, 우
	// 상하좌우 순서가 있다. (문제에 따라 순서를 고정시켜야 하는 경우도 존재)
	static int dy4[] = {-1, 1, 0, 0}; // y축 변화량
	static int dx4[] = { 0, 0, -1, 1}; // x축 변화량
	
	// delta 를 이용한 사방탐색
	static void print4(int y, int x) {
		System.out.print(map[y][x] + " : ");
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy4[d];
			int nx = x + dx4[d];
			
			if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5) continue; // 경계값 체크
			
			System.out.print(map[ny][nx]);
		}
		
		System.out.println();
	}
	
	// 대각선 : 좌상, 우상, 좌하, 우하
	static int dy4x[] = { -1, -1, 1, 1};
	static int dx4x[] = { -1, 1, -1, 1};

	static void print4x(int y, int x) {
		System.out.print(map[y][x] + " : ");
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy4x[d];
			int nx = x + dx4x[d];
			
			if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5) continue; // 경계값 체크
			
			System.out.print(map[ny][nx]);
		}
		
		System.out.println();
	}
	
	// 팔방탐색
	static int dy8[] = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int dx8[] = {0, 0, -1, 1, -1, 1, -1, 1};

	static void print8(int y, int x) {
		System.out.print(map[y][x] + " : ");
		
		for (int d = 0; d < 8; d++) {
			int ny = y + dy8[d];
			int nx = x + dx8[d];
			
			if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5) continue; // 경계값 체크
			
			System.out.print(map[ny][nx]);
		}
		
		System.out.println();
	}
	
}
