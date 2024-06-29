package ch07_이진탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부품찾기_2 {

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
        for (int target : targets) {
        	int result = binarySearch(arr, target, 0, n - 1);
        	
        	if (result != -1) sb.append("yes ");
        	else sb.append("no ");
        }
        
        // 출력
        bw.write(sb.toString());
        
        br.close();
        bw.flush();
        bw.close();
	}
	
	// 특정 배열에서 원하는 값의 index를 return, 없으면 -1 리턴 <= 이진 탐색으로 처리
	static int binarySearch(int[] arr, int target, int start, int end) {
		while (start <= end) {
			int mid = (start + end) / 2; // 중간값
			
			if (arr[mid] == target) return mid; // 중간값과 찾는 값 일치 (찾았다.)
			else if (arr[mid] > target) { // 못찾았다. 중간값이 찾는 값보다 더 크다. -> 왼쪽에서 찾아야 한다.
				end = mid - 1;
			} else { // 못찾았다. 중간값이 찾는 값보다 더 작다. -> 오른쪽에서 찾아야 한다.
				start = mid + 1;
			}
		}
		return -1;
	}

}

/*
5
8 3 7 9 2
3
5 7 9

no yes yes
 */
