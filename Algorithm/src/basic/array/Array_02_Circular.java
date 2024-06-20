package basic.array;

// 배열 순회 관련 알고리즘 문제
public class Array_02_Circular {

	public static void main(String[] args) {
		char[] input = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		int n = input.length;
		
		for (int i = 0; i < n * 2; i++) {
			System.out.println(input[i % n]);
		}
		
		System.out.println("---------");
		
		// 10번째 문자 출력
		int order = 10;
		System.out.println(input[(order - 1) % n]);
		
		System.out.println("---------");
		
		// 반복 횟수를 정확히 알 수 없을 때
		int count = 0;
		int i = 2; // 2번째 요소부터
		int finish = 20; // 20개 출력
		
		while (true) {
			if (count == finish) break;
			System.out.print(input[i % n]);
			count++;
			i++;
		}
	}

}