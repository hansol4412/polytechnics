package chapter3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class P7 {

	public static void main(String[] args) {
		//날짜 차이 구하기
		Scanner stdIn = new Scanner(System.in);
		System.out.print("start date:");;
		String sDate = stdIn.next();
		System.out.print("end date:");;
		String eDate = stdIn.next();
		
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
	    Date date1 = null;
	    Date date2 = null;
	    try {
	    		date1 = df.parse(sDate);  // String to Date by SimpleDateFormat
	    		date2 = df.parse(eDate);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    
	    cal1.setTime(date1);
	    cal2.setTime(date2);
	    long diffSec = (cal1.getTimeInMillis() - cal2.getTimeInMillis()) / 1000;     
	    long diffDay = diffSec/(60 * 60 * 24);                                                     //날
	    System.out.println(diffDay);  
	}

}
