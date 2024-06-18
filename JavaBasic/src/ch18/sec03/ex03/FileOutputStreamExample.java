package ch18.sec03.ex03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileOutputStreamExample {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("/Users/greta/Desktop/UPLUS/eclipse/workspace/test_source/test_image.jpeg");
		OutputStream os = new FileOutputStream("/Users/greta/Desktop/UPLUS/eclipse/workspace/test_source/test_image2.jpeg");
		
//		byte[] data = new byte[1024]; // read 해서 담을 자료구조의 크기보다 파일이 클 때
//		while (true) {
//			int num = is.read(data);
//			if (num == -1) break;
//			os.write(data, 0, num);
//		}
		
		is.transferTo(os); // InputStream에서 전부 읽어서 OutputStream으로 넘겨라.
		
		os.flush();
		os.close();
		is.close();
	};
	
}
