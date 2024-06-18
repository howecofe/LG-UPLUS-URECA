package ch18.sec06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

// 보조 스트림 <문자 변환 스트림 : 바이트 -> 문자열>
// 사용 이유: 문자로 바로 입출력하므로 편리, 문자셋 종류 지정 가능 (인코딩 형식 제어)
public class CharacterConvertStreamExample {
	
	public static void main(String[] args) throws Exception {
		write("한글입니다.");
		String data = read();
		System.out.println(data);
	}
	
	public static void write(String str) throws Exception {
		OutputStream os = new FileOutputStream("/Users/greta/Desktop/UPLUS/eclipse/workspace/test_source/test.txt"); // byte stream
		Writer writer = new OutputStreamWriter(os, "utf-8"); // 문자열 stream <- 보조 스트림
		writer.write(str);
		
		writer.flush();
		writer.close();
	}
	
	public static String read() throws Exception {
		InputStream is = new FileInputStream("/Users/greta/Desktop/UPLUS/eclipse/workspace/test_source/test.txt"); // byte stream
		Reader reader = new InputStreamReader(is, "ms949"); // 문자열 stream <- 보조 스트림 
		
		char[] data = new char[100];
		int num = reader.read(data);
		reader.read(data);
		
		reader.close();
		
		return new String(data, 0, num);
	}
}
