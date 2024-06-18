package ch16.sec01;

// 람다식
public class LambdaExample {
	
	// 파라미터의 type이 funtional interface 이므로 이 파라미터를 통해서 호출할 수 있는 메서드는 딱 하나!
	public static void action(Calculable calculable) {
		calculable.calculate(10, 4);
	}

	public static void main(String[] args) {
		// 1. 인터페이스를 구현한 클래스 객체 전달
		// plus
		Calculable cp = new CalculableImplPlus();
		action(cp);
		
		// minus
		Calculable cm = new CalculableImplMinus();
		action(cm);
		
		System.out.println("-------------------");
		
		// 2. 한 번만 사용할 것이기 때문에 익명 구현 객체 전달
		// anonymous plus
		action(new Calculable() {
			@Override
			public void calculate(int x, int y) {
				System.out.println(x + y);
			}
		});
		
		// anonymous minus
		action(new Calculable() {
			@Override
			public void calculate(int x, int y) {
				System.out.println(x - y);
			}
		});
		
		System.out.println("-------------------");
		
		// 3. 람다 : 파라미터로 어떤 작업을 할 것인지 전달
		action((x, y) -> System.out.println(x + y));
		action((x, y) -> System.out.println(x - y));
	}

}
