package ch13.sec02.ex02;

// generic interface
public interface Rentable<P> {
	
	// 추상 메서드 <- public abstract 생략
	P rent();
}
