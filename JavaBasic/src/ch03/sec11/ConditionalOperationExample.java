package ch03.sec11;

public class ConditionalOperationExample {

	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		int z;
		
//		x++;
//		++x;
//		System.out.println(x++); // x++: 출력 후 증가해서 13, ++x : 출력 전 증가해서 13
//		System.out.println(x);
		
		if (++x == 10 & ++y == 10) {
			System.out.println("1");
			System.out.printf("x = %d, y = %d", x, y);
		} else {
			System.out.println("2");
			System.out.printf("x = %d, y = %d", x, y);
		}

	}

}
