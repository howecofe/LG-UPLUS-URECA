package ch02.sec02;

public class ByteExample {

	public static void main(String[] args) {
		// byte : 1byte => -128 ~ 127
		byte var1 = -128;
		byte var2 = -30;
		byte var3 = 0;
		byte var4 = 30;
		byte var5 = 127;
//		byte var6 = 128; // 컴파일 에러 발생. byte는 int(숫자 리터럴)를 담을 수 없다! ** 숫자 리터럴(하드코딩한 숫자)은 int로 인식한다!! **
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
		System.out.println(var4);
		System.out.println(var5);
	}

}
