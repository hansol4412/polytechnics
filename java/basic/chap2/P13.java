package two;

import java.util.Scanner;

public class P13 {

	public static void main(String[] args) {
		// 삼각형 출력
		Scanner stdIn = new Scanner(System.in);
		System.out.print("input number:");
		int n = stdIn.nextInt();
		
		for(int i =1; i<=n; i++) {
			for(int j=n-i; j>=0; j--) {
				System.out.print(" ");
			}
			for (int j=1; j<=i*2-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
