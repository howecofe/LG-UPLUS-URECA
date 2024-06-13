package ch11.sec06;

// 사용자 정의 예외 : 비즈니스 로직상 필요한 논리적인 예외
public class InsufficientException extends Exception {
	
    private static final long serialVersionUID = 1L;

	public InsufficientException() {}
    
	// 필수! 부모 클래스(Exception)의 생성자 호출하면서 message 를 전달해야 한다.
    public InsufficientException(String message) {
        super(message);
    }
}
