package chapter5;

import java.util.Scanner;

public class P11 {

	public static void main(String[] args) {
		// Reverse a String
		Scanner std = new Scanner(System.in);
		String input = std.next();
		reverse(input);
	}
	public static void reverse(String input) {
		for(int i=input.length()-1; i>=0; i--) {
			char a = input.charAt(i);
			System.out.print(a);
		}
	}
}

