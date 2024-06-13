package ch08.sec02;

// Test 클래스가 Audio, Television 객체를 사용하는 입장
public class Test {

	public static void main(String[] args) {
		Audio ad = new Audio();
//		ad.turnOnAudio();
		ad.turnOn();
		ad.m();
		
		Television tv = new Television();	
//		tv.turnOnTv();
		tv.turnOn();
		
		System.out.println("---------------------");
		
		// 타입의 다형성
		RemoteControl rc1 = new Audio();
		rc1.turnOn();
//		rc1.m(); // interface에 정의되어 있으므로 호출 불가
		
		RemoteControl rc2 = new Television();
		rc2.turnOn();
		
		System.out.println("---------------------");
		
		RemoteControl rc3 = getAudio();
		rc3.turnOn();
		
		RemoteControl rc4 = geTelevision();
		rc4.turnOn();
		
		System.out.println("---------------------");
		
		// Test 클래스의 main method 입장에서는 객체가 무엇인지 모르고 사용 가능
		RemoteControl rc5 = getRemoteControl("audio");
		rc5.turnOn();
		
		RemoteControl rc6 = getRemoteControl("tv");
		rc6.turnOn();
	}
	
	public static Audio getAudio() {
		return new Audio();
	}
	
	public static Television geTelevision() {
		return new Television();
	}
	
	public static RemoteControl getRemoteControl(String clsf) {
		if (clsf.equals("audio")) {
			return new Audio();
		} else if (clsf.equals("tv")) {
			return new Television();
		}
		
		return null;
	}

}

// * WebApp DB 사용 (Oracle, MySQL, MS-SQL, ....)
// 만약 DBMS마다 java CRUD 작업을 수행 시 메서드가 각각 다르면?
// DBMS 바뀔 때마다 메서드를 변경해주어야 하므로 변경에 취약.
// -> 인터페이스를 두어 DB가 변경되면 객체만 변경! -> 다형성 구현, 변경에 유리