package factory;

public class Helicopter implements Transportation {
	
	private static Helicopter instance;
	private Helicopter() {}
	
	public static Helicopter getInstance() {
		if (instance == null) return instance = new Helicopter();
		
		return instance;
	}

	@Override
	public void move() {
		System.out.println("헬리콥터가 날아갑니다.");
	}

}
