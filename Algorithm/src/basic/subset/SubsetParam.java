package basic.subset;

// 부분집합은 조합의 합 (공집합 포함)
// selected 배열을 parameter 화
public class SubsetParam {

	static int[] src = {1, 2, 3, 4, 5};
	
	public static void main(String[] args) {
		boolean[] selected = new boolean[src.length];
		subset(0, selected);
	}

	static void subset(int srcIdx, boolean[] selected) {
		// 기저 조건
		if (srcIdx == src.length) {
			printSubset(selected);
			return;
		}
		
		// 현재 srcIdx 에 대해서 선택, 비선택 이어간다.
		selected[srcIdx] = true;
		subset(srcIdx + 1, selected);
		
		selected[srcIdx] = false;
		subset(srcIdx + 1, selected);
	}
	
	static void printSubset(boolean[] selected) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < selected.length; i++) {
			if (selected[i]) sb.append(src[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}
