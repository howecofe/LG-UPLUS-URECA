package ch08.sec05;

public class Test {

	public static void main(String[] args) {
		RemoteControl rc = getRemoteControl("tv");
		rc.turnOn();
		rc.setVolume(-10);
		rc.turnOff();
		
		System.out.println("------------------");
		
		rc = getRemoteControl("audio");
		rc.turnOn();
		rc.setVolume(20);
		rc.turnOff();
		
		System.out.println("------------------");
		
		rc.setMute(true); // default method 호출
		rc.setMute(false);
		
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