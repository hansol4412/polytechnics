package chapter8;

public class P4Data {
	private int a;

	public int getA() {
		return a;
	}
	public synchronized void setA(int a) {
		this.a = a;
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			System.out.println("Error");
		}
		System.out.println(Thread.currentThread().getName() +":" + this.a);
	}

}
