package chapter4;

import java.util.Scanner;

public class P10 {
	// 구구단 (재귀함수)
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("input n:");
		int n = stdIn.nextInt();
		multiple(n,9);
	}
	public static void multiple(int n, int s) {
		if(s==1) {
			System.out.println(n+ " X " +1 +" = "+ n*s);
		}
		else {
			multiple(n,s-1);
			System.out.println(n+ " X " +s +" = "+ n*s);
		}
	}

}
