package basic.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// 배열 자료구조 정렬
// 자바는 정렬 API 를 제공
// 문제에서 정렬이 필요한 경우, 적절하게 대응
public class ArraySortTest {

	public static void main(String[] args) {
		// 정수 정렬
		int[] intArray = {3, 5, 2, 7, 9, 4};
		Arrays.sort(intArray);
//		Arrays.sort(intArray);
		System.out.println(Arrays.toString(intArray));
		
		// 문자열
		String[] strArray = {"Hello", "ABC", "World", "UPLUS"};
		Arrays.sort(strArray, Collections.reverseOrder());
		System.out.println(Arrays.toString(strArray));
		
		System.out.println();
		
		Item[] itemArray = {
				new Item(3, "666"), new Item(2, "777"), new Item(5, "444"), new Item(3, "111")
		};
		
		// 정렬하기 위한 방법 1 : Comparable interface 를 구현
//		Arrays.sort(itemArray);
//		Arrays.sort(itemArray, Collections.reverseOrder());
//		System.out.println(Arrays.toString(itemArray));
		
		// 정렬하기 위한 방법 2 : 파라미터에 Comparator interface 익명 객체 전달
		// : 정렬 대상 객체에 Comparable 구현 없어도 된다.
		Arrays.sort(itemArray, new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return o1.itemId - o2.itemId;
//				return o1.itemNm.compareTo(o2.itemNm);
			}
		
		});
		
		System.out.println(Arrays.toString(itemArray));
		
		System.out.println();
		
		// 정렬하기 위한 방법 3 : 람다
		Arrays.sort(itemArray, (o1, o2) -> o2.itemId - o1.itemId); // desc
		
		Arrays.sort(itemArray, (o1, o2) -> o1.itemId - o2.itemId == 0 ? o1.itemNm.compareTo(o2.itemNm) : o1.itemId - o2.itemId);
		
		System.out.println(Arrays.toString(itemArray));
		
	}
	
	// 정렬하기 위한 방법 1 : Comparable interface 를 구현
	static class Item implements Comparable<Item> {
		int itemId;
		String itemNm;
		
		Item(int itemId, String itemNm) {
			this.itemId = itemId;
			this.itemNm = itemNm;
		}

		@Override
		public String toString() {
			return "Item [itemId=" + itemId + ", itemNm=" + itemNm + "]";
		}

		@Override
		public int compareTo(Item o) {
			
//			return this.itemId - o.itemId; // 음수가 나오면 this가 앞 // itemId asc
//			return this.itemNm.compareTo(o.itemNm); // itemNm asc
			
//			return o.itemId - this.itemId; // ItemId desc
//			return o.itemNm.compareTo(this.itemNm); // itemNm desc
			
			// itemId 우선 비교, 같으면 itemNm 비교
			return this.itemId - o.itemId == 0 ? this.itemNm.compareTo(o.itemNm) : this.itemId - o.itemId;
		}
	}
	
}
