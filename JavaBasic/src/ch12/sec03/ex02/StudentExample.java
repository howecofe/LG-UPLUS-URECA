package ch12.sec03.ex02;

public class StudentExample {

	public static void main(String[] args) {
		Student s1 = new Student(10, "홍길동");
		Student s2 = new Student();
		s2.setNo(20);
		s2.setName("이길동");
		
		System.out.println(s1);
		System.out.println(s2);
	}

}
