package ch11.sec05;

import java.io.FileNotFoundException;
import java.io.IOException;

// 의도적으로 예외 발생시키기 : throw new ~Exception(); -> throws
public class B {
	public void mb() throws IOException {
		C c = new C();
		
		try {
			c.mc();
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			throw new IOException(); // 의도적으로 예외 발생시키는 코드
		}
		
		// 예외처리
		// 1. 예외 잡아! try~catch
		// 2. 예외 넘겨! throws
	}
}
