
public class _11_Extract_Interface {

	// Old
    static class DogOld{
        void run() {}
        void eat() {}
    }
        
    static class BirdOld{
        void fly() {}
        void eat() {}
    }
    
    static class DuckOld{
        void fly() {}
        void run() {}
        void eat() {}
    }
    
    // New
    static interface Eatable {
    	void eat(); // public
    }
    
    static interface Runnable {
    	void run(); // public
    }
    
    static interface Flyable {
    	void fly(); // public
    }
    
    static class DogNew implements Runnable, Eatable {
        public void run() {}
		public void eat() {} // 오버라이딩 조건 : 접근제한자 범위가 좁아지면 안 된다.
    }
        
    static class BirdNew implements Flyable, Eatable {
    	public void fly() {}
		public void eat() {}
    }
    
    static class DuckNew implements Flyable, Runnable, Eatable {
    	public void fly() {}
    	public void run() {}
        public void eat() {}
    }
}

// 개선 방법 : 개별 클래스의 메소드들 중 동일한 기능을 수행하는 (설사 클래스가 서로 동일하지 않은(상속 관계에 없는)) 경우라면, 인터페이스로 분리
// eat -> Eatable, run -> Runnable, fly -> Flyable