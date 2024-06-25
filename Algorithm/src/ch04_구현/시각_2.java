package ch04_구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 문자열로 처리하지 않고, 숫자로 처리하는 부분 OK 
// 시, 분, 초를 나누어서 따로 처리하는 부분 OK
public class 시각_2 {
	
	static int N, cnt;
	private static final int MAX_MINUTES_SECONDS = 60;
    private static final int TARGET_DIGIT = 3;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		
		long start = System.nanoTime();
		
		for (int h = 0; h <= N; h++) {
			if (h % 10 == 3) {
				cnt += MAX_MINUTES_SECONDS * MAX_MINUTES_SECONDS;
				continue;
			}
			
			for (int m = 0; m < MAX_MINUTES_SECONDS; m++) {
				if (m / 10 == 3 || m % 10 == 3) {
					cnt += MAX_MINUTES_SECONDS;
					continue;
				}
				
				for (int s = 0; s < MAX_MINUTES_SECONDS; s++) {
					if (s / 10 == 3 || s % 10 == 3) cnt++;
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
	
//	private static boolean check(int number) {
//        while (number > 0) {
//            if (number % 10 == TARGET_DIGIT) {
//                return true;
//            }
//            number /= 10;
//        }
//        return false;
//    }

}
