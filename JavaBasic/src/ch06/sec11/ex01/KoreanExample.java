package ch06.sec11.ex01;

public class KoreanExample {

	public static void main(String[] args) {
		Korean k1 = new Korean("111111-0000000", "유레카", "Korea");
		System.out.println(k1.nation);
		System.out.println(k1.ssn);
		
		// final 붙은 필드는 값 변경 불가능
//		k1.ssn = "1234";
//		k1.nation = "USA";
		k1.name = "greta"; // final 붙지 않은 필드는 변경 가능

	}

}
