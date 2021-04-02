package kyd;

public class Rate {
	public double rate(int choice) {
		if(choice == ConstValue.EX_TYPE_USD) {
			return ConstValue.EX_RATE_USD;
		} else if(choice== ConstValue.EX_TYPE_EUR) {
			return ConstValue.EX_RATE_EUR;
		} else if(choice== ConstValue.EX_TYPE_JPY){
			return ConstValue.EX_RATE_JPY;
		} else {
			System.out.println("환전 종류 선택을 잘못 입력했습니다. 달러로 계산합니다.");
			return ConstValue.EX_RATE_USD;
		}
	}
}
