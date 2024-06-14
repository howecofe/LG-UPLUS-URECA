package ch12.sec03.ex01;

import java.util.Objects;

//Object class method overriding
public class Member extends Object {

	public String id;
	
	public Member(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	// id 값 비교하도록 오버라이딩
	@Override
	public boolean equals(Object obj) { // 오버라이딩이므로 시그니처 변경 불가
		if (obj instanceof Member) { // 객체 타입 확인
			Member target = (Member) obj; // 강제 형변환
			
//			if (this.id.equals(target.id)) { return true; }
			return Objects.equals(this.id, target.id); // 위 코드보다 향상된 방법
		}
		
		return false;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Member other = (Member) obj;
//		return Objects.equals(id, other.id); // Object 클래스와 다름.
//	}
}
