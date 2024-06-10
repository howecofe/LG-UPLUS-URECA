package ch02.sec07;

public class PromotionExample {

	// 자동 형변환 : byte > short, char > int > long > float > double
	public static void main(String[] args) {
		byte b1 = 10;
		int i1 = b1; // byte -> int
		System.out.println(i1);
		
		char c1 = '가';
		int i2 = c1; // char -> int
		System.out.println(i2); // '가'에 대응되는 유니코드 숫자 출력
		
		int i3 = 100;
		long l1 = i3; // int -> long
		System.out.println(l1);
		
		float f1 = 100.0f;
		double d1 = f1; // float -> double
		System.out.println(d1);
		
		float f2 = i3; // int -> float
		System.out.println(f2);
	}

}
