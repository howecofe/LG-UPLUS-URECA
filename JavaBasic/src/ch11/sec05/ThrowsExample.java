package ch11.sec05;

import java.io.FileNotFoundException;
import java.io.IOException;

// 예외 떠넘기기 : throws
public class ThrowsExample {
	
	// main 메서드에서도 예외 throws 하면 JVM으로 예외가 떠넘겨진다.
	public static void main(String[] args) throws FileNotFoundException, IOException {
		A a = new A();
		a.ma();
	}
}
