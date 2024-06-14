package ch13.sec01;

public class BoxExample {

	public static void main(String[] args) {
		Box<String> box = new Box<>(); // new Box<String>();
		box.content = "Hello";
		
		Box<Integer> box2 = new Box<>();
		box2.content = 3;
		
//		box2.content = "Hello"; // 지네릭 타입이 일치하지 않아 에러
	}

}
