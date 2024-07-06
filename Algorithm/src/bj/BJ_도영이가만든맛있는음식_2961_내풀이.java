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
public class BJ_도영이가만든맛있는음식_2961_내풀이 {
	static int N;
    static Taste[] taste;
    static boolean[] selected;
    static class Taste {
        int s, b;
        Taste(int s, int b) {
            this.s = s;
            this.b = b;
        }
    }
    static List<Long> diffList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        N = Integer.parseInt(br.readLine());
        taste = new Taste[N];
        selected = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            taste[i] = new Taste(s, b);
        }

        // 풀이
        // 1개 이상의 재료를 사용, 신맛의 곱과 쓴맛의 합의 차이를 최소로 만들기
        // => 부분집합을 이용한 완전 탐색

        subset(0);
        Collections.sort(diffList);

        // 출력
        bw.write(diffList.get(0) + "");

        br.close();
        bw.flush();
        bw.close();
    }

    // 부분집합 구하기
    static void subset(int srcIdx) {
        // 기저 조건
        if (srcIdx == N) {
            getDiff();
            return;
        }

        // 선택
        selected[srcIdx] = true;
        subset(srcIdx + 1);

        // 비선택
        selected[srcIdx] = false;
        subset(srcIdx + 1);
    }

    // 신맛과 쓴맛 차이 구하기
    static void getDiff() {
        long mul = 1;
        long sum = 0;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (selected[i]) {
                mul *= taste[i].s;
                sum += taste[i].b;
                cnt++;
            }
        }

        if (cnt > 0) {
            diffList.add(Math.abs(mul - sum));
        }
    }
}
