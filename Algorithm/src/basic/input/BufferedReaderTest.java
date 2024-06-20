package basic.input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BufferedReaderTest {

	public static void main(String[] args) throws Exception {
		// 1 2 3 4 5
		{
			// InputStreamReader : 노드 스트림
			// BufferedReader : 보조 중간 스트림
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine(); // 한 줄 전체를 문자열 하나로 읽는다.
			
			// StringTokenizer : 전달된 문자열을 공백 기준으로 개별 문자열로 자를 준비를 하게 된다.
			StringTokenizer st = new StringTokenizer(str); 
			
			int[] input = new int[5];
			for (int i = 0; i < 5; i++) {
				input[i] = Integer.parseInt(st.nextToken()); // "1" -> 1, "2" -> 2 ....
 			}
			
			System.out.println(Arrays.toString(input)); // Arrays.toString(배열) : 1차원 배열 요소를 보여준다.
		}
		
		// 1 A 3 B 5
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str); 
			
			char[] input = new char[5];
			for (int i = 0; i < 5; i++) {
				input[i] = st.nextToken().charAt(0); // "1" -> '1', "2" -> '2' ....
 			}
			
			System.out.println(Arrays.toString(input));
		}
		
		// XYZQU
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			char[] input = br.readLine().toCharArray();
			
			System.out.println(Arrays.toString(input));
		}
		
/*
6
1 2 3 4 5 1
*/
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			int[] input = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			System.out.println(Arrays.toString(input));
		}
		
/*
5
XYZQU
*/
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			char[] input = br.readLine().toCharArray();
			
			System.out.println(Arrays.toString(input));
		}
		
/*
5
1 2 3 4 5
6 7 8 9 0
1 2 3 4 5
6 7 8 9 0
1 2 3 4 5
*/
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			int[][] input = new int[N][N];
			
			for (int i = 0; i < N; i++) { // 행
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) { // 열
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) { // 행
				System.out.println(Arrays.toString(input[i]));
			}
		}
		
/*
3 5
1 2 3 4 5
6 7 8 9 0
1 2 3 4 5
*/
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine()); // "3 5"
			int N = Integer.parseInt(st.nextToken()); // 3
			int M = Integer.parseInt(st.nextToken()); // 5
			
			int[][] input = new int[N][M];
			
			for (int i = 0; i < N; i++) { // 행
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) { // 열
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) { // 행
				System.out.println(Arrays.toString(input[i]));
			}
		}

/*	첫 줄에 테스트 케이스 개수 (3), 둘째줄부터 테스트케이스, 각 테스트케이스는 첫 줄에 N, M, 이어지는 N개의 줄에 M개의 수가 주어진다.
3
2 2
1 2
6 7
3 5
1 2 3 4 5
6 7 8 9 0
1 2 3 4 5
2 1
8
9
*/
		{	
			// 파일을 통해 input 받기
			System.setIn(new FileInputStream("input.txt"));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
			
			for (int t = 1 ; t <= T; t++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int N = Integer.parseInt(st.nextToken());
				int M = Integer.parseInt(st.nextToken());
				
				int[][] input = new int[N][M];
				
				for (int i = 0; i < N; i++) {
					st = new StringTokenizer(br.readLine());
					for (int j = 0; j < M; j++) {
						input[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				
				// 출력
				System.out.println(t);
				
				for (int i = 0; i < N; i++) {
					System.out.println(Arrays.toString(input[i]));
				}
				
			}
		}
		
		// 알고리즘 문제 풀이 팁
		// 1. 디버거를 적극적으로 활용하자.
		// 2. 파일 입력을 적극적으로 활용하자.

	}

}
