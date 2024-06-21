package basic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 컬렉션 자료구조 정렬
public class CollectionSortTest {

	public static void main(String[] args) {
		List<Item> list = new ArrayList<>(
				Arrays.asList(new Item(3, "666"), new Item(2, "777"), new Item(5, "444"), new Item(3, "111")));
		
		Collections.sort(list);
		System.out.println(list);
		
//		Collections.sort(list, (o1, o2) -> o1.itemId - o2.itemId);
//		System.out.println(list);
		
//		Collections.sort(list, (o1, o2) -> o1.itemNm.compareTo(o2.itemNm));
//		System.out.println(list);
		
//		Collections.sort(list,
//				(o1, o2) -> o1.itemId == o2.itemId ?
//						o2.itemNm.compareTo(o1.itemNm) : o1.itemId - o2.itemId);
//		System.out.println(list);
	}
	
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
			
			return this.itemId - o.itemId; // 음수가 나오면 this가 앞 // itemId asc
//			return this.itemNm.compareTo(o.itemNm); // itemNm asc
			
//			return o.itemId - this.itemId; // ItemId desc
//			return o.itemNm.compareTo(this.itemNm); // itemNm desc
			
			// itemId 우선 비교, 같으면 itemNm 비교
//			return this.itemId - o.itemId == 0 ? this.itemNm.compareTo(o.itemNm) : this.itemId - o.itemId;
		}
	}

}
