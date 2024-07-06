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
public class BJ_도영이가만든맛있는음식_2961_binaryCounting {
	static int N, min;
	static int[][] src; // 재료 (신, 쓴)
	static boolean[] select;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        N = Integer.parseInt(br.readLine()); // 재료 수
        src = new int[N][2];
        select = new boolean[N];
        
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            src[i][0] = Integer.parseInt(st.nextToken());
            src[i][1] = Integer.parseInt(st.nextToken());
        }
     
        // 풀이
        min = Integer.MAX_VALUE;
  
//        int subsetCnt = 1 << N;
        int subsetCnt = (int)Math.pow(2,  N);
        
        
        for (int i = 1; i < subsetCnt; i++) { // 재료수 0은 제외 
        	int sin = 1;
        	int ssn = 0;
        	
        	for (int j = 0; j < N; j++) {
        		if ((i & (1 << j)) != 0) {
        			sin *= src[j][0];
        			ssn += src[j][1];
        		}
        	}
        	
        	min = Math.min(min, Math.abs(sin - ssn));
        }

        // 출력
        bw.write(min + "");

        br.close();
        bw.flush();
        bw.close();
    }
}

/*
1
3 10
==> 7
*/
