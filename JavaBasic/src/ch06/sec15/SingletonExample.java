package ch06.sec15;

public class SingletonExample {

	public static void main(String[] args) {
		// 싱글톤 패턴 적용 X (public 생성자)
//		Singleton st1 = new Singleton();
//		Singleton st2 = new Singleton();
//		Singleton st3 = new Singleton();
//		Singleton st4 = new Singleton();
//		System.out.println(st1 == st4); // false
		
		// 싱글톤 패턴 적용 O (private 생성자)
		Singleton st5 = Singleton.getInstance();
		Singleton st6 = Singleton.getInstance();
		System.out.println(st5 == st6); // true
	}

}
