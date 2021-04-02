package two;

import java.util.Scanner;

public class test1 {
	
	public static void main(String[] args) {
		// 환율계산기
		Scanner stdIn = new Scanner(System.in);
		System.out.print("원화를 입력하세요:");
		int input = stdIn.nextInt();
		System.out.print("환율을 입력하세요:");
		float rate = stdIn.nextFloat();
		System.out.print("환전할 종류 선택 (1: USD, 2:EUR)?");
		int choice = stdIn.nextInt();	
		
		float exchange_money = input/rate;
		int exchange_moneyInt = (int)exchange_money;
		float won = (exchange_money-exchange_moneyInt)*rate;
		int wonChange = (int)((won)/10)*10;

		if(choice ==1) {
			System.out.println(exchange_moneyInt+"달러");
			
			int a = (int)(exchange_moneyInt/100);
			System.out.println("100달러 - " + a+"장");
			exchange_moneyInt = exchange_moneyInt - a*100;
			
			int b = (int)(exchange_moneyInt/50);
			System.out.println("50달러 - " + b+"장");
			exchange_moneyInt = exchange_moneyInt - b*50;
			
			int c = (int)(exchange_moneyInt/20);
			System.out.println("20달러 - " + c+"장");
			exchange_moneyInt = exchange_moneyInt - c*20;
			
			int d = (int)(exchange_moneyInt/10);
			System.out.println("10달러 - " + d+"장");
			exchange_moneyInt = exchange_moneyInt - d*10;
			
			int e = (int)(exchange_moneyInt/5);
			System.out.println("5달러 - " + e+"장");
			exchange_moneyInt = exchange_moneyInt - e*5;
			
			int f = (int)(exchange_moneyInt/2);
			System.out.println("2달러 - " + f+"장");
			exchange_moneyInt = exchange_moneyInt - f*2;
			
			System.out.println("1달러 - " + exchange_moneyInt+"장");	
		}
		
		else if(choice==2) {
			
			System.out.println(exchange_moneyInt+"유로");
			
			int a = (int)(exchange_moneyInt/500);
			System.out.println("500유로 - " + a+"장");
			exchange_moneyInt = exchange_moneyInt - a*500;
			
			int b = (int)(exchange_moneyInt/200);
			System.out.println("200유로 - " + b+"장");
			exchange_moneyInt = exchange_moneyInt - b*200;
			
			int c = (int)(exchange_moneyInt/100);
			System.out.println("100유로 - " + c+"장");
			exchange_moneyInt = exchange_moneyInt - c*100;
			
			int d = (int)(exchange_moneyInt/50);
			System.out.println("50유로 - " + d+"장");
			exchange_moneyInt = exchange_moneyInt - d*50;
			
			int e = (int)(exchange_moneyInt/20);
			System.out.println("20유로 - " + e+"장");
			exchange_moneyInt = exchange_moneyInt - e*20;
			
			int f = (int)(exchange_moneyInt/10);
			System.out.println("10유로 - " + f+"장");
			exchange_moneyInt = exchange_moneyInt - f*10;
			
			int g = (int)(exchange_moneyInt/5);
			System.out.println("5유로 - " + g+"장");
			exchange_moneyInt = exchange_moneyInt - g*5;
			
			System.out.println("1유로 - " + exchange_moneyInt+"개");
			
		}
		else {
			System.out.println("종류를 잘못 선택하셨습니다.");
		}
		
		
		System.out.println(wonChange+"원");
		/*
		 * 환율을 넘어가면 달러로 변환되기 때문에 환율보다 큰 오천원이나 만원권은 필요없음
		int a1 = (int)(wonChange/10000);
		System.out.println("10000원 - " + a1+"장");
		wonChange = wonChange - a1*10000;
		
		int b1 = (int)(wonChange/5000);
		System.out.println("5000원 - " + b1+"장");
		wonChange = wonChange - b1*5000;
		*/
		
		int c1 = (int)(wonChange/1000);
		System.out.println("1000원 - " + c1+"장");
		wonChange = wonChange - c1*1000;
		
		int d1 = (int)(wonChange/500);
		System.out.println("500원 - " + d1+"개");
		wonChange = wonChange - d1*500;
		
		int e1 = (int)(wonChange/100);
		System.out.println("100원 - " + e1+"개");
		wonChange = wonChange - e1*100;
		
		int f1 = (int)(wonChange/50);
		System.out.println("50원 - " + f1+"개");
		wonChange = wonChange - f1*50;
		
		System.out.println("10원 - " + wonChange/10+"개");
		stdIn.close();
	}

}
