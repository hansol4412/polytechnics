package two;

import java.util.Scanner;

public class test1 {
	
	public static void main(String[] args) {
		// ȯ������
		Scanner stdIn = new Scanner(System.in);
		System.out.print("��ȭ�� �Է��ϼ���:");
		int input = stdIn.nextInt();
		System.out.print("ȯ���� �Է��ϼ���:");
		float rate = stdIn.nextFloat();
		System.out.print("ȯ���� ���� ���� (1: USD, 2:EUR)?");
		int choice = stdIn.nextInt();	
		
		float exchange_money = input/rate;
		int exchange_moneyInt = (int)exchange_money;
		float won = (exchange_money-exchange_moneyInt)*rate;
		int wonChange = (int)((won)/10)*10;

		if(choice ==1) {
			System.out.println(exchange_moneyInt+"�޷�");
			
			int a = (int)(exchange_moneyInt/100);
			System.out.println("100�޷� - " + a+"��");
			exchange_moneyInt = exchange_moneyInt - a*100;
			
			int b = (int)(exchange_moneyInt/50);
			System.out.println("50�޷� - " + b+"��");
			exchange_moneyInt = exchange_moneyInt - b*50;
			
			int c = (int)(exchange_moneyInt/20);
			System.out.println("20�޷� - " + c+"��");
			exchange_moneyInt = exchange_moneyInt - c*20;
			
			int d = (int)(exchange_moneyInt/10);
			System.out.println("10�޷� - " + d+"��");
			exchange_moneyInt = exchange_moneyInt - d*10;
			
			int e = (int)(exchange_moneyInt/5);
			System.out.println("5�޷� - " + e+"��");
			exchange_moneyInt = exchange_moneyInt - e*5;
			
			int f = (int)(exchange_moneyInt/2);
			System.out.println("2�޷� - " + f+"��");
			exchange_moneyInt = exchange_moneyInt - f*2;
			
			System.out.println("1�޷� - " + exchange_moneyInt+"��");	
		}
		
		else if(choice==2) {
			
			System.out.println(exchange_moneyInt+"����");
			
			int a = (int)(exchange_moneyInt/500);
			System.out.println("500���� - " + a+"��");
			exchange_moneyInt = exchange_moneyInt - a*500;
			
			int b = (int)(exchange_moneyInt/200);
			System.out.println("200���� - " + b+"��");
			exchange_moneyInt = exchange_moneyInt - b*200;
			
			int c = (int)(exchange_moneyInt/100);
			System.out.println("100���� - " + c+"��");
			exchange_moneyInt = exchange_moneyInt - c*100;
			
			int d = (int)(exchange_moneyInt/50);
			System.out.println("50���� - " + d+"��");
			exchange_moneyInt = exchange_moneyInt - d*50;
			
			int e = (int)(exchange_moneyInt/20);
			System.out.println("20���� - " + e+"��");
			exchange_moneyInt = exchange_moneyInt - e*20;
			
			int f = (int)(exchange_moneyInt/10);
			System.out.println("10���� - " + f+"��");
			exchange_moneyInt = exchange_moneyInt - f*10;
			
			int g = (int)(exchange_moneyInt/5);
			System.out.println("5���� - " + g+"��");
			exchange_moneyInt = exchange_moneyInt - g*5;
			
			System.out.println("1���� - " + exchange_moneyInt+"��");
			
		}
		else {
			System.out.println("������ �߸� �����ϼ̽��ϴ�.");
		}
		
		
		System.out.println(wonChange+"��");
		/*
		 * ȯ���� �Ѿ�� �޷��� ��ȯ�Ǳ� ������ ȯ������ ū ��õ���̳� �������� �ʿ����
		int a1 = (int)(wonChange/10000);
		System.out.println("10000�� - " + a1+"��");
		wonChange = wonChange - a1*10000;
		
		int b1 = (int)(wonChange/5000);
		System.out.println("5000�� - " + b1+"��");
		wonChange = wonChange - b1*5000;
		*/
		
		int c1 = (int)(wonChange/1000);
		System.out.println("1000�� - " + c1+"��");
		wonChange = wonChange - c1*1000;
		
		int d1 = (int)(wonChange/500);
		System.out.println("500�� - " + d1+"��");
		wonChange = wonChange - d1*500;
		
		int e1 = (int)(wonChange/100);
		System.out.println("100�� - " + e1+"��");
		wonChange = wonChange - e1*100;
		
		int f1 = (int)(wonChange/50);
		System.out.println("50�� - " + f1+"��");
		wonChange = wonChange - f1*50;
		
		System.out.println("10�� - " + wonChange/10+"��");
		stdIn.close();
	}

}
