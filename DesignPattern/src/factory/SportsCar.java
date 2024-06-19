package factory;

public class SportsCar implements Transportation {
	
	private static SportsCar instance;
	private SportsCar() {}
	
	public static SportsCar getInstance() {
		if (instance == null) return instance = new SportsCar();
		
		return instance;
	}

	@Override
	public void move() {
		System.out.println("스포츠카가 달립니다.");
	}

}
