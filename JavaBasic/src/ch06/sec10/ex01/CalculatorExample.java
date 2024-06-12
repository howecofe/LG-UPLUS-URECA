package ch06.sec10.ex01;

public class CalculatorExample {

	public static void main(String[] args) {
		// instance member
		// static : 객체 생성 후 참조하는 것도 가능하지만 권장 X
//		Calculator calc = new Calculator();
//		double result1 = 10 * 10 * calc.pi;
		
		// static member
		double result1 = 10 * 10 * Calculator.pi; // 객체 생성 X
		System.out.println(result1);
		System.out.println(Calculator.plus(5, 10));
		System.out.println(Calculator.minus(5, 10));
		
		int a = 10;
		int b = 20;
		System.out.println(Math.max(a,  b)); // static method -> Math 객체 생성 X
		System.out.println(Math.abs(a - b)); // static method
	}

}

// Static 멤버 : static 필드, static 메서드
// 객체를 만들지 않고 사용 가능한 필드/메서드
// 클래스 로더가 메소드 영역으로 로딩
// static 멤버에서 인스턴스 멤버 사용 불가, this(heap에 저장된 객체)도 사용 불가
// 인스턴스로 접근하는 것도 가능하지만 권장 X
// static 멤버는 객체별로 존재할 필요없이 모두에게 동일하거나, 단순 기능을 수행하는 목적으로 사용
// static 에서는 this 또는 instance member 사용 불가
// static 멤버는 생성에서 초기화하지 않는다. 생성자는 객체 생성 후 실행되기 때문.

// static block
// 클래스가 메모리에 load될 때 실행 by 클래스 로더, 여러개면 순서대로 실행
// static block에 사용되는 static 멤버의 선언은 선행되어야 한다.
