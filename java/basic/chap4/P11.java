package chapter4;

import java.util.Scanner;

public class P11 {
	//피보나치 수열 (재귀함수)
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("input n:");
		int n = stdIn.nextInt();
		for(int i =0; i<n; i++) {
			System.out.println(fibonacci(i));
		}
		
	}
	
	public static int fibonacci(int n) {
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}

}
