package ch07.sec05.sub;

import ch07.sec05.Parent;

// protected 접근 제한자
public class SubChild extends Parent {
	
	// 상속받았더라도 직접 객체 생성해서 호출하는 것은 불가능
	public void m() {
		Parent p = new Parent();
		p.m1(); // public
//		p.m3(); // protected : 자식 클래스이지만 직접 객체를 생성해서 사용하는 것은 안 된다.
//		p.m4(); // default : 다른 패키지라 호출 불가
//		p.m5(); // private
		
	}
	
	public void m6() {
		this.m1(); // public
		this.m3(); // protected : 상속을 통해 사용 가능
//		this.m4(); // default : 상속받았더라도 다른 패키지라 사용 불가
//		this.m5(); // private : 상속받았더라도 다른 객체라 사용 불가
	}
	
}

// 그렇다면.. 상속 받았지만 접근 제한자로 인해 호출이 불가능한 변수 or 메서드에는 어떻게 접근할까?
// 
// 질문!
// 상속받은 private/default 변수에 접근 못하면 getter/setter와 같은 public method로 접근하면 된다고 하셨는데
// private/default method는 접근할 수 있는 방법이 없는 건가요?