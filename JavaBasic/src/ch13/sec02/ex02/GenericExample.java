package ch13.sec02.ex02;

public class GenericExample {

	public static void main(String[] args) {
//		HomeAgency homeAgency = new HomeAgency();
//		Home home = homeAgency.rent();
//		
//		CarAgency carAgency = new CarAgency();
//		Car car = carAgency.rent();
		
		// 타입의 다형성!
		Rentable<Home> homeAgency = new HomeAgency(); // generic interface 로 받음
		Home home = homeAgency.rent();
		
		Rentable<Car> carAgency = new CarAgency();
		Car car = carAgency.rent();
	}

}
