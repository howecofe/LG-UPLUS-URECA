package ch04_구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 시각 {
	
	private static final int MAX_MINUTES_SECONDS = 60;
    private static final int TARGET_DIGIT = 3;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		long start = System.nanoTime();
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < MAX_MINUTES_SECONDS; j++) {
				for (int k = 0; k < MAX_MINUTES_SECONDS; k++) {
					if (check(i, j, k)) cnt++;
				}
			}
		}
		
		long end = System.nanoTime();
		
		bw.write(cnt + "");
		bw.write("\n" + (end - start) + "");
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static boolean check(int h, int m, int s) {
		if (h % 10 == TARGET_DIGIT
				|| m / 10 == TARGET_DIGIT || m % 10 == TARGET_DIGIT
				|| s / 10 == TARGET_DIGIT || s % 10 == TARGET_DIGIT) return true;
		
		return false;
	}
	
	private static boolean containsDigit(int number) {
        while (number > 0) {
            if (number % 10 == TARGET_DIGIT) {
                return true;
            }
            number /= 10;
        }
        return false;
    }

}
