package test;

import java.util.Scanner;

public class B2_1 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		System.out.print("input number:");
		int n = std.nextInt();
		int i=1;
		while(true) {

			int a = (int)(Math.random()*20);
			System.out.println(i+"-"+a);
			if(n==a) {
				System.out.println("Number of trials : "+i);
				break;
			}
			i++;
		}

	}

}
