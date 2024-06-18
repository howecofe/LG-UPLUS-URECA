package ch18.sec02.ex01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// 입출력 스트림 : 바이트 출력 스트림 (FileOutputStream)
public class WriteExample {

	public static void main(String[] args) {
		
		try {
			OutputStream os = new FileOutputStream("/Users/greta/Desktop/UPLUS/eclipse/workspace/test_source/test1.db");
			
			byte a = 10;
			byte b = 20;
			byte c = 30;
			
			os.write(a);
			os.write(b);
			os.write(c);
			
			// 자원 정리 및 반납
			os.flush();
			os.close();
			
		} catch(IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}

}
