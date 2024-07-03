package basic.subset;

// 부분집합은 조합의 합 (공집합 포함)
// 전체 부분집합을 bit 의 표현으로 단순화
public class SubsetParam_BinaryCounting {

	static int[] src = {1, 2, 3, 4, 5};
//	static int subsetCnt = 2 * 2 * 2 * 2 * 2;
	static int subsetCnt = 1 << src.length; // 0010 0000 : 32
	
	public static void main(String[] args) {
		for (int i = 0; i < subsetCnt; i++) { // 0 ~ 31
			// i 정체? 그냥 index?
			// 각각의 i는 부분집합의 한 경우를 의미
			// 0 ->  공집합   00000
			// 31 -> 전체집합  11111
			System.out.printf(i + "[%5s]", Integer.toBinaryString(i));
			System.out.println();
			
			StringBuilder sb = new StringBuilder();
			
			for (int j = 0; j < src.length; j++) {
				if ((i & 1 << j) != 0) sb.append(src[j]).append(" ");
			}
			
			System.out.println(sb);
		}
	}
}
