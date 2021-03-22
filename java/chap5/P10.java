package chapter5;

import java.util.Scanner;

public class P10 {

	public static void main(String[] args) {
		//Reverse a Number
		Scanner std = new Scanner(System.in);
		int input = std.nextInt();
		reverse(input);
	}
	public static void reverse(int input) {
		while(input>=1) {
			int output = input%10;
			System.out.print(output);
			input = input/10;
		}
	}
}
