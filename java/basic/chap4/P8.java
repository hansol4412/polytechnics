package chapter4;

import java.util.Scanner;

public class P8 {
	// 순열 (재귀함수)
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("input n:");
		int n = stdIn.nextInt();
		System.out.print("input r:");
		int r = stdIn.nextInt();
		System.out.println(p(n,r));
	}
	
	public static int p (int a, int b) {
		int n = multiple(a);
		int r = multiple(a-b);
		return n/r;
	}
	
	public static int multiple(int m) {
		if(m==1) {
			return 1;
		}
		else {
			return m*multiple(m-1);
		}
		
	}
	
}
