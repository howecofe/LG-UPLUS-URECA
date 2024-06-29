package ch08_다이나믹프로그래밍;

public class 피보나치_재귀 {
	
	static long[] memoi = new long[100]; // 이미 계산된 것을 저장, 재활용

	public static void main(String[] args) {
		System.out.println(fibo(50));

	}

//	static long fibo(int x) {
//		System.out.println(x);
//		if (x == 1 || x == 2) return 1;
//		
//		return fibo(x - 1) + fibo(x - 2);
//	}
	
	static long fibo(int x) {
		System.out.println(x);
		if (x == 1 || x == 2) return 1;
		
		if (memoi[x] != 0) return memoi[x]; // 이미 계산된 것이 있으면 그것을 return
		
//		memoi[x] = fibo(x - 1) + fibo(x - 2);
		return memoi[x] = fibo(x - 1) + fibo(x - 2);
	}
}