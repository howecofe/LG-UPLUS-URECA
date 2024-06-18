package ch18.sec02.ex02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//입출력 스트림 : 바이트 입력 스트림 (FileInputStream)
public class ReadExample {

	public static void main(String[] args) {
		
		try {
			InputStream is = new FileInputStream("/Users/greta/Desktop/UPLUS/eclipse/workspace/test_source/test2.db");

			// byte 배열 준비 <- 이 곳에 stream 저장
			byte[] data = new byte[100];
		
//			while (true) {
//				int num = is.read(data);
//				
//				if (num == -1) break; // 스트림의 끝에 도달하면 -1을 반환
//				
//				for (int i = 0; i < num; i++) {
//					System.out.println(data[i]);
//				}
//			}
			
			int num = is.read(data); // 4 <- 읽은 byte 배열의 크기(파일에 실제 저장된 byte 데이터)
			for (int i = 0; i < num; i++) {
				System.out.println(data[i]);
			}
			
			// 자원 정리 및 반납
			is.close();
			
		} catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch(IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}

}
