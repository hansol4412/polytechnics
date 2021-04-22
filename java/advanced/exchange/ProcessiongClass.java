package kyd;

public class ProcessiongClass {
	Print print = null;
	
	public ProcessiongClass() {
		print = new Print();
	}


	public void exchangeUSD(int exchange_moneyInt) {
		int orginalExchange_moneyInt = exchange_moneyInt;
		
		int a = (int)(exchange_moneyInt/100);
		exchange_moneyInt = exchange_moneyInt - a*100;

		int b = (int)(exchange_moneyInt/50);
		exchange_moneyInt = exchange_moneyInt - b*50;
		
		int c = (int)(exchange_moneyInt/20);
		exchange_moneyInt = exchange_moneyInt - c*20;
		
		int d = (int)(exchange_moneyInt/10);
		exchange_moneyInt = exchange_moneyInt - d*10;
		
		int e = (int)(exchange_moneyInt/5);
		exchange_moneyInt = exchange_moneyInt - e*5;
		
		int f = (int)(exchange_moneyInt/2);
		exchange_moneyInt = exchange_moneyInt - f*2;
		
		print.printExchangeUSD(orginalExchange_moneyInt, a,b,c,d,e,f,exchange_moneyInt);
	}
	

	public void exchangeEUR(int exchange_moneyInt) {
		int orginalExchange_moneyInt = exchange_moneyInt;
		
		int a = (int)(exchange_moneyInt/500);
		exchange_moneyInt = exchange_moneyInt - a*500;
		
		int b = (int)(exchange_moneyInt/200);
		exchange_moneyInt = exchange_moneyInt - b*200;
		
		int c = (int)(exchange_moneyInt/100);
		exchange_moneyInt = exchange_moneyInt - c*100;
		
		int d = (int)(exchange_moneyInt/50);
		exchange_moneyInt = exchange_moneyInt - d*50;
		
		int e = (int)(exchange_moneyInt/20);
		exchange_moneyInt = exchange_moneyInt - e*20;
		
		int f = (int)(exchange_moneyInt/10);
		exchange_moneyInt = exchange_moneyInt - f*10;
		
		int g = (int)(exchange_moneyInt/5);
		exchange_moneyInt = exchange_moneyInt - g*5;
		
		print.printExchangeEUR(orginalExchange_moneyInt, a,b,c,d,e,f,g, exchange_moneyInt);
	}
	
	
	
	public void exchangeJPY(int exchange_moneyInt) {
		int orginalExchange_moneyInt = exchange_moneyInt*100;
		exchange_moneyInt = exchange_moneyInt*100; // 엔화는 100엔 단위
		
		int a = (int)(exchange_moneyInt/10000);
		exchange_moneyInt = exchange_moneyInt - a*10000;

		int b = (int)(exchange_moneyInt/5000);
		exchange_moneyInt = exchange_moneyInt - b*5000;
		
		int c = (int)(exchange_moneyInt/2000);
		exchange_moneyInt = exchange_moneyInt - c*2000;
		
		int d = (int)(exchange_moneyInt/1000);
		exchange_moneyInt = exchange_moneyInt - d*1000;
		
		int e = (int)(exchange_moneyInt/500);
		exchange_moneyInt = exchange_moneyInt - e*500;
		
		int f = (int)(exchange_moneyInt/100);
		exchange_moneyInt = exchange_moneyInt - f*100;
		
		print.printExchangeJPY(orginalExchange_moneyInt,a,b,c,d,e,f);
	}
	
	
	
	
	

}
