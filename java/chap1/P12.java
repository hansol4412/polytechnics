package first;

import java.util.Scanner;

public class P12 {

	public static void main(String[] args) {
		//�Ž����� ���ϱ� (2021.03.15)
		/* ������ ���� �����ؾ� �� ���� ������� �Է��ϰ�, ���� ȿ������ �Ž������� �����ϴ� ����� ���Ͻÿ� */
		Scanner std = new Scanner(System.in);
		System.out.print("input:");
		int input = std.nextInt();
		System.out.print("paid:");
		int paid = std.nextInt();
		int change = input - paid;
		
		int a = (int)(change/10000);
		System.out.println("10000 - " + a);
		change = change - a*10000;
		
		int b = (int)(change/5000);
		System.out.println("5000 - " +b);
		change = change -b*5000;
		
		int c = (int)(change/1000);
		System.out.println("1000 - " + c);
		change = change -c*1000;
		
		int d = (int)(change/500);
		System.out.println("500 - "+d);
		change = change -d*500;
		
		int e = (int)(change/100);
		change = change -e*100;
		System.out.println("100 - "+ e);
		
		int f = (int)(change/50);
		change = change -f*50;
		System.out.println("50 - "+f);
		
		int g = (int)(change/10);
		change = change -f*10;
		System.out.println("10 - "+g);
	

	}

}
