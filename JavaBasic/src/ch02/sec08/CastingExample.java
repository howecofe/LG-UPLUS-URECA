package ch02.sec08;

public class CastingExample {

	// 명시 형변환 (강제 타입 변환) : 큰 타입을 작은 타입으로
	public static void main(String[] args) {
		int var1 = 10000;
		byte var2 = (byte) var1; // byte : -128 ~ 127
		System.out.println(var2);
		
		int var3 = 65;
		char var4 = (char) var3;
		System.out.println(var4);
		
		double var5 = 3.141592;
		int var6 = (int) var5; // 정수부가 담긴다.
		System.out.println(var6);
		
		byte b1 = 10;
		byte b2 = 20;
		byte b3 = 10 + 20;
//		byte b4 = b1 + b2; // 컴파일 에러! byte, short가 피연산자 처리가 되면 int로 자동 형변환이 일어나기 때문에 int형으로 받아야 한다.
		int i1 = b1 + b2;
		
		System.out.println(b3);
		System.out.println(i1);
	}
}

// primitive type 으로 형변환 개념을 익히고 있지만, 실제로는 primitive type 의 형변환은 거의 사용 X.
// reference type 의 형변환이 중요!