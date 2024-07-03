package basic.subset;

// bit 연산
public class BitMaskingTest {

	public static void main(String[] args) {
		// << 연산
		System.out.println(1 << 1); // 2 (0001 -> 0010)
		System.out.println(2 << 3); // 0010 -> 10000
		System.out.println(3 << 2); // 0011 -> 1100
		
		// &, | 연산
		System.out.println(3 & 1); // 0011 & 0001 == 0001
		System.out.println(3 | 1); // 0011 | 0001 == 0011
		
		// &, << 연산 : << 우선 적용
		System.out.println(3 | 1 << 2); // 0011 | 0100 == 0111 
		System.out.println(3 & 1 << 2); // 0011 & 0100 == 0000
		System.out.println(3 & 1 << 1); // 0011 & 0010 == 0010
		System.out.println(7 & 1 << 1); // 0111 & 0010 == 0010
		System.out.println(7 | 1 << 3); // 0111 | 1000 == 1111
		
		// 정리
		// a & 1 << b 의 의미: a를 bit로 표현하면 a 의 b 자리가 1인지 0인지 알 수 있다.(맨 오른쪽이 0)
		// 그 결과가 0이면 그 자리가 0, 0이 아니면 1이다.
		// => 특정 자리의 bit 값을 알고 싶을 때 사용
		
		
		// a | 1 << b 의 의미: a를 bit로 표현하면 a 의 b 자리를 1로 변경함을 알 수 있다.
		// => 특정 자리의 bit 값을 1로 바꾸고 싶을 때 사용

	}

}
