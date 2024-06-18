package ch18.sec02.ex02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// 입출력 스트림 : 바이트 출력 스트림 (FileOutputStream)
public class WriteExample {

	public static void main(String[] args) {
		
		try {
			OutputStream os = new FileOutputStream("/Users/greta/Desktop/UPLUS/eclipse/workspace/test_source/test2.db");
			
			byte[] array = {40, 50, 60, 70};
			
			os.write(array);
			
			// 자원 정리 및 반납
			os.flush();
			os.close();
			
		} catch(IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}

}
