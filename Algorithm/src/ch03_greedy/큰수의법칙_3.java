package ch03_greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// BufferedReader 사용
public class 큰수의법칙_3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M, K를 공백을 기준으로 구분하여 입력 받기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());;

        // N개의 수를 공백을 기준으로 구분하여 입력 받기
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 입력 받은 수들 정렬하기
        int first = arr[n - 1]; // 가장 큰 수
        int second = arr[n - 2]; // 두 번째로 큰 수
        
        // 가장 큰 수가 더해지는 횟수 계산
        int cnt = (m / (k + 1)) * k + (m % (k + 1));
        int result = first * cnt + second * (m - cnt);
        
        bw.write(result + "");
        
        br.close();
        bw.flush();
        bw.close();

	}

}

/*
5 8 3
2 4 5 4 6

46
*/