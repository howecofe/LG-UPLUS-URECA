
public class _09_Separate_Query_From_Modifier {

	// Old
    public static String getUserNameChangeUserState(int userId) {
    	// 사용자 이름도 전달, 사용자의 상태값도 변경
    	// 복수의 일을 하는 메서드 -> 나눠라!
        return "userName"; 
    }
    
    // New
    public static String getUserName(int userId) {
    	return "userName";
    }
    
    public void changeUserState() {
    	
    }
}

// 개선 방법: 복수 기능을 하는 메서드를 단일 기능을 수행하도록 분리