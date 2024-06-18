package ch18.sec04;

import java.io.FileWriter;
import java.io.Writer;

// 문자 입출력 스트림 (FileWriter)
public class WriterExample {

	public static void main(String[] args) throws Exception {
		// 문자
		Writer writer = new FileWriter("/Users/greta/Desktop/UPLUS/eclipse/workspace/test_source/test.txt");
		
		// char 한 글자
		char a = 'A';
		writer.write(a);
		
		char b = 'B';
		writer.write(b);
		
		// char 배열
		char[] array = {'C', 'D', 'E'};
		writer.write(array);
		
		// String
		writer.write("FGH");
		
		writer.flush();
		writer.close();
	}

}
