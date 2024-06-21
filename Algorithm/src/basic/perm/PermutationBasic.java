package basic.perm;

import java.util.Arrays;

// 순열
// 5개 수 중 3개의 수로 만들 수 있는 순열의 종류, 그 구성
public class PermutationBasic {

	static int[] src = {1, 2, 3, 4, 5};
	static int[] tgt = new int[3];
	static boolean[] selected = new boolean[src.length]; // src 각 요소에 대한 이전 사용 여부
	
	public static void main(String[] args) {
		perm(0); // 첫 번째 자리를 채우면서 시작
	}

	static void perm(int tgtIdx) {
		// 기저 조건
		if (tgtIdx == tgt.length) {
			// 순열 한 가지가 완성
			System.out.println(Arrays.toString(tgt));
			return;
		}
		
		// tgtIdx 자리에 채울 수를 고려
		for (int i = 0; i < src.length; i++) {
			// tgtIdx 앞자리에 이미 사용된 수만 제외, 사용된 수는 selected 배열에 기록
			if (selected[i]) continue;
			
			// 현재 자리 채우기
			tgt[tgtIdx] = src[i];
			selected[i] = true;
			
			// 다음 자리 채우러 가기
			perm(tgtIdx + 1);
			
			selected[i] = false; // for문의 i가 이전 재귀호출에서 선택되어 고려되었으므로 다음 i를 고려하기 위해 i 선택 해제 
		}
	}
}
