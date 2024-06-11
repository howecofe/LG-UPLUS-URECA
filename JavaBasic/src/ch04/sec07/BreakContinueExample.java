package ch04.sec07;

import java.util.Iterator;

public class BreakContinueExample {

	public static void main(String[] args) {
		// break 5 만나면 종료
		for (int i = 0; i < 10; i++) {
			if (i == 5) break;
			
			System.out.println(i);
		}
		
		System.out.println("-------------------");
		
		// continue 5 만나면 skip
		for (int i = 0; i < 10; i++) {
			if (i == 5) continue;
			
			System.out.println(i);
		}
		
		System.out.println("-------------------");
		
		// nested
		for (int i = 0; i < 10; i++) {
			if (i == 5) continue;
			for (int j = 0; j < 10; j++) {
				System.out.print(i + " " + j + "  ");
			}
			System.out.println();
		}
		
		System.out.println("-------------------");
		
		for (int i = 0; i < 10; i++) {
//			if (i == 5) break;
			for (int j = 0; j < 10; j++) {
				if (j == 5) break;
				System.out.print(i + " " + j + "  ");
			}
			System.out.println();
		}
		
		System.out.println("-------------------");
		
		Outer: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 5) break Outer;
				System.out.print(i + " " + j + "  ");
			}
			System.out.println();
		}
	}
}