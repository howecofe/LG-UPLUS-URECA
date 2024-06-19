
public class _05_Consolidate_Duplicate_Conditional_Fragments {
	
	public static void sendToCustomer(int customerId, int price) {  }
    
    public static int getSaledPrice() { return 0; }
    public static int getRegularPrice() { return 0; }
    
    public static boolean isTodayInSale() { return false; }
    
    
    // Old
    public static void calculatePriceOld() {
        int customerId = 100;
        int price = 0;
        
        if( isTodayInSale() ) {
            price = getSaledPrice();
            sendToCustomer(customerId, price);
        } else {
            price = getRegularPrice();
            sendToCustomer(customerId, price);
        }
    }
    
    // New
    public static void calculatePriceNew() {
        int customerId = 100;
        int price = 0;
        
//        if( isTodayInSale() ) {
//            price = getSaledPrice();
//        } else {
//            price = getRegularPrice();
//        }

        // 3항 연산자
        price = isTodayInSale() ? getSaledPrice() : getRegularPrice();
        
        sendToCustomer(customerId, price);
    }
}

// 개선 방법 : 조건절에 중복된 수행 문장 합치기