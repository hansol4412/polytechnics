package two;

import java.util.Scanner;

public class P18 {

	public static void main(String[] args) {
		// 소수구하기
		Scanner stdIn = new Scanner(System.in);
		System.out.print("input number:");
		int n = stdIn.nextInt();
		
		for(int i =2; i<=n; i++) {
			int flag = 0;
			for (int j =2; j<i; j++) {
				if(i%j==0) {
					flag=1;
					break;
				}
			}
			if(flag==0) {
				System.out.println(i);
			}
		}

	}

}
