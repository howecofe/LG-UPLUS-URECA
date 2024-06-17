package ch15.sec04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		// Map (Key, Value)
		Map<String, Integer> map = new HashMap<>();
		map.put("aaa", 50);
		map.put("aaa", 50);
		map.put("aaa", 50);
		map.put("aaa", 50);
		map.put("bbb", 60);
		map.put("ccc", 40);
		
		System.out.println(map.size());
		
		// 순회
		Set<String> keySet = map.keySet(); // aaa, bbb, ccc
		Iterator<String> itr = keySet.iterator();
		
		while (itr.hasNext()) {
			String k = itr.next(); // key
			Integer v = map.get(k); // value
			System.out.println(k + ", " + v);
		}
		
		// 삭제
		Integer index = map.remove("xxx"); // key가 없으면 null 리턴
		System.out.println(index);
		System.out.println(map.size());
	}

}
