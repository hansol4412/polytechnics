package chapter8;

public class P3 {

	public static void main(String[] args) {
	// 쓰레드 우선순위 정하기
		Thread thread1 = new MultiThreadTest("[ Thread "+1+" ]");
		thread1.setPriority(Thread.MIN_PRIORITY); //third
		thread1.start();
		Thread thread2 = new MultiThreadTest("[ Thread "+2+" ]");
		thread2.setPriority(Thread.MAX_PRIORITY); //first
		thread2.start();
		Thread thread3 = new MultiThreadTest("[ Thread "+3+" ]");
		thread3.setPriority(Thread.NORM_PRIORITY); //second
		thread3.start();
	}

}

class MultiThreadTest extends Thread{
	public MultiThreadTest (String threadName) {
		this.setName(threadName);
	}
	public void run() {
		try {
			Thread.sleep(10);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getName() + " thread_start");
	}
}
