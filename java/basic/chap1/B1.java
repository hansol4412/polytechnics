package test;

import java.util.Scanner;

public class B1 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		int a = std.nextInt();
		int b = std.nextInt();
		int c = std.nextInt();
		
		if(a%b==0 && a%c==0) {
			System.out.println(a+" is divible by "+b+" and "+c);
		} else {
			System.out.println(a+" is not divible by "+b+" and "+c);
		}

	}

}
