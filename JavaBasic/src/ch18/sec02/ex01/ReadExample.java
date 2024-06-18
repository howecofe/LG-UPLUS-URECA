package ch18.sec02.ex01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

// 입출력 스트림 : 바이트 입력 스트림 (FileInputStream)
public class ReadExample {

	public static void main(String[] args) {
		
		try {
			InputStream is = new FileInputStream("/Users/greta/Desktop/UPLUS/eclipse/workspace/test_source/test1.db");
			
			// 3개 write 한 것을 알고 있는 경우
//			byte a = (byte)is.read();
//			byte b = (byte)is.read();
//			byte c = (byte)is.read();
			
//			System.out.println(a);
//			System.out.println(b);
//			System.out.println(c);
			
			// 몇 개인지 모르는 경우
//			while (true) {
//				int data = is.read();
//				
//				if (data == -1) break; // 스트림의 끝에 도달하면 -1을 반환
//				
//				System.out.println(data);
//			}
			
			// 자원 정리 및 반납
			is.close();
			
		} catch(IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

}
