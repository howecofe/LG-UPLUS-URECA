package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 분할정복 top-down
public class BJ_쿼드트리_1992_분할정복 {
	
	static int N;
	static char[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new char[N][];
        
        for (int i = 0; i < N; i++) {
        	map[i] = br.readLine().toCharArray();
        }
        
        divide(0, 0, N);
        bw.write(sb.toString());
        
        br.close();
        bw.flush();
        bw.close();
	}
	
	static void divide(int y, int x, int n) {
		// y, x 좌표를 왼쪽 위 시작점으로 하고 가로, 세로 n 길이만큼 문자가 모두 같은지 확인
		if (check(y, x, n)) { // 모든 영역이 같은 문자
			sb.append(map[y][x]);
		} else { // 모든 영역이 같은 문자 X
			sb.append("(");
			
			int half = n / 2;
			divide(y, x, half);
			divide(y, x + half, half);
			divide(y + half, x, half);
			divide(y + half, x + half, half);
			
			sb.append(")");
		}
	}
	
	static boolean check(int y, int x, int n) {
		char ch = map[y][x];
		
		for (int i = y; i < y + n; i++) {
			for (int j = x; j < x + n; j++) {
				if (ch != map[i][j]) return false;
			}
		}
		
		return true;
	}
}

/*
8
11110000
11110000
00011100
00011100
11110000
11110000
11110011
11110011

((110(0101))(0010)1(0001))
*/