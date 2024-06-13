package ch07.sec04.ex01;

public class Computer extends Calculator {
	
	// 메서드 오버라이딩 (재정의)
	// 컴파일러에 명시적으로 알려주는 어노테이션. 없어도 결과는 같다. 코드의 안정성을 위해 명시적으로 지정.
	@Override
	public double areaCircle(double r) {
		System.out.println("Computer areaCircle()");
		return Math.PI * r * r;
	}
	
}
