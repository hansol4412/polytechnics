package kyd;

public class Calculator {
	ProcessiongClass pc = new ProcessiongClass();
	Print print = new Print();
	
	public int getExchange_moneyInt(int input, double rate) {
		double exchange_money = input/rate;
		return (int)exchange_money;
	}
	
	public int getWonChange(int input, double rate, int exchange_moneyInt) {
		double won = (input/rate-exchange_moneyInt)*rate;
		return  (int)((won)/10)*10;
	}
	
	public void exchange(int choice, int exchange_moneyInt) {
		if(choice == ConstValue.EX_TYPE_USD) {
			pc.exchangeUSD(exchange_moneyInt);	
		} else if(choice== ConstValue.EX_TYPE_EUR) {
			pc.exchangeEUR(exchange_moneyInt);
		} else if(choice== ConstValue.EX_TYPE_JPY) {
			pc.exchangeJPY(exchange_moneyInt);
		} else {
			pc.exchangeUSD(exchange_moneyInt);
		}
	}
	
	public void change(int wonChange) {
		int orginalWon = wonChange;
		int c1 = (int)(wonChange/1000);
		wonChange = wonChange - c1*1000;
		
		int d1 = (int)(wonChange/500);
		wonChange = wonChange - d1*500;
		
		int e1 = (int)(wonChange/100);
		wonChange = wonChange - e1*100;
		
		int f1 = (int)(wonChange/50);
		wonChange = wonChange - f1*50;
		
		print.printChange(orginalWon,c1, d1, e1, f1, wonChange);
	}
}
