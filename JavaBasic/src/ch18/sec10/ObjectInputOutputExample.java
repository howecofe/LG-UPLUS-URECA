package ch18.sec10;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class ObjectInputOutputExample {

	public static void main(String[] args) throws Exception {
		
		// 직렬화
//		try (
//			OutputStream os = new FileOutputStream("member.data");
//			ObjectOutputStream oos = new ObjectOutputStream(os);
//		){
//			// 객체 생성
//			Member m1 = new Member("aaa", "홍길동", "111-222");
//			
//			oos.writeObject(m1); // 객체 직렬화
//			oos.flush();
//		}
		
		// 역직렬화
		try (
				InputStream is = new FileInputStream("member.data");
				ObjectInputStream ois = new ObjectInputStream(is);
		) {
			Member member = (Member) ois.readObject(); // 역직렬화
			System.out.println(member);
		}
		
	}

}
