package basic.star;

public class Star1 {

	public static void main(String[] args) {
		// 반복문 + 출력
		int n = 5;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j < i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}

	}

}

// *****
//  ****
//   ***
//    **
//     *

// i 5번(rowCnt) / j 5번(colCnt) / 공백&별은 i에 따른 j의 변화를 조건식으로 표현

// i == j, i < j, i > j 구간별로 생각하기