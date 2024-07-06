package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2961
public class BJ_도영이가만든맛있는음식_2961_DFS {
	static int N, min;
	static int[][] src; // 재료 (신, 쓴)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        N = Integer.parseInt(br.readLine()); // 재료 수
        src = new int[N][2];
        
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            src[i][0] = Integer.parseInt(st.nextToken());
            src[i][1] = Integer.parseInt(st.nextToken());
        }
     
        // 풀이
        min = Integer.MAX_VALUE;
        dfs(0, 1, 0); // 첫 번째 재료부터 시작
  
        // 출력
        bw.write(min + "");

        br.close();
        bw.flush();
        bw.close();
    }

    // dfs 로 푸는 것은 호출된 시점에 문제 풀이의 일부가 계속 계산되어서 다음 단계에 넘어가야 한다.
    static void dfs(int srcIdx, int sinMul, int ssnSum) { // 현 단계 이전까지의 신맛의 곱, 쓴맛의 합
    	// 기저조건
    	if (srcIdx == N) return;
    	
    	// 매 단계마다 신맛 쓴맛 계산
    	int currSin = src[srcIdx][0] * sinMul;
    	int currSsn = src[srcIdx][1] + ssnSum;
    	
    	min = Math.min(min, Math.abs(currSin - currSsn));
    	
    	// 현재 재료를 선택하고 계속 가는 경우
    	dfs(srcIdx + 1, currSin, currSsn);
    	// 현재 재료를 선택하지 않고 계속 가는 경우
    	dfs(srcIdx + 1, sinMul, ssnSum);
    	
    }
}
