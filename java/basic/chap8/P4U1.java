package chapter8;

public class P4U1 extends Thread{
	private P4Data data;

	public void setData(P4Data data) {
		this.setName("U1");
		this.data = data;
	}
	
	public void run() {
		data.setA(100);
	}
	
	
}
