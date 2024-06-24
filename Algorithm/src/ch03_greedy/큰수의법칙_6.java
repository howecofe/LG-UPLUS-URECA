package ch03_greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// BufferedReader + static + FileInputStream
// 테케 입력을 파일로 처리
// 가장 큰 수와 다음 큰 수(가장 큰 수 다음 큰 수가 동일할 수 있다.)
public class 큰수의법칙_6 {
	static int n, m, k, result;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M, K를 공백을 기준으로 구분하여 입력 받기
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());;

        // N개의 수를 공백을 기준으로 구분하여 입력 받기
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        Arrays.sort(arr); // 입력 받은 수들 정렬하기 O(NlogN)
        
        // O(N)
	    int first = first(); // 가장 큰 수
	    int second = second(); // 두 번째로 큰 수
        
        // 가장 큰 수가 더해지는 횟수 계산
        int cnt = (m / (k + 1)) * k + (m % (k + 1));
        result = first * cnt + second * (m - cnt);
        
        bw.write(result + "");
        
        br.close();
        bw.flush();
        bw.close();

	}
	
	static int first() {
		int first = 0; // max
		int firstIndex = 0;
		
		for (int i = 0; i < n; i++) { // 가장 큰 수가 중복되어도 맨 앞의 수가 가장 큰 수로 처리되도록.
			if (arr[i] > first) {
				first = arr[i];
				firstIndex = i;
			}
		}
		
		arr[firstIndex] = 0;
		
		return first;
	}
	
	static int second() {
		int second = 0;
		
		for (int i = 0; i < n; i++) {
			if (arr[i] > second) {
				second = arr[i];
			}
		}
		
		return second;
	}

}

/*
5 8 3
2 4 5 4 6

46
*/