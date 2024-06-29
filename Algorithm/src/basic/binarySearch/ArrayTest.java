package basic.binarySearch;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		//  index    0  1  2  3  4
		//        -1  -2 
		int[] arr = {1, 3, 5, 7, 9};
		System.out.println(Arrays.binarySearch(arr, 1)); // 찾으면 index 반환
		System.out.println(Arrays.binarySearch(arr, 2)); // -2, 못 찾으면 원래 있어야 하는 index * (-1) - 1
		System.out.println(Arrays.binarySearch(arr, 0)); // -1
		// => target 못 찾으면 음수!
	}

}
