package first;

import java.util.Scanner;

public class P13 {

	public static void main(String[] args) {
		// 10���� 3������ ��ȯ�ϱ�
		Scanner std = new Scanner(System.in);
		System.out.print("input:");
		int input = std.nextInt();
		int a = input%3;
		input = input/3;
		int b = input%3;
		input = input/3;
		int c = input%3;
		input = input/3;
		System.out.print(c);
		System.out.print(b);
		System.out.print(a);
		
	}

}
