package basic.subset;

// 부분집합 (공집합 포함)
public class SubsetBasic {

	static int[] src = {1, 2, 3, 4, 5};
	static boolean[] selected = new boolean[src.length];
	
	public static void main(String[] args) {
		subset(0);
	}

	static void subset(int srcIdx) {
		// 기저 조건
		if (srcIdx == src.length) {
			printSubset();
			return;
		}
		
		// 현재 srcIdx 에 대해서 선택, 비선택 이어간다.
		selected[srcIdx] = true;
		subset(srcIdx + 1);
		
		selected[srcIdx] = false;
		subset(srcIdx + 1);
	}
	
	static void printSubset() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < selected.length; i++) {
			if (selected[i]) sb.append(src[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}
