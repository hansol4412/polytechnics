package kyd;

public class Print {
	public void printExchangeUSD(int orginalExchange_moneyInt, int a, int b, int c, int d, int e, int f, int exchange_moneyInt) {
		System.out.println(orginalExchange_moneyInt+"달러");
		System.out.println("100달러 - " + a+"장");
		System.out.println("50달러 - " + b+"장");
		System.out.println("20달러 - " + c+"장");
		System.out.println("10달러 - " + d+"장");
		System.out.println("5달러 - " + e+"장");
		System.out.println("2달러 - " + f+"장");
		System.out.println("1달러 - " + exchange_moneyInt+"장");	
		
	}
	
	public void printExchangeEUR(int orginalExchange_moneyInt, int a, int b, int c, int d, int e, int f, int g, int exchange_moneyInt) {
		System.out.println(orginalExchange_moneyInt+"유로");
		System.out.println("500유로 - " + a+"장");
		System.out.println("200유로 - " + b+"장");
		System.out.println("100유로 - " + c+"장");
		System.out.println("50유로 - " + d+"장");
		System.out.println("20유로 - " + e+"장");
		System.out.println("10유로 - " + f+"장");
		System.out.println("5유로 - " + g+"장");
		System.out.println("1유로 - " + exchange_moneyInt+"개");
	}
	
	public void printExchangeJPY(int exchange_moneyInt, int a, int b, int c, int d, int e, int f) {
		System.out.println(exchange_moneyInt+"엔");
		System.out.println("10000엔 - " + a+"장");
		System.out.println("5000엔 - " + b+"장");
		System.out.println("2000엔 - " + c+"장");
		System.out.println("1000엔 - " + d+"장");
		System.out.println("500엔 - " + e+"개");
		System.out.println("100엔 - " + f+"개");
	}
	
	public void printChange(int orginalWon, int c1, int d1, int e1, int f1, int wonChange) {
		System.out.println(orginalWon+"원");
		System.out.println("1000원 - " + c1+"장");
		System.out.println("500원 - " + d1+"개");
		System.out.println("100원 - " + e1+"개");
		System.out.println("50원 - " + f1+"개");
		System.out.println("10원 - " + wonChange/10+"개");
		
	}
}
