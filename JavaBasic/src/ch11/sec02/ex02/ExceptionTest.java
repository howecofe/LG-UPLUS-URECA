package ch11.sec02.ex02;

import java.io.IOException;

// 예외 처리 : throws, try-catch-finally
public class ExceptionTest {

	// 예외 처리 #1 : throws
//	public static void main(String[] args) throws ClassNotFoundException {
//		// ClassNotFoundException <= checked Exception : 호출하는 곳으로 예외를 수동으로 넘겨야 한다!
//		Class.forName("java.lang.String222"); // 파라미터로 전달한 클래스를 메모리에 강제 로드
//	}
	
	// 예외 처리 #2 : try-catch-finally
	public static void main(String[] args) {
		try {
			Class.forName("java.lang.String222");
		} catch (ClassNotFoundException e) {
//			System.out.println(e.getMessage());
			System.out.println("class를 찾을 수 없습니다.");
		} finally {
			System.out.println("finally");
		}
		
		try {
			MyMethod();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void MyMethod() throws IOException {
		// IO 작업을 하다가 IO 예외가 발생할 수 있다.
	}
}

// 예외는 처리되지 않으면 호출한 메소드로 넘어간다.
// => non-checked Exception (RuntimeException): throws 없이 자동으로 넘어감
// => checked Exception : 수동