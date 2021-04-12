package test;

import java.util.Scanner;

public class A2 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		int a = std.nextInt();
		for(int i=0; i<a; i++) {
			for(int j=0; j<a-i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<i; j++) {
				if(i%2==1) {
					System.out.print("*");
				}
				if(i%2==0) {
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}

}
