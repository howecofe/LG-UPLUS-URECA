package ch07.sec11;

// sealed 클래스를 상속받은 자식 클래스는 final, sealed, non-sealed 중에 하나로 선언해야 한다.
public final class Manager extends Person {
	@Override
	public void work() {
		System.out.println("Manager 일을 한다.");
	}
}
