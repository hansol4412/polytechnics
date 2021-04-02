package chapter3;

import java.util.Scanner;

public class HW1 {

	public static void main(String[] args) {
		// fibonacci number
		Scanner stdIn = new Scanner(System.in);
		System.out.print("input:");
		int n = stdIn.nextInt();
		if(n>0) {
			int one = 0;
			int two = 1;
			int result;
			if(n==1) {
				System.out.println(one);
			} else if(n==2) {
				System.out.println(one);
				System.out.println(two);
			} else {
				System.out.println(one);
				System.out.println(two);
				for (int i =2; i<n; i++) {
					result = one + two;
					System.out.println(result);
					one =  two;
					two = result;
				}
			}
		} else {
			System.out.println("wrong input!!");
		}
	}

}
