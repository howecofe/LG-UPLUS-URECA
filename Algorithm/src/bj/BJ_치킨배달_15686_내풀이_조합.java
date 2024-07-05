package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_치킨배달_15686_내풀이_조합 {
	static int N, M;
    static int result = Integer.MAX_VALUE;
    static List<int[]> home = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();  // src
    static int[][] target; // target
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        target = new int[M][2];

        // 입력 처리하면서 집, 치킨집 좌표를 자료구조에 넣는다.
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) home.add(new int[]{i, j});
                else if (num == 2) chicken.add(new int[]{i, j});
            }
        }

        // 풀이
        // 1. 치킨집 전체 개수에서 M개 고르는 조합을 구한다.
        // 2. 조합 하나가 완성되면 (기저 조건 내에서) -> 모든 집에 대해 도시의 치킨거리(치킨거리 합)를 구한다.
        // 3. 도시의 치킨거리 중 최솟값을 출력한다. (result)

        comb(0, 0);

        // 출력
        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static void comb(int srcIdx, int tgtIdx) {
        // 기저 조건
        if (tgtIdx == target.length) {
            // 치킨집 조합 1개 완성
            // 도시의 치킨 거리 구하기
            result = Math.min(result, getDistance());
            return;
        }
        if (srcIdx == chicken.size()) return;

        target[tgtIdx][0] = chicken.get(srcIdx)[0]; // y좌표
        target[tgtIdx][1] = chicken.get(srcIdx)[1]; // x좌표

        comb(srcIdx + 1, tgtIdx + 1); // 선택
        comb(srcIdx + 1, tgtIdx); // 비선택
    }

    static int getDistance() {
        int dist = 0;
        for (int[] h : home) {
            int min = Integer.MAX_VALUE;
            for (int[] t : target) {
                min = Math.min(min, Math.abs(h[0] - t[0]) + Math.abs(h[1] - t[1]));
            }
            dist += min;
        }

        return dist;
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
