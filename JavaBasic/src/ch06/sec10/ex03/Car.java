package ch06.sec10.ex03;

public class Car {
	int speed;
	
	void run() {
		System.out.println(speed + " 속도로 달린다.");
	}
	
	static void simulate() {
		System.out.println("simulate");
		
//		this.speed = 10; // static에서는 this 또는 instance member 사용 불가
//		speed = 10;
//		run();
	}
	
	public static void main(String[] args) {
		Car car = new Car();
		car.run(); // instance method
		
		Car.simulate(); // static method
	}
}
