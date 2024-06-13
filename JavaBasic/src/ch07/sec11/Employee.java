package ch07.sec11;

public non-sealed class Employee extends Person {
	@Override
	public void work() {
		System.out.println("Employee 일을 한다.");
	}
}
