package ch08.sec08;

// 다중 인터페이스 구현
public class Test {

	public static void main(String[] args) {
		RemoteControl rc = getRemoteControl("smartTv");
		rc.turnOn();
		rc.turnOff();
//		rc.search("123"); // RemoteControl에 정의된 메서드가 아니라 호출 불가
		
		System.out.println("-----------------");
		
		Searchable sch = getSearchable("smartTv");
		sch.search("123");
		
	}
	
	public static RemoteControl getRemoteControl(String clsf) {
		if (clsf.equals("audio")) {
//			return new Audio();
		} else if (clsf.equals("tv")) {
//			return new Television();
		} else if (clsf.equals("smartTv")) {
			return new SmartTelevision();
		}
		
		return null;
	}
	
	public static Searchable getSearchable(String clsf) {
		if (clsf.equals("audio")) {
//			return new Audio();
		} else if (clsf.equals("tv")) {
//			return new Television();
		} else if (clsf.equals("smartTv")) {
			return new SmartTelevision();
		}
		
		return null;
	}
}