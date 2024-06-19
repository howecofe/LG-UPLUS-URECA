package factory;

//singleton
public class Car implements Transportation {
	
	private static Car instance;
	private Car() {}
	
	public static Car getInstance() {
		if (instance == null) return instance = new Car();
		
		return instance;
	}
	
	@Override
	public void move() {
		System.out.println("자동차가 달립니다.");
	}

}
