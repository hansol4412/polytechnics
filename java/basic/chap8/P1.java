package chapter8;

import java.text.SimpleDateFormat;
import java.util.Date;

public class P1 {
	
	public static void main(String[] args) {
	//쓰레드도 로또 번호 뽑기
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String dateAndTime = format.format(time);
		
		System.out.println(dateAndTime);
		System.out.println("start");
		
		try {	
				
				int cnt=0;
				while(true) {
					if(cnt==6) break;
					int n = (int)(Math.random()*45)+1;
					System.out.println(n);
					cnt++;
					Thread.sleep(1000);
				}

		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		time = new Date();
		dateAndTime = format.format(time);
		System.out.println(dateAndTime);
	    System.out.println("end");
	}

}
