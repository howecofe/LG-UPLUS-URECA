package ch07_이진탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부품찾기_내풀이 {
    static int N, M;
    static int[] nArr;
    static int[] mArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // 입력
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        nArr = new int[N];
        for (int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        mArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        // 풀이 :이진탐색
        Arrays.sort(nArr); // 이진탐색을 위한 정렬

        for (int target : mArr) {
            if (binarySearch(target)) bw.write("yes" + " ");
            else bw.write("no" + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static boolean binarySearch(int target) {
        int start = 0;
        int end = N - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nArr[mid] == target) return true; // target 일치한 경우 -> 찾음!
            else if (nArr[mid] > target) { // target이 작은 경우 -> 왼쪽으로 범위 조정
                end = mid - 1;
            } else { // target이 더 큰 경우 -> 오른쪽으로 범위 조정
                start = mid + 1;
            }
        }

        return false;
    }

}
/*
5
8 3 7 9 2
3
5 7 9

no yes yes
 */