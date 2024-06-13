package ch07.sec08.ex02;

public class Driver {
	// 타입의 다형성 : 2) 매개변수 다형성
	// 각각을 위한 메서드를 따로 만들 필요 없이 하나로 사용 가능
	// 매개변수 : Vehicle 객체, Bus 객체, Taxi 객체 
	public void drive(Vehicle vehicle) {
		System.out.println("drive Vehicle");
		vehicle.run();
	}
	
	// Specific 매개변수 우선 적용! 없으면 General 매개변수 적용!
	public void drive(Bus vehicle) {
		System.out.println("drive Bus");
		vehicle.run();
	}
}

// Vehicle vehicle = new Vehicle();
// Vehicle vehicle = new Bus();
// Vehicle vehicle = new Taxi();
