
public class _06_Decompose_Conditional {
	
	// Old
    public static int calcOld(int val1, int val2, int val3) {
        int result = 0;
        
        if( (val1 < 100 && val3 > 200) || val1 == 100 && val2 == 200 ) {
            result = val1 * val2 - val3;
        } else {
            result = val2 + val3 - val1;
        }
        
        return result;
    }
    
    // New
    public static int calcNew(int val1, int val2, int val3) {
        int result = 0;
        
        if (checkValue(val1, val2, val3)) {
        	calcResultOne(val1, val2, val3);
        } else {
        	calcResultTwo(val1, val2, val3);
        }
        
        return result;
    }
    
    public static boolean checkValue(int val1, int val2, int val3) { 
        if( (val1 < 100 && val3 > 200) || val1 == 100 && val2 == 200 ) return true;
        return false;
    }
    
    public static int calcResultOne(int val1, int val2, int val3) {
        return val1 * val2 - val3;
    }
    
    public static int calcResultTwo(int val1, int val2, int val3) {
        return val2 + val3 - val1;
    }
    
}

// 개선 방법: 조건절을 메서드로 분해