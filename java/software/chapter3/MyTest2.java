package chapter3;

public class MyTest2 {
	//소비자가 세금 가격 (2021.04.01) 최한솔
	public static void main(String[] args) {
		String[] kopo41_item = {"맛동산", "웨하스", "롯데센드", "오땅", "사브레"}; // 상품의 명칭을 배열로 지정
		int[] kopo41_price = {1000, 2000, 3000, 2500, 1450}; // 상품의 가격을 배열로 지정
		int[] kopo41_amount = {10,2,1,3,5}; // 상품 수량을 배열로 지정
		double kopo41_tax_rate = 0.1; // 세율 10%
		int kopo41_total_sum=0;	// 계산되는 총 가격
		
		System.out.printf("****************************************\n");
		System.out.printf("              구입한 과자들                \n");
		System.out.printf("항 목      단 가 수 량     합  계    \n");
		for(int i=0; i<kopo41_item.length; i++) {
			int kopo41_sum = kopo41_price[i] * kopo41_amount[i]; // 각 인덱스에 맞게 가격과 수량을 곱해 상품종류별 가격을 구한다.
			kopo41_total_sum = kopo41_total_sum + kopo41_sum;	// 누적으로 더해 총 지불할 가격을 구한다.
			System.out.printf("%.5s  %7d   %2d   %7d\n", kopo41_item[i], kopo41_price[i], kopo41_amount[i], kopo41_sum);
			// 오른쪽 정렬은 %+숫자d    왼쪽 정렬은 %-숫자d
		}
		System.out.printf("****************************************\n");
		System.out.printf("지불 금액 :   %20d\n", kopo41_total_sum); // 누적 연산한 총 지불 금액을 출력
		
		int kopo41_total_net_price = (int)(kopo41_total_sum/(1+kopo41_tax_rate)); 
		// 세전가격을 정수화 해서 소수점을 버림으로써 세전가격이 줄어든다.
		System.out.printf("과세 금액 :   %20d\n", kopo41_total_net_price); 
		int kopo41_tax = kopo41_total_sum - kopo41_total_net_price;  
		// 소비자가격에서 정수화해서 줄어든 세전가격을 뺌으로써 실제 소비자가 지불할 세금이 늘어난다.
		System.out.printf("세   금  :   %20d\n", kopo41_tax);
	}
}
