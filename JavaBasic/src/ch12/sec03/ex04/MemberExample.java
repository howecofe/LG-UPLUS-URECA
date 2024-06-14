package ch12.sec03.ex04;

public class MemberExample {

	public static void main(String[] args) {
		Member m = new Member("winter", "눈송이", 25); // record 객체
		System.out.println(m.id());
		System.out.println(m.name());
		System.out.println(m.age());
		System.out.println(m); // m.toString()
		System.out.println(m.hashCode());
		
		Member m2 = new Member("winter", "눈송이", 25);
		System.out.println(m.equals(m2));
	}

}
