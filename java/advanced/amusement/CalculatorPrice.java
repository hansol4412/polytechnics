package amusement;
	//갯수와 할인율을 적용한 각각의 가격 계산하는 클래스
public class CalculatorPrice {

	public int eachPrice(int price, int count, double rate) {
		int eachPrice = (int)(price*count*rate);
		return eachPrice;
	}
	
}
