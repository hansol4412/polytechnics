package chapter4;

import java.text.DecimalFormat;

public class Test14 {
	// 칸 맞춰 인쇄 (최한솔)
	public static void main(String[] args) {
		String kopo41_item = "사과"; //상품명
		int kopo41_unit_price =5000; //가격
		int kopo41_num =500; //수량
		int kopo41_total=0; //총 가격
		
		DecimalFormat df = new DecimalFormat("###,###,###,###,###"); 
		//숫자에 콤마찍기 위한 형식지정
		System.out.printf("===================================================\n");
		System.out.printf("%20.20s%8.8s%8.8s%8.8s\n","품목","단가","수량","합계");
		//.앞에는 전체 폭, 뒤에는 보여질 문자의 갯수이다 => 즉 %20.20s는 20칸을 잡고 20개의 글자만 보여줌
		System.out.printf("===================================================\n");
		System.out.printf("%20.20s%10.10s%10.10s%10.10s\n",
				kopo41_item, df.format(kopo41_unit_price),df.format(kopo41_num),df.format(kopo41_unit_price*kopo41_num));
		//숫자에 콤마를 찍기 위해 형식 적용
		System.out.printf("===================================================\n");
	}
}
