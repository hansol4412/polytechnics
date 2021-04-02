package test;

import java.util.Scanner;

public class A3 {
	public static int[] f = new int[5];
	public static int[] p = new int[5];
	public static void main(String[] args) {
		// 물건 계산하기
		Scanner std = new Scanner(System.in);
		while(true) {
			 printMenu();
			 int menu = std.nextInt();
			 menu(menu);
		}
	}
	
	public static void printMenu() {
		System.out.println("#Menu");
		System.out.println("[PRICE] milk-"+f[0]+" apple-"+f[1]+" orange-"+f[2]+" melon-"+f[3]+" water-"+f[4]);
		System.out.print("1. Set the price of items\r\n"
				+ "2. Calculator the charges\r\n"
				+ "3. Reset the price of items\r\n"
				+ "->");
	}
	
	public static void menu(int n) {
		Scanner std1 = new Scanner(System.in);
		if(n==1) {
			System.out.println("#Please input the prices of milk, apple, orange, melon, water in order");
			System.out.print("->");
			String str = std1.nextLine();
			String[] temp = str.split(" ");
			for(int i =0; i<5; i++) {
				f[i] = Integer.parseInt(temp[i]);
			}
			
		} else if(n==2) {
			System.out.println("#Total charge");
			System.out.println("#Please input the quantities of milk, apple, orange, melon, water in order");
			System.out.print("->");
			String str = std1.nextLine();
			String[] temp = str.split(" ");
			for(int i =0; i<5; i++) {
				p[i] = Integer.parseInt(temp[i]);
			}
			int sum=0;
			for(int i =0; i<5; i++) {
				sum+= f[i]*p[i];
			}
			System.out.println("Total charge: "+sum );
			
		} else if(n==3) {
			System.out.println("#Reset complete!");
			for(int i =0; i<5; i++) {
				f[i] = 0;
				p[i] = 0;
			}
		} else {
			System.out.println("select wrong number");
		}
	}

}
