package chapter8;

public class P4 {

	public static void main(String[] args) {
		P4Data a = new P4Data();
		
		P4U1 u1 = new P4U1();
		u1.setData(a);
		u1.start();
		
		P4U2 u2 = new P4U2();
		u2.setData(a);
		u2.start();
	
	}

}
