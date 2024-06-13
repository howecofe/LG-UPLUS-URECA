package ch11.sec06;


public class Account {
    private long balance;
    
    public Account() { }    
    
    // 계좌 잔고
    public long getBalance() {
        return balance;
    }   
    
    // 예금
    public void deposit(int money) {
        balance += money;
    }
    
    // 출금
    public void withdraw(int money) throws InsufficientException { // 호출한 곳으로 사용자 정의 예외 throws 
        if(balance < money) {
        	// 의도적으로 사용자 정의 예외 발생시킴.
            throw new InsufficientException("잔고 부족: " + (money - balance) + " 모자람");
        }
        
        balance -= money;
    }
}
