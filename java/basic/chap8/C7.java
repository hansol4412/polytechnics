package test;

public class C7 {
	public static void main(String[] args) {
		Thread thread = new Number2();
		thread.start();
	}
}

class Number2 extends Thread{
	public static int cnt = 0;
	public static int num = 0;
	public void run() {
		try {
			while(num < 100) {
				int n = (int)(Math.random()*10)+1;
				num+=n;
				System.out.println("#"+cnt+" : "+n+"("+num+")");
				cnt++;
				Thread.sleep(1000);
			}
			
			System.out.println("count : " + (cnt-1));
			
		} catch(InterruptedException e) {
			System.out.println("error");
		}

	}
}
