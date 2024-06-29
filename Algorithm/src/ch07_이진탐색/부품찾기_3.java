package ch07_이진탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Arrays.binarySearch() API
public class 부품찾기_3 {

	static int n, m;
	static int[] arr, targets;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 입력
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        m = Integer.parseInt(br.readLine());
        targets = new int[m];
        
        // targets 배열을 굳이 만들 필요 X. 입력 받으면서 바로 검색하고 결과를 sb 에 넣어도 된다.
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
        	targets[i] = Integer.parseInt(st.nextToken());
        }
        
        // 풀이
        // 정렬
        Arrays.sort(arr);
        
        // 이진탐색
        for (int i = 0; i < targets.length; i++) {
        	int result = Arrays.binarySearch(arr, targets[i]);
        	
        	if (result >= 0) sb.append("yes ");
        	else sb.append("no "); // 음수이면 못찾은 것
        }
        
        // 출력
        bw.write(sb.toString());
        
        br.close();
        bw.flush();
        bw.close();
	}

}

/*
5
8 3 7 9 2
3
5 7 9

no yes yes
 */
