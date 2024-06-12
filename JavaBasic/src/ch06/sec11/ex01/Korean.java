package ch06.sec11.ex01;

public class Korean {
//	final String nation = "Korea"; // 불변
	final String nation;
	final String ssn; // final 붙어있으면 반드시 초기화되어야 한다. (1.필드 선언 시 초기화, 2.생성자 초기화)
	String name;
	
//	public Korean(String ssn, String name) { // nation이 초기화되지 않아서 에러 발생!
//		this.ssn = ssn;
//		this.name = name;
//	}
	
	public Korean(String nation, String ssn, String name) { // 초기화되지 않은 final 필드는 생성자에서 반드시 초기화되어야 한다. 
		this.nation = nation;
		this.ssn = ssn;
		this.name = name;
	}
}

// final
// 초기화 필수 (1.필드 선언 시 초기화, 2.생성자에서 초기화/static final인 경우 static block에서 초기화)
// final 붙은 필드는 값 변경 불가능
