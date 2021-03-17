package two;

import java.util.Scanner;

public class P16 {

	public static void main(String[] args) {
		// LCM (최소공배수)
		Scanner stdIn = new Scanner(System.in);
		System.out.print("input number1:");
		int n = stdIn.nextInt();
		System.out.print("input number2:");
		int m = stdIn.nextInt();
		int small;
		if(n>m) {
			small=m;
		}else {
			small=n;
		}
		
		int fixed=0;
		
		for(int i=2; i<=small; i++) {
			if(n%i==0 && m%i==0) {
					fixed=i;
			}
		}

		int gcd;
		if(fixed==0) {
			gcd=1;
		}else {
			gcd=fixed;
		}
		
		int lcm = (n*m)/gcd;
		
		System.out.println(lcm);
		
	}

}
