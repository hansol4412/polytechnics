package two;

import java.util.Scanner;

public class P15 {

	public static void main(String[] args) {
		//�ڽ��� ������ ��� ���ϱ�
		Scanner stdIn = new Scanner(System.in);
		System.out.print("input number:");
		int n = stdIn.nextInt();
		for(int i=10; i>1; i--) {
			if(n%i==0) {
				System.out.println(n/i);
			}
		}

	}

}
