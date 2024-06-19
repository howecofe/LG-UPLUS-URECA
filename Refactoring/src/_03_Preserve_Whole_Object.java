
public class _03_Preserve_Whole_Object {
	
	static class Today{
        int getLow() { return 0; }
        int getHigh() { return 0; }
    }
    
    static void calcLowHigh() {
        Today today = new Today();
        int low = today.getLow();
        int high = today.getHigh();
        
        // ...
        
        // Old
        checkWeatherOld(low, high);
        
        // New
        checkWeatherNew(today);
    }
    
    // Old
    static void checkWeatherOld(int low, int high) {}
    
    // New
    static void checkWeatherNew(Today today) {}
    
}

// 개선 방법 : low, high는 Today 객체로부터 가져오는 것이므로, 파라미터를 객체로 대체