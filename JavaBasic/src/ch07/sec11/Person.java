package ch07.sec11;

// sealed 클래스 (봉인된 클래스)
// 무분별한 자식 클래스 생성 방지 목적
// final : 상속 불가 (상속 차단)
// sealed : permits 키워드를 통해 상속 가능한 자식 클래스 지정 (상속 제한)
// non-sealed : permitted 자식 클래스에서 상속을 허용하려면(일반 클래스로 변경하려면) non-sealed 키워드 사용
// sealed 클래스를 상속받은 자식 클래스는 final, sealed, non-sealed 중에 하나로 선언해야 한다.
public sealed class Person permits Manager, Employee {
	public String name;
	
	public void work() {
		System.out.println("하는 일이 결정되지 않았다.");
	}
}
