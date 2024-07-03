package ch03_검색알고리즘;

import java.util.Arrays;
import java.util.Scanner;

// 선형 검색
public class SeqSearch {

	static int seqSearch(int[] a, int n, int key) { // key: 찾는 항목
		int i = 0;
		
		while (true) {
			if (i == n) return -1; // 못 찾았다.
			if (a[i] == key) return i; // 찾았다. 찾은 index return
			i++;
		}
	}
	public static void main(String[] args) {
		// 사용자로부터 배열의 길이, 각 배열의 항목을 입력받고 검색하는 코드
		Scanner sc = new Scanner(System.in);
		
		System.out.print("요소 수 : ");
		int num = sc.nextInt();
		int[] x = new int[num];
		
		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]: ");
			x[i] = sc.nextInt();
		}
		
		System.out.println(Arrays.toString(x));
		
		while (true) {
			System.out.print("검색할 값: ");
			int ky = sc.nextInt();
			if (ky == -1) break;
			
			int idx = seqSearch(x, num, ky);
			
			if (idx == -1) System.out.println("검색 실패");
			else System.out.println("검색 요소는 " + idx + "번째에 있습니다.");		
		}
		
		
	}

}
