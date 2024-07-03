package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BJ_설탕배달_2839_내풀이_DP {
	static int N;
    static int[] memoi = new int[5001];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        N = Integer.parseInt(br.readLine());

        // 풀이: DP
        // 3 : 1, 4: -1, 5
        for (int i = 1; i <= 5000; i++) {
        	if (i % 5 == 0) memoi[i] = memoi[i - 5] + 1;
        	else if (i % 5 != 0) {
        		
        		
        	} else if (i % 3 == 0) memoi[i] = memoi[i - 3] + 1;
        	else if (i % 3 != 0) {
        		
        	} else memoi[i] = -1;
        }
        
        // 출력
        bw.write(memoi[N] + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
