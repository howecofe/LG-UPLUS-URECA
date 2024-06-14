package ch13.sec02.ex02;

public class CarAgency implements Rentable<Car> { // generic interface 사용 시점에 타입 결정

	@Override
	public Car rent() {
		return new Car();
	}

}
