package ch16.sec02.ex02;

public class ButtonExample {

	public static void main(String[] args) {
		Button btnOk = new Button();
		// funtional interface인 ClickListener 의 메서드를 lambda로 표현
		btnOk.setClickListener(() -> System.out.println("OK Button Click!"));
		btnOk.click();
		
	
		// 같은 Button 객체지만 하는 일은 달라질 수 있다.
		// why? Button 클래스에 하는 일이 결정되어 있지 않고, 외부에서 받도록 funtional interface 메서드로 구현되어 있기 때문.
		Button btnCancle = new Button();
		// funtional interface인 ClickListener 의 메서드를 lambda로 표현
		btnOk.setClickListener(() -> System.out.println("OK Button Cancle!"));
		btnOk.click();
	}

}
