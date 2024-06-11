package ch04.sec03;

public class SwitchExample2 {
	// switch expression java 12
	// lambda 처럼 화살표를 사용해서 구현
	public static void main(String[] args) {
		char ch = 'B';
		
//		switch(ch) {
//			case 'A' : System.out.println("A"); break;
//			case 'B' : System.out.println("B"); break;
//			case 'C' : System.out.println("C"); break;
//		}
		
		// break 문이 필요하지 않게 됨.
		switch(ch) {
			case 'A', 'B' -> {
				System.out.println("A");
			}
//			case 'B' -> {
//				System.out.println("B");
//			}
			case 'C' -> {
				System.out.println("C");
			}
		}

	}

}
