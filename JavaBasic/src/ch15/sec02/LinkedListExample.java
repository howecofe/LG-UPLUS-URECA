package ch15.sec02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		list.add("Hello");
		list.add("World");
		list.add("유레카");
		
		String cur = list.get(1);
		System.out.println(cur);
		
		System.out.println("-----------------------");

		// [Test] ArrayList VS LinkedList
		List<String> arrayList = new ArrayList<>();
		List<String> linkedList = new LinkedList<>();
		long startTime;
		long endTime;
		
		// 맨 앞에 추가함으로써 중간에 변화가 많이 생기도록 테스트
		// ArrayList
		startTime = System.nanoTime();
		for (int i = 0; i < 300000; i++) {
			arrayList.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		
		System.out.println(endTime - startTime);
		System.out.println("-----------------------");
		
		// LinkedList
		startTime = System.nanoTime();
		for (int i = 0; i < 300000; i++) {
			linkedList.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		
		System.out.println(endTime - startTime); // LinkedList 더 빠름!!
		
		System.out.println("-----------------------");
		
		// 맨 뒤에 쭉 넣는 테스트
		// ArrayList
		startTime = System.nanoTime();
		for (int i = 0; i < 300000; i++) {
			arrayList.add(String.valueOf(i));
		}
		endTime = System.nanoTime();
		
		System.out.println(endTime - startTime); // ArrayList 더 빠름!!
		System.out.println("-----------------------");
		
		// LinkedList
		startTime = System.nanoTime();
		for (int i = 0; i < 300000; i++) {
			linkedList.add(String.valueOf(i));
		}
		endTime = System.nanoTime();
		
		System.out.println(endTime - startTime);
	}

}
