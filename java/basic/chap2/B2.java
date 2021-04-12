package test;

public class B2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<5; i++) {
			int a = (int)(Math.random()*8);
			System.out.print(a);
			System.out.printf("*");
			if(i%2==0) {
				for(int j=0; j<a; j++) {
					System.out.print("*");
				}
				for(int j=0; j<8-a; j++) {
					System.out.print(" ");
				}
			}
			if(i%2==1) {
				for(int j=0; j<8-a; j++) {
					System.out.print(" ");
				}
				for(int j=0; j<a; j++) {
					System.out.print("*");
				}
			}
			System.out.printf("*\n");
		}

	}

}
