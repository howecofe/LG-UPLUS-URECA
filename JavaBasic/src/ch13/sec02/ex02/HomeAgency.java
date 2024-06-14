package ch13.sec02.ex02;

public class HomeAgency implements Rentable<Home> { // generic interface 사용 시점에 타입 결정

	@Override
	public Home rent() {
		return new Home();
	}

}
