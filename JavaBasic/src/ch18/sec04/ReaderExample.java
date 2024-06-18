package ch18.sec04;

import java.io.FileReader;
import java.io.Reader;

// 문자 입출력 스트림 (FileReader)
public class ReaderExample {

	public static void main(String[] args) throws Exception {
		Reader reader = new FileReader("/Users/greta/Desktop/UPLUS/eclipse/workspace/test_source/test.txt");
		
		// 한 문자씩 읽기
		while (true) {
			int data = reader.read();
			if (data == -1) break;
			System.out.print((char)data);
		}
		
		reader.close();
		
		System.out.println("\n------------");
		
		// 한 번에 읽기
		reader = new FileReader("/Users/greta/Desktop/UPLUS/eclipse/workspace/test_source/test.txt");
		
		char[] data = new char[1000];
		int num = reader.read(data);
		for (int i = 0; i < num; i++) {
			System.out.print(data[i]);
		}
		
		reader.close();
	}
	
}
