package chapter3;

public class MyTest {
	// 소비자가 세금 계산 (2021.04.01) 최한솔
	public static int kopo41_netprice(int kopo41_price, double kopo41_rate) {
		// static을 이용해서 클래스 내에서 kopo41_netprice 메소드를 자유롭게 사용할 수 있게 한다.
		// kopo41_price, kopo41_rate 매개변수를 사용하여 함수를 호출할 때 값을 불러온다
		return (int)(kopo41_price/(1+kopo41_rate)); // 세전가격을 정수화 해서 소수점을 버림으로써 세전가격이 줄어든다.
	}
	public static void main(String[] args) {
		int kopo41_price =1234; //소비자가 실제 지불하는 가격
		double kopo41_tax_rate = 0.1; // 세율
		int kopo41_netPrice = kopo41_netprice(kopo41_price, kopo41_tax_rate); 
		//소비자가와 세율을 매개변수로 해서 kopo41_netprice를 호출한다.
		int kopo41_tax = kopo41_price-kopo41_netPrice; 
		// 지정한 소비자가격에서 정수화한 세전가격을 빼서 세금을 계산한다.
		// 이때 소비자가격에서 정수화해서 줄어든 세전가격을 뺌으로써 실제 소비자가 지불할 세금이 늘어난다.
		
		System.out.printf("***********************************\n");
		System.out.printf("*      소비자가, 세전가격, 세금 계산     *\n");
		System.out.printf("소비자가격: %d 세전가격: %d 세금: %d\n", kopo41_price, kopo41_netPrice, kopo41_tax);
		System.out.printf("***********************************\n");

	}

}
