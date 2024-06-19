package singleton;

import java.time.LocalDateTime;

// 싱글톤 패턴
// app 전체에서 Log 를 담당하는 클래스
// 이 클래스의 객체는 단 한개만 만들어서 사용되도록 한다.
public class Logger {
	
	// 1. 미리 만들어두는 방법 (1)
//	static {
//		// 미리 선 작업...
//		logger = new Logger();
//	}
	
	// 2. 미리 만들어두는 방법 (2)
//	private static Logger logger = new Logger();

	private static Logger logger; 

	// 생성자를 private 으로.
	private Logger() {}
	
	// static 메서드로 외부에서 객체를 얻을 수 있는 방법 제공
	public static Logger getInstance() {
		// 3. 메서드 호출하는 시점에 체크해서 만드는 방법
		if (logger == null) {
			logger = new Logger();
		}
		return logger;
	}
	
	public void log(String message) {
		LocalDateTime ldt = LocalDateTime.now();
		String date = ldt.getYear() + "/" + ldt.getMonthValue() + "/" + ldt.getDayOfMonth();
		String time = ldt.getHour() + ":" + ldt.getMinute() + ":" + ldt.getSecond();
		
		System.out.println("[" + date + " " + time + "] " + message);
	}
}
