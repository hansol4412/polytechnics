package first;

import java.util.Scanner;

public class P14 {

	public static void main(String[] args) {
		//���� �Է¹޾� ����ϱ�
		Scanner std = new Scanner(System.in);
		System.out.println("Input the 1st number!");
		int input1 = std.nextInt();
		System.out.println("Input the 2st number!");
		int input2 = std.nextInt();
		int result = input1 + input2;
		System.out.println("Result : "+input1+"+"+input2+"="+result);
		
	}

}
