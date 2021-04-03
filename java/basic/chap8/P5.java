package chapter8;

import java.text.SimpleDateFormat;
import java.util.Date;

public class P5 implements Runnable{
	
	public static void main(String[] args) {
	// 초 세기 (Runnable 인터페이스 사용)
		P5 p5 = new P5();
		Thread thread = new Thread(p5);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String dateAndTime = format.format(time);
		System.out.println(dateAndTime);
		System.out.println("start");
	
		//thread.start();
		thread.run();
		
		System.out.println();
		time = new Date();
		dateAndTime = format.format(time);
		System.out.println(dateAndTime);
	    System.out.println("end");
	}
	
	@Override
	public void run() {
		try {
			for(int i=1; i<=5; i++) {
				System.out.print(i+" ");
				Thread.sleep(1000);
			}

		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
