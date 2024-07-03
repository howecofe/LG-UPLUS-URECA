package basic.subset;

// 부분집합은 조합의 합 (공집합 포함)
// selected 배열을 parameter 화
// selected 배열 대신 bit-masking 사용
// <<, &, |
public class SubsetParam_BitMasking {

	static int[] src = {1, 2, 3, 4, 5};
	
	public static void main(String[] args) {
//		boolean[] selected = new boolean[src.length];
		subset(0, 0); // 첫번째 0: index, 두번째 0: mask
	}

	static void subset(int srcIdx, int mask) { // mask <- select 대체
		// 기저 조건
		if (srcIdx == src.length) {
			printSubset(mask);
			return;
		}
		
		// 현재 srcIdx 에 대해서 선택, 비선택 이어간다.
		subset(srcIdx + 1, mask | 1 << srcIdx); // mask의 bit 표현 중 srcIdx 자리를 1로 변경
		subset(srcIdx + 1, mask);
	}
	
	static void printSubset(int mask) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < src.length; i++) {
			if ((mask & 1 << i) != 0 ) sb.append(src[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}
