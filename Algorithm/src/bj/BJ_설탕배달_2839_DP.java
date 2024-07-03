package bj;

import java.util.Arrays;
import java.util.Scanner;

// DP
public class BJ_설탕배달_2839_DP {
	
	static int N;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        // 초기 값 처리
        if( N <= 5 ) {
            if( N == 3 || N == 5 ) System.out.println(1);
            else System.out.println(-1);
            return;
        }
        
        dp = new int[N + 1]; // 1kg 부터 시작
        Arrays.fill(dp, 5000); // 충분히 큰 값으로 설정하고 시작
        
        // 3, 5 kg 설정
        dp[3] = 1;
        dp[5] = 1;
        
        for (int i = 6; i <= N; i++) {
            dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
        }
		
        if( dp[N] == 5000 ) {
            System.out.println(-1);
        }else {
            System.out.println(dp[N]);
        }
	}
}
