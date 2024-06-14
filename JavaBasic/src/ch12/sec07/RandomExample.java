package ch12.sec07;

import java.util.Random;

public class RandomExample {

	// Math 클래스 : random()
	public static void main(String[] args) {
		// 1. Math.random() : 0.0 <= 값 < 1.0
		// 정수 랜덤 수를 만드는 데 귀찮은 코드를 작성
		
		// 대신 2. java.util.Random 클래스 객체 사용
		Random random = new Random(3); // seed
		for (int i = 0; i < 10; i++) {
			System.out.println(random.nextInt(6) + 1); // 1~6 랜덤 정수
		}

	}

}
