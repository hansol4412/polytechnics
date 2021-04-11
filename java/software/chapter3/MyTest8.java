package chapter3;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyTest8 {
	//현재 날짜, 시간 찍기 (2021.4.1) 최한솔
	public static void main(String[] args) {
		Calendar kopo41_calt = Calendar.getInstance(); //현재 시간 불러오기
		SimpleDateFormat kopo41_sdt = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss"); //날짜와 시간 형식 지정하기
		
		
		System.out.printf("최종실행시간: %s\n", kopo41_sdt.format(kopo41_calt.getTime())); 
		// 현재시간을 형식적용하여 출력
		System.out.printf("******************************************************\n");
	}

}
