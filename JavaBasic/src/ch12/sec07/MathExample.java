package ch12.sec07;

public class MathExample {

	// Math 클래스 : min, max, abs
	public static void main(String[] args) {
		
		int a = 10;
		int b = 20;
		int c = 30;
		
		System.out.println(Math.max(Math.max(a, b), c));
		System.out.println(Math.min(Math.min(a, b), c));
		
		int x1 = 20;
		int y1 = 100;
		int x2 = 100;
		int y2 = 50;
		
		// 맨해튼 거리
		int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
		System.out.println(dist);
		
	}

}
