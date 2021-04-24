package kyd;

public class Calculator {
	ProcessiongClass pc = null;
	
	public Calculator() {
		pc = new ProcessiongClass();
	}

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
		pc.change(wonChange);
	}
}
