package ch08.sec04;

public class Test {

	public static void main(String[] args) {
		RemoteControl rc = getRemoteControl("tv");
		rc.turnOn();
		rc.setVolume(-10);
		rc.turnOff();
		
		RemoteControl rc2 = getRemoteControl("audio");
		rc2.turnOn();
		rc2.setVolume(20);
		rc2.turnOff();
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