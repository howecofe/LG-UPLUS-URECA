package ch03_검색알고리즘;

import java.util.Arrays;
import java.util.Scanner;

// 보초법을 이용한 선형 검색
public class SeqSearchSentinel {

	static int seqSearch(int[] a, int n, int key) { // key: 찾는 항목
		int i = 0;
		a[n] = key; // 보초(sentinel)! 맨 마지막 인덱스에 찾는 Key 추가
		
		while (true) {
			if (a[i] == key) break; // 중간에 찾던, 마지막에 찾던
			i++;
		}
		
		return i == n ? -1 : i; // i == n : 검색 실패
	}
	public static void main(String[] args) {
		// 사용자로부터 배열의 길이, 각 배열의 항목을 입력받고 검색하는 코드
		Scanner sc = new Scanner(System.in);
		
		System.out.print("요소 수 : ");
		int num = sc.nextInt();
		int[] x = new int[num + 1];
		
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
