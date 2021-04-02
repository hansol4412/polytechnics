package kyd;
public class Main {

	public static void main(String[] args) {
		// 환율계산기
		Input in = new Input();
		Rate rateSelect = new Rate();
		Calculator cal = new Calculator();
		
		int choice;
		do {
				int input = in.getInput();
				choice = in.getChice();
				
				double rate = rateSelect.rate(choice) ;
				
				int exchange_moneyInt = cal.getExchange_moneyInt(input, rate);
				int wonChange = cal.getWonChange(input, rate, exchange_moneyInt);
				
				cal.exchange(choice, exchange_moneyInt);
				cal.change(wonChange);
				
		}while(choice != ConstValue.EX_TYPE_EXIT);
	}
}

