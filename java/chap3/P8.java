package chapter3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class P8 {

	public static void main(String[] args) {
		// 날짜 더하기
		Scanner stdIn = new Scanner(System.in);
		System.out.print("start date:");;
		String sDate = stdIn.next();
		System.out.print("add number:");
		int addN = stdIn.nextInt();
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
	    Date date = null;
	    try {
	    		date = df.parse(sDate);  // String to Date by SimpleDateFormat
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    
	        cal.setTime(date);
	        System.out.println("current: " + df.format(cal.getTime()));
	        cal.add(Calendar.DATE, addN);
	        System.out.println("after: " + df.format(cal.getTime()));
	    }
}

