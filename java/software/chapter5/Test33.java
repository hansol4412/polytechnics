package chapter5;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Test33 {
	//영수증 출력1 최한솔
		public static int kopo41_netprice(int kopo41_price, double kopo41_rate) {
			// static을 이용해서 클래스 내에서 kopo41_netprice 메소드를 자유롭게 사용할 수 있게 한다.
			// kopo41_price, kopo41_rate 매개변수를 사용하여 함수를 호출할 때 값을 불러온다
			if(kopo41_price<=10) {
				return (int)(kopo41_price/(1+kopo41_rate));
			}
			return (int)(kopo41_price/(1+kopo41_rate))+1; // 세전가격을 정수화 해서 소수점을 버리고 1을 더한다.
		}
		public static void main(String[] args) {
			Calendar kopo41_calt = Calendar.getInstance(); //현재 시간 불러오기
			SimpleDateFormat kopo41_sdt = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss"); //날짜와 시간 형식 지정하기
			DecimalFormat kopo41_df = new DecimalFormat("###,###,###,###,###"); // 가격 콤마찍기 형식
			
			int kopo41_iPrice =9; //소비자가 실제 지불하는 가격, 세후가격
			double kopo41_tax_rate = 0.1; // 세율
			int kopo41_netPrice = kopo41_netprice(kopo41_iPrice, kopo41_tax_rate); 
			//소비자가와 세율을 매개변수로 해서 세전가격을 구한다.
			int kopo41_tax = kopo41_iPrice-kopo41_netPrice; 
			// 지정한 소비자가격에서 정수화한 세전가격을 빼서 세금을 계산한다.
		
			System.out.printf("\n신용승인 \n");
			System.out.printf("단말기 : 2N68665898     전표번호 : 041218\n");
			System.out.printf("가맹점 : 한양김치찌개\n");
			System.out.printf("주  소 : 경기 성남시 분당구 황새울로351번 \n길 10 ,1층 \n");
			System.out.printf("대표자 : 유창신\n");
			System.out.printf("사업자 : 752-53-00558\t    TEL : 7055695\n");
			System.out.println("- - - - - - - - - - - - - - - - - - - - -");
			System.out.printf("금  액  \t\t   %12s 원\n",kopo41_df.format(kopo41_netPrice)); //숫자에 콤마 찍기 위해 포맷적용, 오른족 정렬
			System.out.printf("부가세  \t\t   %12s 원\n",kopo41_df.format(kopo41_tax)); //숫자에 콤마 찍기 위해 포맷적용, 오른족 정렬
			System.out.printf("합  계  \t\t   %12s 원\n",kopo41_df.format(kopo41_iPrice)); //숫자에 콤마 찍기 위해 포맷적용, 오른족 정렬
			System.out.println("- - - - - - - - - - - - - - - - - - - - -");
			System.out.printf("우리카드 \n");
			System.out.printf("카드번호 : 5387-20**-****-4613(S)  일시불\n");
			System.out.printf("거래일시 : %s\n", kopo41_sdt.format(kopo41_calt.getTime())); //날짜를 포맷에 맞춰서 출력
			System.out.printf("승인번호 : 70404427\n");
			System.out.printf("거래번호 : 357734873739\n");
			System.out.printf("매입 : 비씨카드사       가맹 : 720068568\n");
			System.out.printf("알림 : EDC매출표\n");
			System.out.printf("문의 : TEL)1544-4700\n");
			System.out.println("- - - - - - - - - - - - - - - - - - - - -");
			System.out.printf("\t     * 감사합니다 * \n");
			System.out.printf("\t\t       표준V2.08_20200212\n");
		}
}




