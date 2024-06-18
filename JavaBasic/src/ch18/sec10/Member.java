package ch18.sec10;

import java.io.Serializable;

// 보조 스트림 <객체 스트림 : ObjectInputStream, ObjectOutputStream>
public class Member implements Serializable { // 직렬화의 대상은 Serializable 인터페이스의 구현 클래스
	
	// 직렬화 클래스와 역직렬화 클래스는 동일해야 하는데, serialVersionUID 필드가 같으면 클래스 내용이 다르더라도 역직렬화 가능
	private static final long serialVersionUID = 2L;
	
	private String id;
	private static String name; // static : 직렬화에서 제외
	transient private String ssn; // transient : 직렬화에서 제외
	
	public Member(String id, String name, String ssn) {
		super();
		this.id = id;
		this.name = name;
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", ssn=" + ssn + "]";
	}
	
}