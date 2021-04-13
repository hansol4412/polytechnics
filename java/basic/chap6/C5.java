package test;

import java.util.Scanner;

public class C5 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		int balance = 2000;
		int[] items = new int[3];
		while(true) {
			if(balance<0) {
				System.out.println("no money");
				break;
			}
			System.out.println("vending machine");
			System.out.println("1.coke - 500\n"
					+ "2. juice - 1000\n"
					+ "3. milk - 700\n"
					+ "4. cancel all");
			System.out.println("*balance : "+balance);
			System.out.printf("*coke[%d], juice[%d], milk[%d]\n",items[0],items[1],items[2]);
			int n =std.nextInt();
			if (n==1) {
				items[0]++;
				balance = balance-(500*items[0]);
			} else if (n==2) {
				items[1]++;
				balance = balance-(1000*items[1]);
			} else if (n==3) {
				items[2]++;
				balance = balance-(7000*items[2]);
			} else if (n==4) {
				balance =2000;
				items = new int[3];
			}
		}
	}

}
