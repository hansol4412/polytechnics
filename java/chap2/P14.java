package two;

import java.util.Scanner;

public class P14 {

	public static void main(String[] args) {
		// �������� �ﰢ��
		Scanner stdIn = new Scanner(System.in);
		System.out.print("input number:");
		int n = stdIn.nextInt();
		
		for(int i =1; i<=n; i++) {
			for (int j=1; j<=i; j++) {
				System.out.print(" ");
			}
			for (int j=1; j<=(n-i)*2+1; j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
