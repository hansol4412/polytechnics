package chapter4;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class HW2 {
	
	public static void main(String[] args) {
		//두 시간의 차이를 초(second)로 나타내기
		Scanner stdIn = new Scanner(System.in);
		System.out.print("start:");;
		String shour = stdIn.next();
		System.out.print("end:");;
		String ehour = stdIn.next();
		
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("HHmmss");
	    Date hour1 = null;
	    Date hour2 = null;
	    try {
	    		hour1 = df.parse(shour);  // String to Date by SimpleDateFormat
	    		hour2 = df.parse(ehour);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    
	    cal1.setTime(hour1);
	    cal2.setTime(hour2);
	    
	    long diffSec = (cal2.getTimeInMillis()- cal1.getTimeInMillis()) / 1000;
	    System.out.println(diffSec+"s");
 
	}
}
