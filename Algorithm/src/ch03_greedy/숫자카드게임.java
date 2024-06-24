package ch03_greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 숫자카드게임 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int result = 0;
		
		// 한줄씩 입력 받아 확인하기
		for (int i = 0; i < row; i++) {
			// 현재 줄에서 '가장 작은 수' 찾기
			int min = 10001;
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < col; j++) {
				min = Math.min(min, Integer.parseInt(st.nextToken()));
			}
			
			// '가장 작은 수'들 중에서 가장 큰 수 찾기
			result = Math.max(result, min);
		}
		
		bw.write(result + "");
		
		br.close();
		bw.flush();
		bw.close();

	}

}
/*
3 3
3 1 2
4 1 4
2 2 2

2
--
2 4
7 3 1 8
3 3 3 4

3
*/