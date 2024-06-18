package ch18.sec07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

// 보조 스트림 <성능 향상 스트림 : BufferedInputStream, BufferedOutputStream>
public class BufferExample {

	public static void main(String[] args) throws Exception {
		// copy() 입출력 stream
		InputStream is = new FileInputStream("/Users/greta/Desktop/UPLUS/eclipse/workspace/test_source/test_video.mov");
		OutputStream os = new FileOutputStream("/Users/greta/Desktop/UPLUS/eclipse/workspace/test_source/test_video2.mov");
		
		// copy() 입출력 + buffer stream
		InputStream is2 = new FileInputStream("/Users/greta/Desktop/UPLUS/eclipse/workspace/test_source/test_video.mov");
		OutputStream os2 = new FileOutputStream("/Users/greta/Desktop/UPLUS/eclipse/workspace/test_source/test_video2.mov");
		
		BufferedInputStream bis = new BufferedInputStream(is2);
		BufferedOutputStream bos = new BufferedOutputStream(os2);
		
		long nonBufferTime = copy(is, os);
		System.out.println(nonBufferTime);
		
		long bufferTime = copy(bis, bos); // 훨씬 빠름 -> 성능 good
		System.out.println(bufferTime);
		
		is.close();
		os.close();
		
		bis.close();
		bos.close();
		is2.close();
		os2.close();
	}
	
	public static long copy(InputStream is, OutputStream os) throws Exception {
		long start = System.nanoTime();
		
		// 복사 작업
		while (true) {
			// 복사하려는 파일 읽어서 쓰기
			int data = is.read();
			if (data == -1) break;
			
			os.write(data);
		}
		
		long end = System.nanoTime();
		
		return end - start;
	}
}
