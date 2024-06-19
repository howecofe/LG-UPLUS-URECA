package singleton;

public class Test {

	public static void main(String[] args) {
//		Logger logger = new Logger();
//		Logger logger2 = new Logger();
		
		// 객체를 만들던가 -> private 생성자라 불가
		// static으로 가져오던가
		Logger logger = Logger.getInstance(); // static method
		System.out.println(logger);
		logger.log("첫 번째 로그입니다.");
		
		m();
	}
	
	public static void m() {
		Logger logger = Logger.getInstance(); // static method
		System.out.println(logger);
		logger.log("두 번째 로그입니다.");
	}

}
