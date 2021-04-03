package chapter8;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class P6 {
	public static int second;
	public static void main(String[] args) {
	// 타이머 
		Scanner std = new Scanner(System.in);
		System.out.print("input time(s):");
		second = std.nextInt();
		SS aa = new SS(second);
		
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date time = new Date();
		String dateAndTime = format.format(time);
		System.out.println(dateAndTime);
	
		aa.start();
		
		
	}

}

class SS extends Thread{
	int second;
	public SS (int second) {
		this.second = second;
	}

	public void run() {
			try {
				
				for(int i=1; i<=second; i++) {
					Thread.sleep(1000);  
					//System.out.println(i);
				}
				
				Date time = new Date();
				SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
				String dateAndTime = format.format(time);
				dateAndTime = format.format(time);
				System.out.println("time is over(" +dateAndTime+")");
				
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
