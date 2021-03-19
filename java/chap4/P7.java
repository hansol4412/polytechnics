package chapter4;

import java.util.Scanner;

public class P7 {

	public static void main(String[] args) {
		// 펙토리얼 (재귀함수)
		Scanner stdIn = new Scanner(System.in);
		System.out.print("input number:");
		int n = stdIn.nextInt();
		System.out.println(factorial(n));
	}
	
	public static int factorial(int n) {
		if(n==1) {
			System.out.print("1 = ");
			return 1;
		}
		else {
			 System.out.print(n+" X ");
			 return n*factorial(n-1);
		}
	}

}
