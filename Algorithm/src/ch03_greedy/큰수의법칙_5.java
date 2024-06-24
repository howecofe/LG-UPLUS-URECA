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
public class 큰수의법칙_5 {
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

        Arrays.sort(arr); // 입력 받은 수들 정렬하기 O(NlogN)
        int first = arr[n - 1]; // 가장 큰 수
        int second = arr[n - 2]; // 두 번째로 큰 수
        

        // 정렬 없이 반복문으로 큰 수 2개 찾기, O(N)
//        int count = 0;
//        int first = 0, second = 0;
//        boolean isFirst = true;
//        
//        while (count < 2) {
//        	count++;
//        	int max = 0, maxIdx = 0;
//        	
//        	for (int i = 0; i < n; i++) {
//            	if (max < arr[i]) {
//            		max = arr[i];
//            		maxIdx = i;
//            		
//            		if (isFirst) first = max;
//            		else second = max;
//            	}
//            }
//        	
//        	arr[maxIdx] = -1;
//        	isFirst = false;
//        }
        
        // 가장 큰 수가 더해지는 횟수 계산
        int cnt = (m / (k + 1)) * k + (m % (k + 1));
        result = first * cnt + second * (m - cnt);
        
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