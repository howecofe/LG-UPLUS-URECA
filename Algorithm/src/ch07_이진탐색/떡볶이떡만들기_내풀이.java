package ch07_이진탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 떡볶이떡만들기_내풀이 {
	static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 풀이
        // 정렬
        Arrays.sort(arr);
        // 이진탐색
        int result = binarySearch(0, arr[arr.length - 1]);

        // 출력
        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static int binarySearch(int start, int end) {
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;

            if (getCutLen(mid) == M) return mid;
            else if (getCutLen(mid) < M) { // 잘린 떡의 길이가 필요한 길이 M보다 작은 경우 -> 더 잘라야 한다. -> 길이(mid) 감소
                end = mid - 1;
            } else { // 잘린 떡의 길이가 필요한 길이 M보다 큰 경우 -> 덜 잘라야 한다. -> 길이(mid) 증가
                start = mid + 1;
            }
        }
        return mid;
    }

    static int getCutLen(int n) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            // n보다 큰 떡을 잘라 합을 구한다.
            if (arr[i] > n) sum += arr[i] - n;
        }
        return sum;
    }
}
/*
4 6
19 15 10 17

15
 */
