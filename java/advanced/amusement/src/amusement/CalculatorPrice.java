package amusement;
	//������ �������� ������ ������ ���� ����ϴ� Ŭ����
public class CalculatorPrice {
	public int totalPrice;
	
	public CalculatorPrice() {
		this.totalPrice = 0;
	}
	
	//�߰� �ݾ� ���ϱ�
	public int eachPrice(int price, int count, double rate) {
		int eachPrice = (int)(price*count*rate);
		return eachPrice;
	}
	
	//���� �ݾ� ���ϱ�
	public int totalPrice(int price) {
		totalPrice += price;
		return totalPrice;
	}
	
}
