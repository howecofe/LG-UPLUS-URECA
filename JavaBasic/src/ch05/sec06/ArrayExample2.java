package ch05.sec06;

public class ArrayExample2 {
	
	// 다차원 배열 : 1차원 배열의 연결
	public static void main(String[] args) {
//		int[] intArr1 = new int[4]; // 1차원 배열
//		int[][] intArr2 = new int[4][3]; // 2차원 배열
//		int[][][] intArr3 = new int[4][3][2]; // 3차원 배열
		
		int[] intArr1 = new int[4]; // 1차원 배열
		
		// 길이가 다른 1차원 배열을 참조하는 것이 가능하다.
		int[][] intArr2 = new int[4][]; // 2차원 배열
		intArr2[0] = new int[3];
		intArr2[2] = new int[10];
		
		int[][][] intArr3 = new int[4][][]; // 3차원 배열
	}

}