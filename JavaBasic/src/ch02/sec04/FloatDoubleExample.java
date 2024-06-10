package ch02.sec04;

public class FloatDoubleExample {

	public static void main(String[] args) {
		// 정밀도 확인
		// 소수점을 포함한 실수는 기본 타입이 double
//		float var1 = 0.1234; // 간단한 실수 리터럴도 double로 인식하고 float가 담을 수 없다.
		float var1 = 0.123456789123456789f; // f, F
		double var2 = 0.123456789123456789f; // f, F
		double var3 = 0.123456789123456789; // no f, F
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
	}
}

// int, long, float, double <= 범위를 벗어나는 더 큰 정수 계산 및 표현, 소수점 계산 표현은 어떻게 해??? >
// => BigInteger, BigDecimal 클래스 <= 단점 : 정확. but 느리다. >