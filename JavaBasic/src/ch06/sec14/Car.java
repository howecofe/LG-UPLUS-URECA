package ch06.sec14;

public class Car {
	private int speed;
	private boolean stop;
	
	public int getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(int speed) {
		if (speed <= 0) {
			this.speed = 0;
//			this.stop = true;
			setStop(true);
		} else {
			this.speed = speed;
//			this.stop = false;
			setStop(false);
		}
	}
	
	public boolean isStop() {
		return this.stop;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
}
// Getter & Setter
// OOP의 캡슐화 구현
// getter, setter 는 일관성 있는 형식이 중요 (컨벤션)
// 변경이 발생하거나 잘못된 값으로 초기화되었을 때, 코드에서 car.speed = 값 이 코드를 일일이 변경할 필요없이, setter의 코드만 변경해주면 되는 이점이 있다.
// -> 변경에 유리!