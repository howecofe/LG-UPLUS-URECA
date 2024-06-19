
public class _04_Consolidate_Conditional_Expression {
	
	// Old
	public void registerOld(String userName, String userPassword, String userEmail) {
        if( userName.contains("aaa")) stopRegister();
        if( userPassword.contains("bbb")) stopRegister();
        if( userEmail.contains("ccc")) stopRegister();
        doRegister();
    }
    
    public void stopRegister() {}
    public void doRegister() {}
    
    // New
    public void registerNew(String userName, String userPassword, String userEmail) {
        if(registerValidate(userName, userPassword, userEmail)) doRegister();
        
        stopRegister();
    }
    
    public boolean registerValidate(String userName, String userPassword, String userEmail) {
    	if( userName.contains("aaa")
    			|| userPassword.contains("bbb")
    			|| userEmail.contains("ccc")) return false;
        
        return true;
    }
    
}

// 개선 방법 : 결과가 같은 조건식을 하나로 합병