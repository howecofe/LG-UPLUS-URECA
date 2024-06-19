package builder;

public class Test {

	public static void main(String[] args) {
		NormalBook nBook = new NormalBook();
		nBook.setIsbn("111");
		nBook.setTitle("제목1");
		nBook.setAuthor("홍길동");
		System.out.println(nBook);
		
		// 적당한 field 를 set 할 수 있는 적당한 생성자를 추가로 요구
		NormalBook nBook2 = new NormalBook("222", "이길동", "제목2"); // 순서 오류 발생 가능성 존재
		System.out.println(nBook2);
		
		System.out.println("-----------------");
		
		// builder pattern - slim 버전
		BuilderBook bBook = BuilderBook.builder()
				.isbn("333")
				.title("제목3")
				.author("삼길동");
		
		System.out.println(bBook);
		
		System.out.println("-----------------");
		
//		builder pattern - original 버전
		Board board = new Board.Builder() // 내부 클래스인 Builder 부터 시작
				.title("제목1")
				.content("내용1")
				.category("분류1")
				.build(); // Board 객체 리턴
		
		Board board2 = Board.builder()
				.title("제목2")
				.content("내용2")
				.category("분류2")
				.build();
		
		System.out.println(board);
		System.out.println(board2);
	}

}
