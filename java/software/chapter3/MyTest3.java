package chapter3;

public class MyTest3 {
	// 단순 환전 계산 (2021.4.1) 최한솔
	public static void main(String[] args) {
		int kopo41_MyWon = 1000000; //환전할 금액
		double kopo41_MoneyEx = 1238.21; //환율
		double kopo41_commission = 0.003; //환전 수수료
		
		int kopo41_usd = (int)(kopo41_MyWon/kopo41_MoneyEx); 
		// 원화를 환율로 나누면 실수가 나올 수 있다.
		// 소숫점은 돈으로 제공할 수 없기 때문에 정수형으로 잘라서 환전금액 부여
		int kopo41_remain = (int)(kopo41_MyWon-kopo41_usd*kopo41_MoneyEx); 
		// 원화에서 환전한 금액을 빼고 환전하지 못한 남은 금액은 다시 원화로 부여한다.
		// 여기서도 소수점은 지불할 수 없기 때문에 정수형으로 변환해서 거스름 돈을 준다. 
		System.out.printf("********************************************\n");
		System.out.printf("*               수수료 없이 계산               *\n");
		System.out.printf("총 한화환전금액:%d원 => 미화:%d달러, 잔돈:%d원\n",kopo41_MyWon, kopo41_usd, kopo41_remain);
		System.out.printf("********************************************\n");
	}

}
