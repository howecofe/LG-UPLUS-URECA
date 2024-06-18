package ch16.sec05.ex01;

// Lambda : method reference (메서드 참조)
public class MethodReferenceExample {
	
	public static void main(String[] args) {
		Person person = new Person();
		
		person.action((x, y) -> {
			return Computer.staticMethod(x, y);
		});
		
		person.action((x, y) -> Computer.staticMethod(x, y));
		person.action(Computer :: staticMethod); // method reference
		
		Computer computer = new Computer();
		person.action((x, y) -> computer.instanceMethod(x, y));
		person.action(computer :: instanceMethod); // // method reference
	}
}
