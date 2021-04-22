package kyd;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException{
		// 환율계산기
		Input in = new Input();
		Rate rateSelect = new Rate();
		Calculator cal = new Calculator();
		File f = new File();
		Variable val;
		
		int choice;
		int input ;
		while(true){
				input = in.getInput();
				if(input == ConstValue.EX_TYPE_EXIT) break;
				choice = in.getChice();
				double rate = rateSelect.rate(choice) ;
				
				int exchange_moneyInt = cal.getExchange_moneyInt(input, rate);
				int wonChange = cal.getWonChange(input, rate, exchange_moneyInt);
				
				val = new Variable(choice,input,exchange_moneyInt,wonChange);
				
				cal.exchange(val.choice, val.exchange_moneyInt);
				cal.change(val.wonChange);
				f.fileWriter(val);
		}
		
	}
}

