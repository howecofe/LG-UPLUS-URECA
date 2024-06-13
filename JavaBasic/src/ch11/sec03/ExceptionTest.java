package ch11.sec03;

// 다중 예외 처리
// 처리해야 할 예외 클래스들이 상속 관계에 있으면, 하위 클래스를 catch 블럭에 먼저 작성해야 한다! specific -> general
// general 예외를 먼저 catch 하면 Unreachable catch block 오류 발생
public class ExceptionTest {

	public static void main(String[] args) {
		
		String[] array = {"100", "200*"};
		
		// 다중 예외 처리
//		for (int i = 0; i <= array.length; i++) {
//			try {
//				int value = Integer.parseInt(array[i]);
//				System.out.println(value);
//			} catch(ArrayIndexOutOfBoundsException e) {
//				System.out.println("index 오류");
//			} catch(NumberFormatException e) {
//				System.out.println("숫자 문자열 오류");
//			} catch(Exception e) {
//				System.out.println("기타 예외 발생");
//			}
//		}
		
		// 예외 동시 처리
//		for (int i = 0; i <= array.length; i++) {
//			try {
//				String s = null;
//				s.length(); // NPE 발생
//				
//				int value = Integer.parseInt(array[i]);
//				System.out.println(value);
//			} catch(ArrayIndexOutOfBoundsException | NumberFormatException e) { // 예외 동시 처리
//				e.printStackTrace();
//			} catch(Exception e) {
//				System.out.println("기타 예외 발생");
//			}
//		}
		
	}
}

// Q. 그럼 RuntimeException 을 try-catch 로 처리하는 게 좋은건가?
// 좋지 않다고 생각. RuntimeException은 무조건 발생하면 안되기 때문에, RuntimeException이 발생할 것을 감안해서 try-catch로 처리하는 것은 말이 안된다.