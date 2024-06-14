package ch12.sec08;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
	
	// Date 클래스
	public static void main(String[] args) {
		// java 초기에 제공된 api
		// 간단한 날짜를 다루는 데 편하고 심플
		Date now = new Date();
		System.out.println(now);
		
		// 날짜 포맷 지정 : SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String strNow = sdf.format(now);
		System.out.println(strNow);
		
	}

}
