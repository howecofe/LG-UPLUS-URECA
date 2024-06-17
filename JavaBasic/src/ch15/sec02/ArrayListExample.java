package ch15.sec02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		List<Board> list = new ArrayList<>();
		
		// 추가
		list.add(new Board("제목1", "내용1", "홍길동"));
		list.add(new Board("제목2", "내용2", "이길동"));
		list.add(new Board("제목2", "내용3", "삼길동"));
		list.add(new Board("제목4", "내용4", "사길동"));
		list.add(new Board("제목5", "내용5", "오길동"));
		
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.get(2));
		
		// 순회
		// 1. for + index -> 가장 빠르다.
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("--------------------");
		
		// 2. for each
		for (Board board : list) {
			System.out.println(board);
		}
		
		System.out.println("--------------------");
		
		// 3. iterator
		Iterator<Board> itr = list.iterator();
		
		while (itr.hasNext()) {
			Board board = itr.next();
			System.out.println(board);
		}
		
		System.out.println("--------------------");
		
		// 삭제
//		list.remove(2);
//		System.out.println(list);
		
		//for + index 순회 중 삭제 <= 문제가 발생할 수 있다.
		for (int i = 0; i < list.size(); i++) {
			Board board = list.get(i);
			
			if (board.getSubject().equals("제목2")) {
				list.remove(i);
			}
		}
		
		// for + index 는 뒤부터 삭제!
//		for (int i = list.size() - 1; i >= 0; i--) {
//			Board board = list.get(i);
//			
//			if (board.getSubject().equals("제목2")) {
//				list.remove(i);
//			}
//		}
		
		
		// iterator 순회 중 삭제는 문제 발생 X
//		Iterator<Board> itr2 = list.iterator();
//		
//		while (itr2.hasNext()) {
//			Board board = itr2.next();
//			if (board.getSubject().equals("제목2")) {
//				itr2.remove();
//			}
//		}
		
		// for each 순회 중 삭제 <= 문제 발생! java.util.ConcurrentModificationException
//		for (Board board : list) {
//			if (board.getSubject().equals("제목2")) {
//				list.remove(board);
//			}
//		}
		
		System.out.println(list);
	}

}
