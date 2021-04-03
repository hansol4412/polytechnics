package chapter8;

public class P4U2 extends Thread{
	private P4Data data;

	public void setData(P4Data data) {
		this.setName("U2");
		this.data = data;
	}
	
	public void run() {
		data.setA(50);
	}
}
