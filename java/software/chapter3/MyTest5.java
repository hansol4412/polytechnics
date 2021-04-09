package chapter3;

public class MyTest5 {
	// 수수료 포함 환전 계산2 (2021.4.1) 최한솔
	public static void main(String[] args) {
		int kopo41_MyWon = 1000000; //환전할 금액
		double kopo41_MoneyEx = 1238.21; //환율
		double kopo41_commission = 0.003; //환전 수수료
		
		int kopo41_usd = (int)(kopo41_MyWon/kopo41_MoneyEx); 
		// 원화를 환율로 나누면 실수가 나올 수 있다.
		// 소숫점은 돈으로 제공할 수 없기 때문에 정수형으로 잘라서 환전금액 부여
		
		double kopo41_ComPerOne = kopo41_MoneyEx * kopo41_commission; // 달러 당 수수료
		double kopo41_totalcom = kopo41_usd * kopo41_ComPerOne; // 전체 수수료 = 환전금액(정수) * 달러당 수수료
		
		int kopo41_i_totalcom; // 달러당 수수료 정수형으로 고치기 위한 변수 선언
		
		if(kopo41_totalcom != (double)((int)kopo41_totalcom)) {
			kopo41_i_totalcom = (int)kopo41_totalcom+1;
		} else {
			kopo41_i_totalcom = (int)kopo41_totalcom;
		}
		
		System.out.printf("************************************************************\n");
		System.out.printf("*                    수수료 적용환전                           *\n");
		System.out.printf(" 총 수수료: %d 원 => 미화:%d달러, 달러당수수료: %f원\n",kopo41_i_totalcom, kopo41_usd, kopo41_ComPerOne);
		int kopo41_remain = (int)(kopo41_MyWon-kopo41_usd*kopo41_MoneyEx - kopo41_i_totalcom);
		System.out.printf("총 한화환전금액: %d원 => 미화:%d달러, 수수료장수: %d원, 잔돈 : %d\n",kopo41_MyWon, kopo41_usd, kopo41_i_totalcom,kopo41_remain);
		System.out.printf("************************************************************\n");

	}

}
