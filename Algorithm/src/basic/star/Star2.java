package basic.star;

public class Star2 {

	public static void main(String[] args) {
		// 반복문 + 출력 + 반전 시점
		// 반전 : 정확히 반인 곳에서 공백 기준으로 점점 증가? 점점 감소? 판단 <= 밑으로 가면서
		// 옆으로(열) 가면서 공백 출력, 나머지 조건(전체 n 중 공백 뺀 만큼)에 별 출력
		
		int n = 7;
		int turnCnt = n / 2;
		int spaceCnt = 0;
		boolean spaceIncrease = true; // 공백 문자 수 증가/감소 판단
		
		for (int i = 0; i < n; i++) {
			// 리팩토링 대상 : 출력하지 않을 부분까지 따진다. (* 찍은 후에도 불필요하게 j가 n-1 까지 돈다.)
//			for (int j = 0; j < n; j++) {
//				if (j < spaceCnt) {
//					System.out.print(" ");
//				} else if (j < n - spaceCnt) {
//					System.out.print("*");
//				}
//			}
			
			// 리팩토링 1 : 출력할 부분까지만 따진다.
//			for (int j = 0; j < n - spaceCnt; j++) {
//				if (j < spaceCnt) {
//					System.out.print(" ");
//				} else {
//					System.out.print("*");
//				}
//			}
			
			// 리팩토링 2 : if 문을 체크하지 않도록 for문을 리니어하게 변경한다.
			for (int j = 0; j < spaceCnt; j++) {
				System.out.print(" ");
			}
			
			for (int j = spaceCnt; j < n - spaceCnt; j++) {
				System.out.print("*");
			}
			
			
			System.out.println();
			
			// 행 별 출력이 완료 => 공백 증가/감소 판단
			if (spaceIncrease) {
				spaceCnt++;
			} else {
				spaceCnt--;
			}
			
			if (spaceCnt == turnCnt) { // 다음 행부터 감소로 변경
				spaceIncrease = false;
			}
		}
		

		// 내가 짠 코드
//		for (int i = 0; i < n; i++) {
//			if (i <= n / 2) {
//				for (int j = 0; j < n - i; j++) {
//					
//					if (i > j) {
//						System.out.printf(" ");
//					} else {
//						System.out.printf("*");
//					}
//				}
//			} else {
//				for (int j = 0; j < i + 1; j++) {
//					if (j < n - i - 1) {
//						System.out.print(" ");
//					} else {
//						System.out.print("*");
//					}
//				}
//			}
//			System.out.println();
//		}
	}
}


//*******
// *****
//  ***
//   * 
//  *** i=4 j=0,1
// ***** i=5 j=0
//******* i=6 j=x

// i:0 / j:7 / 공백0
// i:1 / j:6 / 공백1
// i:2 / j:5 / 공백2
// i:3 / j:4 / 공백3

// i:4 / j:5 / 공백2 0,1 / 2,3,4
// i:5 / j:6 / 공백1 0 /2,3,4,5,6
// i:6 / j:7 / 공백0 x

// n - i - 1