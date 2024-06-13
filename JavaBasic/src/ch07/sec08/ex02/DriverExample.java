package ch07.sec08.ex02;

//타입의 다형성 : 2) 매개변수 다형성
public class DriverExample {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		driver.drive(new Vehicle());
		driver.drive(new Bus());
		driver.drive(new Taxi());
	}
}
