package two;

import java.util.Scanner;

public class P12 {

	public static void main(String[] args) {
		// 직각삼각형
		Scanner stdIn = new Scanner(System.in);
		System.out.print("input number:");
		int n = stdIn.nextInt();
		
		for(int i =1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
