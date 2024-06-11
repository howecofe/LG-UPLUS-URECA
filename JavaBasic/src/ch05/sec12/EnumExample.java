package ch05.sec12;

import java.util.Calendar;

public class EnumExample {
	// enum : 성별, 계절, 요일 등 한정된 범위의 값에 사용
	public static void main(String[] args) {
		// Week enum + Calender
		Week today = null;
		
		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.DAY_OF_WEEK); // 현재 요일
		// 1: 일, 2: 월, 3: 화... , 7: 토
		System.out.println(week);
		
		switch(week) {
			case 1: today = Week.SUNDAY; break;
			case 2: today = Week.MONDAY; break;
			case 3: today = Week.TUESDAY; break;
			case 4: today = Week.WEDNESDAY; break;
			case 5: today = Week.THURSDAY; break;
			case 6: today = Week.FRIDAY; break;
			case 7: today = Week.SATURDAY; break;
		}
		
		System.out.println(today);
	}

}
