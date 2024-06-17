package ch15.sec03;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		// Set: 순서 X, 중복 X
		Set<String> set = new HashSet<>();
		set.add("Java");
		set.add("Java");
		set.add("Java");
		set.add("Java");
		set.add("유레카");
		set.add("백엔드");
		
		System.out.println(set.size());
		
		for (String str : set) {
			System.out.println(str); 
		}
		
		System.out.println("-------------");
		
		Set<Member> set2 = new HashSet<>();
		set2.add(new Member("홍길동", 25));
		set2.add(new Member("홍길동", 25));
		set2.add(new Member("이길동", 25));
		
		System.out.println(set2.size());
		for (Member member : set2) {
			System.out.println(member);
		}
		
		System.out.println("-------------");
		
		set2.remove(new Member("홍길동", 25));
		
		System.out.println(set2.size());
		for (Member member : set2) {
			System.out.println(member);
		}
		
	}

}
