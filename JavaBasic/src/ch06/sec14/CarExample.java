package ch06.sec14;

public class CarExample {
	
	public static void main(String[] args) {
		Car car = new Car();
//		car.speed = 10; // 외부에서 car 객체의 필드를 변경, private 이라 접근 불가
		car.setSpeed(10);
		
		// 외부에서 car 객체의 필드를 조회
//		System.out.println("car.stop " + car.stop); // private 이라 접근 불가
		System.out.println(car.isStop());
		
		car.setSpeed(-10);
		System.out.println("car.stop " + car.isStop());
		System.out.println("car.spped " + car.getSpeed());
	}

}
