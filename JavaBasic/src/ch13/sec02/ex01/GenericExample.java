package ch13.sec02.ex01;

public class GenericExample {

	public static void main(String[] args) {
		Product<TV, String> p1 = new Product<>();
		p1.setKind(new TV());
		p1.setModel("OLED");
		
		TV tv = p1.getKind();
		String model = p1.getModel();
		
		Product<Car, String> p2 = new Product<>();
		p2.setKind(new Car());
		p2.setModel("포니");
	}

}
