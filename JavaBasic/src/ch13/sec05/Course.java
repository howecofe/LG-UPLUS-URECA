package ch13.sec05;

// 와일드카드 generic 타입 파라미터
// generic 타입 파라미터와의 차이점 : generic method에서 파라미터 타입 자체가 generic type
// 와일드카드 generic 타입 파라미터는 파라미터 타입의 객체에서 generic type 사용
public class Course {
	
	public static void registerCourse1(Applicant<?> applicant) {
		System.out.println(applicant.kind);
	}
	
	public static void registerCourse2(Applicant<? extends Student> applicant) { // Student 포함 하위 클래스
			
	}
	
	public static void registerCourse3(Applicant<? super Worker> applicant) { // Worker 포함 상위 클래스
		
	}
}
