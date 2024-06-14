package ch12.sec04;

public class NanoTimeTest {
	
	// System 클래스
	public static void main(String[] args) {
		// 수행시간 비교 테스트 시작
		long time1 = System.nanoTime();
		
		// 수행 코드
		int sum = 0;
		for (int i = 0; i < 10000000; i++) {
			sum += i;
		}
		
		// 수행시간 비교 테스트 끝
		long time2 = System.nanoTime();
		
		System.out.println("sum : " + sum);
		System.out.println("nano time 기준 소요시간 : " + (time2 - time1));
	}
}

// nano time 기준 소요시간 : 3572584
// nano time 기준 소요시간 : 6513792
