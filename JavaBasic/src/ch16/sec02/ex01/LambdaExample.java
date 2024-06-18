package ch16.sec02.ex01;

public class LambdaExample {

	public static void main(String[] args) {
		Person person = new Person();
		
		// 매개변수 lambda 식 : anonymous 객체의 함축
		person.action(() -> {
			System.out.println("출근!");
			System.out.println("코딩!");
		});
		
		person.action(() -> {
			System.out.println("퇴근!");
		});
		
		// 문장이 1개일 때는 괄호 생략 가능
		person.action(() -> System.out.println("퇴근!"));
	}

}
