package ch08_다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1로만들기 {

	static int x;
	static int[] memoi = new int[30001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        x = Integer.parseInt(br.readLine());
        
        for (int i = 2; i <= x; i++) {
            // 현재 수 i 를 만드는 최소 방법의 수를 찾는다.
            
            // 이전 수 중 + 1 => i
            memoi[i] = memoi[i - 1] + 1;
            
            // 이전 수 중 * 2 => i <= i 가 2 나누어 떨어 진다.
            if( i % 2 == 0 ) {
                memoi[i] = Math.min( memoi[i], memoi[i/2] + 1 );
            }
            
            // 이전 수 중 * 3 => i
            if( i % 3 == 0 ) {
                memoi[i] = Math.min( memoi[i], memoi[i/3] + 1 );
            }
            // 이전 수 중 * 5 => i
            if( i % 5 == 0 ) {
                memoi[i] = Math.min( memoi[i], memoi[i/5] + 1 );
            }
        }
        
        bw.write(memoi[x] + "");
        
        br.close();
        bw.flush();
        bw.close();
	}

}
