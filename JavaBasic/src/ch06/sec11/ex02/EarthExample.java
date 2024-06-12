package ch06.sec11.ex02;

public class EarthExample {
	// 정수의 최대값, 최소값
	static final int MAX = Integer.MAX_VALUE;
	static final int MIN;
	static {
		MIN = Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		System.out.println("지구의 반지름 : " + Earth.EARTH_RADIUS);

	}

}
