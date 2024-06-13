package ch11.sec02.ex01;

// 예외 처리 : try ~ catch ~ finally
// catch 블럭으로 예외 처리하고 나면 다음 코드 수행. try 블럭에서 예외가 발생한 코드 다음은 실행되지 않는다.
public class ExceptionTest2 {

	public static void main(String[] args) {
		System.out.println("예외 테스트");
		
		try {
			printLength("java");
			String s = null;
			printLength(s); // java.lang.NullPointerException <= RuntimeException 계열 == non-checked Exception
		} catch(NullPointerException npe) {
			System.out.println(npe.getMessage());
		} finally { // 예외 발생 상관없이 무조건 실행되는 block
			System.out.println("finally block");
		}
	}
	
	public static void printLength(String data) {
		int result = data.length(); // data가 null이면 여기서 예외 발생 !! 이 메서드를 호출한 main 메서드로 예외가 넘어간다.
		System.out.println("문자 수: " + result);
	}

}

// 예외는 처리되지 않으면 호출한 메소드로 넘어간다.
// => non-checked Exception (RuntimeException): throws 없이 자동으로 넘어감
// => checked Exception : 수동