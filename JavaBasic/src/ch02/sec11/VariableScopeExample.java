package ch02.sec11;

public class VariableScopeExample {
	
	public static void main(String[] args) {
		int v1 = 10;
		int v2;
		
		if (v1 > 10) {
			v2 = v1 - 10;
			System.out.println(v2);
		} else {
			v2 = 20;
		}
		
		System.out.println(v2);
	}
}

// 로컬 변수는 반드시 사용 전에 값이 지정(초기화)되어 있어야 한다.