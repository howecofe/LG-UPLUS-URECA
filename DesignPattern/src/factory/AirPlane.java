package factory;

public class AirPlane implements Transportation {
	
	private static AirPlane instance;
	private AirPlane() {}
	
	public static AirPlane getInstance() {
		if (instance == null) return instance = new AirPlane();
		
		return instance;
	}

	@Override
	public void move() {
		System.out.println("비행기가 날아갑니다.");
	}

}
