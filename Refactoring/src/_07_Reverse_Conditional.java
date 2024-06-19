
public class _07_Reverse_Conditional {
	
	public static boolean isEven(int num) { return false; }
    public static boolean isOdd(int num) { return false; }
    
    // Old
    public static void calcOld(int num) {
        if(!isEven(num)) { // 짝수가 아니면 = 홀수이면
            
        } else {
            
        }
    }
    
    // New
    public static void calcNew(int num) {
        if (isOdd(num)) { // 홀수이면
            
        } else {
            
        }
    }
}

// 개선 방법 : ! 연산자 사용하지 않아도 되는 상황이면 사용하지 않기