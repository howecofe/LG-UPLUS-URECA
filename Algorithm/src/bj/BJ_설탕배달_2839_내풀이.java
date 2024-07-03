package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BJ_설탕배달_2839_내풀이 {
	static int N, result;
    static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        N = Integer.parseInt(br.readLine());

        // 풀이
        if (N % 5 == 0) list.add(N / 5);
        else {
            for (int i = 1; i <= N / 5; i++) {
                int cnt = i;
                if ((N - 5 * i) % 3 == 0) {
                    cnt += (N - 5 * i) / 3;
                    list.add(cnt);
                }
            }
        }

        if (N % 3 == 0) list.add(N / 3);
        else {
            for (int i = 1; i <= N / 3; i++) {
                int cnt = i;
                if ((N - 3 * i) % 5 == 0) {
                    cnt += (N - 3 * i) / 5;
                    list.add(cnt);
                }
            }
        }

        if (list.isEmpty()) result = -1;
        else {
            list.sort(Comparator.naturalOrder());
            result = list.get(0);
        }

        // 출력
        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
