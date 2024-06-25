package ch04_구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// <리팩토링>
// BufferedReader, static
// String[] plans -> char[] 
// moveTypes, delta 제거 : switch 변경
// x <-> y
// plans 배열의 필요성 ?? 

import java.util.StringTokenizer;

public class 상하좌우_2 {
	
	static int n;
	static char[] plans;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N을 입력받기
        n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = st.countTokens();
        plans = new char[count];
        		
        for (int i = 0; i < count; i++) {
        	plans[i] = st.nextToken().charAt(0);
        }
        
        // 풀이
        int y = 1, x = 1;

        // L, R, U, D에 따른 이동 방향
        // 이동 계획을 하나씩 확인
        for (int i = 0; i < count; i++) {
        	int ny = y;
        	int nx = x;
        	
        	switch (plans[i]) {
	        	case 'L': nx--; break;
	        	case 'R': nx++; break;
	        	case 'U': ny--; break;
	        	case 'D': ny++; break;
        	}
        	
        	// 공간을 벗어나는 경우 무시 
        	if (ny < 1 || nx < 1 || ny > n || nx > n) continue;
        	
        	// 이동 수행
        	y = ny;
        	x = nx;
        }

        bw.write(y + " " + x);
        
        br.close();
        bw.flush();
        bw.close();
    }
}

/*
5
R R R U D D

3 4
*/