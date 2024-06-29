package ch08_다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 바닥공사_내풀이 {
	
	static int n;
	static int[] memoi;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        memoi = new int[n + 1];
        
        memoi[1] = 1;
        memoi[2] = 3;
        for (int i = 3; i <= n; i++) {
        	memoi[i] = (memoi[i - 1] + memoi[i - 2] * 2) % 796796;
//        	memoi[i] = (memoi[i - 2] * 3) % 796796;
        }
        
        bw.write(memoi[n] + "");
        
        br.close();
        bw.flush();
        bw.close();
	}
}
/*
3

5
*/