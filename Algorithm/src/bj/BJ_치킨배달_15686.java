package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 조합
// 집, 치킨집 별도의 자료구조 (ArrayList)
public class BJ_치킨배달_15686 {
	static int N, M, houseSize, srcSize, min;
	static List<int[]> house, src, tgt;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        house = new ArrayList<>(); // 집
        src = new ArrayList<>(); // 치킨집
        tgt = new ArrayList<>(); // 선택된 치킨집

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) house.add(new int[]{i, j});
                else if (num == 2) src.add(new int[]{i, j});
            }
        }

        // 풀이
        min = Integer.MAX_VALUE;
        houseSize = house.size();
        srcSize = src.size();

        comb(0, 0);

        // 출력
        bw.write(min + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static void comb(int srcIdx, int tgtIdx) {
        // 기저 조건
        if (tgtIdx == M) {
        	// complete code
        	// 현재 M개의 치킨집을 선택한 상태(tgt)
        	// 마을 전체의 치킨거리 중 최소
            // 모든 집에 대해서 가장 가까운 치킨집까지의 거리를 계산 후 모두 더하고 그것을 min과 비교 선택
        	
        	int sum = 0; // 조합 1개에 대한 도시의 치킨거리
        	for (int i = 0; i < houseSize; i++) { // 각각의 집에 대해서
        		int minDist = Integer.MAX_VALUE;
        		
        		int[] h = house.get(i); // 현재 고려하는 집
        		for (int j = 0; j < M; j++) {
        			int[] c = tgt.get(j);
        			minDist = Math.min(minDist, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
        		}
        		sum += minDist;
        	}
        	
        	min = Math.min(min, sum); // 도시의 치킨거리 중 최솟값
        	
            return;
        }
        
        if (srcIdx == srcSize) return;

        // 선택
        tgt.add(src.get(srcIdx));
        comb(srcIdx + 1, tgtIdx + 1);
        
        // 비선택
        tgt.remove(src.get(srcIdx));
        comb(srcIdx + 1, tgtIdx);
    }
}
/*
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2
==> 5
*/
