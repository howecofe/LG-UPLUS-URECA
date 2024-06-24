package ch03_greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1이될때까지_내풀이 {

	static int n, k, result;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		while (n >= k) {
			if (n % k == 0) {
				result++;
				n /= k;
			} else { // n이 k의 배수가 되도록 빼기
				result += n % k;
				n -= n % k;
			}
		}
		
		// if (n < k) : n이 더 이상 k로 나누어 떨어지지 않을 때
		result += n - 1;
		
		bw.write(result + "");
		
		br.close();
		bw.flush();
		bw.close();
	}
	
}
