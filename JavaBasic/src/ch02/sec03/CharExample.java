package ch02.sec03;

public class CharExample {

	public static void main(String[] args) {
		char c1 = 'A'; // 문자 저장
		char c2 = 65; // 유니코드 직접 저장
		
//		byte b1 = 65;
//		char c3 = b1; // 자동 형변환 안 된다. 컴파일 에러!
		
		char c3 = '가'; // 문자 저장
		char c나 = '나';
		char c5 = 44033; // 유니코드 직접 저장
		
		System.out.println(c1);
		System.out.println(c2);
//		System.out.println(b1);
		System.out.println(c3);
		System.out.println(c나);
		System.out.println(c5);
	}

}

// 기본타입 (Primitive Type) (<- 화학의 원자) ==> 처음부터 jvm이 고정된 길이의 메모리 공간을 확보한다.
// byte, short, char, int, long <- 정수형
// float, double <- 실수형(소수점 표현)
// boolean <- 논리형
// 자바의 모든 데이터는 [기본타입 + 배열]로 표현

// 참조타입 (Reference Type) (<- 화학의 원자 + 분자) ==> 처음부터 jvm이 고정된 길이의 메모리 공간을 확보하지 못한다.