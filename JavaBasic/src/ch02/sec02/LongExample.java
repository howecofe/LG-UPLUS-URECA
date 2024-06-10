package ch02.sec02;

public class LongExample {

	public static void main(String[] args) {
		long var1 = 10; // 10은 int value
		long var2 = 20L; // ~~L은 long value
//		long var3 = 100000000000; // 100000000000을 int value로 인식하는데, int 값의 범위를 넘기 때문에 컴파일 에러 발생. -> L 붙어야 해결
		long var4 = 100000000000L; // 소문자 l도 가능
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var4);
	}

}
