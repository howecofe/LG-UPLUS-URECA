package ch05.sec06;

public class ArrayExample {

	public static void main(String[] args) {
		// 배열 선언
		int[] n; // 일반적인 표현
		int n2[];
		
		// 배열 생성
		int[] intArray = new int[5]; // 0으로 초기화, 1) 변수와 heap 의 배열 공간만 확보
		int[] intArray2 = {1, 2, 3, 4, 5}; // 2) 변수와 heap 의 배열 공간 + value
		int[] intArray3 = new int[] {1, 2, 3, 4, 5}; // 3) 변수와 heap 의 배열 공간 + value
		
		// 2)와 3)의 차이는?
		int a = 10, b = 20;
//		int[] intArray4 = {a, b}; // 2) 선언과 동시에 값 할당 ok
//		int[] intArray4; // 선언
//		intArray4 = {a, b}; // 이후 값 할당 -> 오류
		
//		int[] intArray5 = new int[] {a, b}; // 3) 선언과 동시에 객체 생성 및 값 할당 ok
		int[] intArray5; // 선언
		intArray5 = new int[] {a, b}; // 객체 생성 및 값 할당
		
		System.out.println(intArray2 == intArray3); // false
		
		int[] intArray6 = {1, 2, 3, 4, 5};
		
		System.out.println(intArray2 == intArray6); // false, 호칭 : array constants
		
		String[] strArray = {"Hello", "Java", "유레카"};
		String[] strArray2 = new String[3]; // null 로 초기화
		String[] strArray3 = new String[] {"a", "b", "c"};
		
		System.out.println(intArray[2]); // 0 (primitive type array)
		System.out.println(strArray2[2]); // null (reference type array)
		System.out.println(strArray2.length); // 배열의 길이 3
//		System.out.println(strArray2[0].length()); // NPE 발생
	}

}

// 배열 : Immutable(불변), 한 번 만들어지면 변경 불가