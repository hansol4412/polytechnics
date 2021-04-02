package chapter4;

import java.util.Scanner;

public class P9 {
    //조합 (재귀함수)
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("input n:");
		int n = stdIn.nextInt();
		System.out.print("input r:");
		int r = stdIn.nextInt();
		System.out.println(c(n,r));

	}
	public static int c (int a, int b) {
		int n = multiple(a);
		int r = multiple(a-b);
		int s = multiple(b);
		return n/(s*r);
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
