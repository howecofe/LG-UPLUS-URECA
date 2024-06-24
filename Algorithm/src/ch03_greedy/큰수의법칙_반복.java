package ch03_greedy;

import java.util.Arrays;
import java.util.Scanner;

// 주어지는 배열의 수 전체를 다 고려하지 않고, 가장 큰 수, 두 번쨰 큰 수만 고려
// 가장 큰 수, 두 번째 큰 수를 정렬을 통해 구함.
// 이후 코딩
//	방법 1. 반복 <- 하나씩 하나씩...
//	방법 2. 반복 미리 계산 <- 한꺼번에 계산 <= 교재 코드


// 방법 1
public class 큰수의법칙_반복 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // N, M, K를 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        // N개의 수를 공백을 기준으로 구분하여 입력 받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); // 입력 받은 수들 정렬하기
        int first = arr[n - 1]; // 가장 큰 수
        int second = arr[n - 2]; // 두 번째로 큰 수

        // m개가 될 때까지 가장 큰 수를 우선적으로 k번 사용 + 두번째 수 1번 사용 .... m번 더할 때까지
        int result = 0;
        int totalCnt = 0;
        int kCnt = 0;
        
        while (true) {
        	if (totalCnt == m) break; // 모든 숫자를 m번 사용
        	
        	if (kCnt == k) { // 현재 first를 k번 연속 사용한 상태 -> second 사용
        		result += second;
        		kCnt = 0;
        	} else {
        		result += first;
        		kCnt++;
        	}
        	
        	totalCnt++;
        }
        
        System.out.println(result);

	}

}

/*
5 8 3
2 4 5 4 6

46
*/