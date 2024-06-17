package ch13.sec03.ex02;

public class GenericExample {

	// static generic method
	// 제네릭 타입의 매개변수를 받을 때 리턴타입 앞에 <T> 명시
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		
		return keyCompare && valueCompare;
	}
	
	public static void main(String[] args) {
		Pair<Integer, String> p1 = new Pair<>(2, "사과");
		Pair<Integer, String> p2 = new Pair<>(1, "사과");
		
		System.out.println(compare(p1, p2)); // false
		
		Pair<String, String> p3 = new Pair<>("1", "사과");
		Pair<String, String> p4 = new Pair<>("1", "사과");
		
		System.out.println(compare(p3, p4)); // true
	}

}
