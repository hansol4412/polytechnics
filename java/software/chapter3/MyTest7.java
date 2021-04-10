package chapter3;

import java.text.DecimalFormat;

public class MyTest7 {
	// 콤마찍기 (2021.4.1) 최한솔
	public static void main(String[] args) {
		DecimalFormat kopo41_df = new DecimalFormat("###,###,###,###,###");
		// 정수의 형식을 정하기 위한 클래스
		
		int kopo41_MyWon = 1000000; //환전할 금액
		double kopo41_MoneyEx = 1238.21; //환율
		double kopo41_commission = 0.003; //환전 수수료
		double kopo41_ComPerOne = kopo41_MoneyEx * kopo41_commission; // 달러 당 수수료
		
		int kopo41_usd = (int)(kopo41_MyWon/(kopo41_MoneyEx + kopo41_ComPerOne )); 
		// 환전 금액 = (int)(환전할 금액/ (환율 + 달러당 수수료));
		// => 달러당 수수료를 나중에 계산해서 더하면 잔돈이 음수로 나올 수 있다. 
		// 그래서 환전 금액을 계산할 떄 환율과 달러당 수수료를 같이 더해 계산한다. 
		
		double kopo41_totalcom = kopo41_usd * kopo41_ComPerOne; // 전체 수수료 = 환전금액(정수) * 달러당 수수료
		
		int kopo41_i_totalcom; // 전체 수수료를 정수형으로 고치기 위한 변수 선언
		
		if(kopo41_totalcom != (double)((int)kopo41_totalcom)) { 
			// 전체 수수료를 정수화 해서 소숫점을 버림했을 때 전체 수수료가 적어지기 때문에 정수화 전의 전체 수수료와 다를 때 1을 추가해 손실을 없앤다.
 			kopo41_i_totalcom = (int)kopo41_totalcom+1;
		} else {
			kopo41_i_totalcom = (int)kopo41_totalcom;
			// 정수화 했을 때 전체수수료의 변화가 없다면 손해가 없기 때문에 1을 추가하지 않는다.
		}
		
		System.out.printf("************************************************************\n");
		System.out.printf("*                (정확한) 수수료 적용환전                        *\n");
		System.out.printf(" 총 수수료: %s 원 => 미화:%s달러, 달러당수수료: %f원\n",
				kopo41_df.format(kopo41_i_totalcom), kopo41_df.format(kopo41_usd), kopo41_ComPerOne);
		int kopo41_remain = (int)(kopo41_MyWon-kopo41_usd*kopo41_MoneyEx - kopo41_i_totalcom);
		System.out.printf("총 한화환전금액: %s원 => 미화:%s달러, 수수료장수: %s원, 잔돈 : %s\n",
				kopo41_df.format(kopo41_MyWon), kopo41_df.format(kopo41_usd),kopo41_df.format(kopo41_i_totalcom), kopo41_df.format(kopo41_remain));
		System.out.printf("************************************************************\n");
		//숫자에 적용할 때 객체명.format(변수)로 사용한다.
	}

}
