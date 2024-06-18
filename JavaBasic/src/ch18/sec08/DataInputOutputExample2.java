package ch18.sec08;

import java.io.DataInputStream;
//import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

// 보조 스트림 <기본 타입 스트림 : DataInputStream, DataOutputStream> 
// 기본 타입 9개 + String 타입
public class DataInputOutputExample2 {

	public static void main(String[] args) {
		// write
//		OutputStream os = new FileOutputStream("primitive.db");
//		DataOutputStream dos = new DataOutputStream(os);
//		
//		dos.writeUTF("홍길동"); // String
//		dos.writeDouble(99.1); // double
//		int num = 100;
//		dos.writeInt(num); // int
//		
//		dos.writeUTF("이길동");
//		dos.writeDouble(89.0);
//		num = 200;
//		dos.writeInt(num);
//		
//		dos.flush();
//		dos.close();
//		os.close();
//		
		// read
//		InputStream is = null;
//		DataInputStream dis = null;
		
		// try with resources 구문
		// try() 안에서 선언, 생성된 resource 객체(AutoClosable 구현)는 자동으로 close()
		try (
			InputStream is = new FileInputStream("primitive.db");
			DataInputStream dis = new DataInputStream(is);
		){
			for (int i = 0; i < 2; i++) {
				System.out.print(dis.readUTF());
				System.out.print(dis.readDouble());
				System.out.print(dis.readInt());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
