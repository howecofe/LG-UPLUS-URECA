package factory;

public class Test {

	public static void main(String[] args) {
		// 사용하는 쪽인 Test 클래스가 Car 클래스를 인지하고 있어야 한다.
		// Car 대신 SportsCar 로 변경되는 경우 코드를 변경해야 한다.
//		Car car = Car.getInstance();
//		SportsCar car = SportsCar.getInstance();
		
		// 만들어지는 객체가 Car(), SportsCar() 객체이든 Transportation 인터페이스에 있는 메서드만 사용
		// 아래의 경우는 코드 레벨에서 수정 필요
//		Transportation t = Car.getInstance();
//		Transportation t = SportsCar.getInstance();
		
		// Car, AirPlane 클래스를 몰라도 문자열로 필요한 객체를 얻을 수 있다.
		// 이 객체는 Transportation interface 를 구현한 것만 알고 있고 그것만 사용
		// 객체를 변경하고 싶으면 TransportationFactory 클래스의 코드만 변경하면 된다.
		Transportation t = TransportationFactory.getTransportation("Air");
		t.move();
		
		Transportation t2 = TransportationFactory.getTransportation("Car");
		t2.move();
	}

}
