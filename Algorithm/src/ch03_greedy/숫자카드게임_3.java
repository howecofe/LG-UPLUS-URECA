package ch03_greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 리팩토링 + 2차원 배열 사용
// + 입력받으면서 바로 처리하도록 (입력 값 저장 x)
public class 숫자카드게임_3 {

	static int row, col, result;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < row; i++) {
			// 각 행별로 가장 작은 수 선택
			int min_value = 10001;
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < col; j++) {
				min_value = Math.min(min_value, Integer.parseInt(st.nextToken()));
			}
			result = Math.max(result, min_value);
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