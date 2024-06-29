package ch08_다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1로만들기_내풀이 {

	static int x;
	static int[] dp = new int[30001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        x = Integer.parseInt(br.readLine());
        
        // 목표 : x 를 1로 만들기
        // x = 1 이면 이미 1이므로 dp[1] == 0
        // 따라서 for 문은 2부터 시작
        for (int i = 2; i <= x; i++) {
        	dp[i] = dp[i - 1] + 1;
        	if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
        	if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        	if (i % 5 == 0) dp[i] = Math.min(dp[i], dp[i / 5] + 1);
        }
        
        bw.write(dp[x] + "");
        
        br.close();
        bw.flush();
        bw.close();
	}
}
