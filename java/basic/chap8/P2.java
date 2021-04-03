package chapter8;

import java.text.SimpleDateFormat;
import java.util.Date;

public class P2 extends Thread{

	public static void main(String[] args) throws InterruptedException {
		// A thread is naturally destroyed => run() 메소드가 모두 실행되면 자동적으로 종료된다.
		P2 thread = new P2();
		System.out.println("check 1 :" + getCurrentTime() + "-" + thread.isAlive());
		thread.start();
		Thread.sleep(3000);
		System.out.println("check 2 :" + getCurrentTime() + "-" + thread.isAlive());
	}

	private static String getCurrentTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String dateAndTime = format.format(time);
		return dateAndTime;
	}
	
	public void run() {
		int cnt=0;
		while(true) {
			if(cnt==5) {
				break;
			}
			try {
				System.out.println(getCurrentTime() + "-" +cnt);
				Thread.sleep(100);
				cnt++;
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
