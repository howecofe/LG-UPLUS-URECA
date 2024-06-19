
public class _10_Extract_Class {

	// Old
    static class CustomerOld {
        String userName;
        // hobby
        boolean loveFootball;
        String favoriatePlayer;
    }
    
    // New
    static class CustomerNew {
        String userName;
        // hobby
        Hobby hobby;
    }
    
    static class Hobby {
    	// hobby
        boolean loveFootball;
        String favoriatePlayer;
    }
}

// 개선 방법 : 성격이 비슷한 필드를 별도의 클래스로 분리 -> 변경 범위 최소화