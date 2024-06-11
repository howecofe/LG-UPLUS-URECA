package ch04.sec03;

public class SwitchExample {
	
	public static void main(String[] args) {
//		int num = (int)(Math.random()* 6) + 1; // 주사위 하나 뽑기
		int num = 2;
		
		switch(num) {
			case 1 : System.out.println("1번"); break;
			case 2 : System.out.println("2번");
			case 3 : System.out.println("3번");
			case 4 : System.out.println("4번"); 
			case 5 : System.out.println("5번"); break;
			case 6 : System.out.println("6번"); break;
			default : System.out.println("default 번");
		}
		
		String str = "2"; 
		
		switch(str) { // java15부터 문자열도 가능하다.
			case "1" : System.out.println("1번");
			case "2" : System.out.println("2번");
			case "3" : System.out.println("3번"); break;
			default : System.out.println("default 번");
		}
		
		char ch = 'B';
		
		switch(ch) {
			case 'A' : System.out.println("A"); break;
			case 'B' : System.out.println("B"); break;
			case 'C' : System.out.println("C"); break;
//			case 65 : System.out.println("65"); break; // Duplicate Case : 'A'와 중복
		}

	}

}
