package chapter5;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test44 {

	public static int kopo41_netprice(int kopo41_price, double kopo41_rate) {
		// static을 이용해서 클래스 내에서 kopo41_netprice 메소드를 자유롭게 사용할 수 있게 한다.
		// kopo41_price, kopo41_rate 매개변수를 사용하여 함수를 호출할 때 값을 불러온다
		return (int)(kopo41_price/(1+kopo41_rate)); // 세전가격을 정수화 해서 소수점을 버린다.
	}
	public static void main(String[] args) {
		SimpleDateFormat kopo41_sdt3 = new SimpleDateFormat("YYYYMMdd"); //날짜와 시간 형식 지정하기
		//상품 1의 정보 (이름, 코드, 가격, 수량)
		String kopo41_itemname1="퓨어에어 aaaa비말차단용마스크(최고급형)";
		String kopo41_itemcode1="1031615";
		int price1 = 9000000;
		int amount1 = 10;
		
		//상품 2의 정보 (이름, 코드, 가격, 수량)
		String kopo41_itemname2="슬라이드식명찰";
		String kopo41_itemcode2="11008152";
		int price2 = 0;
		int amount2 = 1;
		
		//상품 3의 정보 (이름, 코드, 가격, 수량)
		String kopo41_itemname3="매직흡착 인테리어후크(알루미늄타입)";
		String kopo41_itemcode3="1020800";
		int price3 = 0;
		int amount3 = 1;
		
		Calendar kopo41_calt1 = Calendar.getInstance(); //현재 시간 불러오기
		Calendar kopo41_calt2 = Calendar.getInstance(); //현재 시간 불러오기
		SimpleDateFormat kopo41_sdt1 = new SimpleDateFormat("MM월dd일"); //날짜와 시간 형식 지정하기
		SimpleDateFormat kopo41_sdt2 = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss"); //날짜와 시간 형식 지정하기
		DecimalFormat kopo41_df = new DecimalFormat("###,###,###,###,###"); // 가격 콤마찍기 형식
		
		int kopo41_totalSum = price1*amount1 + price2*amount2 + price3*amount3; //상품의 총 가격 (가격 * 수량)
		int kopo41_netPrice = kopo41_netprice(kopo41_totalSum, 0.1); 
		// 총 가격과 세율을 매개변수로 주고 세전금액 구하기 위해 함수를 호출
		int kopo41_tax = kopo41_totalSum-kopo41_netPrice; 
		// 지정한 소비자가격에서 정수화한 세전가격을 빼서 세금을 계산한다.
		
		System.out.printf("\n\t   \"국민가게, 다이소\"\n");
		System.out.printf("(주)아성다이소_분당서현점\n");
		System.out.printf("전화:031-702-6016\n");
		System.out.printf("본사:서울 강남구 남부순환로 2748 (도곡동)\n");
		System.out.printf("대표:박정부,신호섭 213-81-52063\n");
		System.out.printf("매장:경기도 성남시 분당구 분당로53번길 11 \n(서현동)\n");
		System.out.printf("=========================================\n");
		System.out.printf("      소비자중심경영(CCM) 인증기업\n");
		System.out.printf("    ISO 9001 품질경영시스템 인증기업\n");
		
		System.out.printf("=========================================\n");
		kopo41_calt1.add(Calendar.DATE, 14); // 현재 일자에서 14일을 더해 교환/환불의 유효기간을 구한다.
		System.out.printf("      %s(%s)이내,\n","교환/환불 14일" ,kopo41_sdt1.format(kopo41_calt1.getTime())); 
		//교환, 환불 유효기간 포맷에 맞춰서 출력하기
		System.out.printf("     (전자)영수증, 결제카드 지참 후 \n           구입매장에서 가능\n");
		System.out.printf("   포장/가격 택 훼손시 교환/환불 불가\n");
		System.out.printf("     체크카드 취소 시 최대 7일 소요\n");
		System.out.printf("=========================================\n");
		System.out.printf("[POS 1058231]\t      %s\n",kopo41_sdt2.format(kopo41_calt2.getTime()));
		System.out.printf("=========================================\n");
		//현재 시간 포맷에 맞춰서 출력하기
		
		System.out.printf("%s%s %2d %9s\n",kopo41_hanBlankBackword(kopo41_itemname1,17),
				kopo41_hanBlankForeword(kopo41_df.format(price1),10),amount1, 
				kopo41_hanBlankForeword(kopo41_df.format(price1*amount1),10) );
		//상품1의 쇼핑 정보 출력 : 상품명 14글자까지만 나오도록 출력, 가격과 총 가격은 숫자에 콤마찍어서 출력하기
		System.out.printf("[%s]\t\n",kopo41_itemcode1); //상품1의 코드
		System.out.printf("%s%s %2d %9s\n",kopo41_hanBlankBackword(kopo41_itemname2,17),
				kopo41_hanBlankForeword(kopo41_df.format(price2),10),amount2, 
				kopo41_hanBlankForeword(kopo41_df.format(price2*amount2),10) );
		//상품2의 쇼핑 정보 출력 : 상품명 14글자까지만 나오도록 출력, 가격과 총 가격은 숫자에 콤마찍어서 출력하기
		System.out.printf("[%s]\t\n",kopo41_itemcode2);
		System.out.printf("%s%s %2d %9s\n",kopo41_hanBlankBackword(kopo41_itemname3,17),
				kopo41_hanBlankForeword(kopo41_df.format(price3),10),amount3, 
				kopo41_hanBlankForeword(kopo41_df.format(price3*amount3),10) );

		//상품3의 쇼핑 정보 출력 : 상품명 14글자까지만 나오도록 출력, 가격과 총 가격은 숫자에 콤마찍어서 출력하기
		System.out.printf("[%s]\t\n",kopo41_itemcode3);
		System.out.printf("        과세합계%s\n", kopo41_hanBlankForeword(kopo41_df.format(kopo41_netPrice),25)); //세전 가격
		System.out.printf("\t  부가세%s\n", kopo41_hanBlankForeword(kopo41_df.format(kopo41_tax),25)); //세금
		System.out.printf("-----------------------------------------\n");
		System.out.printf("판매합계\t\t       %-10s\n",kopo41_hanBlankForeword(kopo41_df.format(kopo41_totalSum),10)); //세후 가격
		System.out.printf("=========================================\n");
		System.out.printf("신용카드\t\t       %-10s\n",kopo41_hanBlankForeword(kopo41_df.format(kopo41_totalSum),10));
		System.out.printf("-----------------------------------------\n");
		System.out.printf("우리카드\t\t 538720**********\n");
		System.out.printf("승인번호 77982843(0)  승인금액 %s\n",kopo41_hanBlankForeword(kopo41_df.format(kopo41_totalSum),10));
		System.out.printf("=========================================\n");
		System.out.printf("    %s  분당서현점\n",kopo41_sdt2.format(kopo41_calt2.getTime())); //현재 시간 출력
		System.out.printf("상품 및 기타 문의 : 1522-4400\n");
		System.out.printf("멤버십 및 샵다이소 관련 문의 : 1599-2211\n");
		System.out.printf("\t    2112820610158231\n");
		System.out.printf("-----------------------------------------\n");
		System.out.printf("   ◈ 다이소 멤버십 앱 또는 홈페이지에 \n        접속하셔서 회원가입 후 \n      다양한 혜택을 누려보세요! ◈");
		
	}
	public static String kopo41_hanBlankForeword(String kopo41_str, int kopo41_num) {
		StringBuilder kopo41_sb = new StringBuilder(); 
		  //문자열을 더하는 행위에서 매모리 할당과 메모리 해제에서 발생하는 비효율을 방지
        String kopo41_curChar; // 문자열을 하나씩 나누기 위한 변수
        int kop41_curLen = 0; //하나씩 나눈 문자열의 총 바이트 수를 구하기 위한 변수
       
        for (int i = 0; i < kopo41_str.length(); i++) //문자열 크기 만클 반복문을 돌린다.
        {
      	  kopo41_curChar = kopo41_str.substring(i, i + 1); //문자열을 하나씩 나눈다
      	  if (kop41_curLen + kopo41_curChar.getBytes().length > kopo41_num) {
      		  //주어진 바이트 총 수 보다 계산한 바이트 수가 커지면 반복문 나가기
      		  break;
      	  } else {
          	  kop41_curLen += kopo41_curChar.getBytes().length; //하나씩 나눈 문자열의 바이트 수를 더한다.
          	  kopo41_sb.append(kopo41_curChar); // 문자열 더하기
            } 	  
        }
        String kopo41_strF = kopo41_sb.toString(); //매개변수에서 받은 문자 변수에 할당하기
        
        String kopo41_ret_str =""; //초기 문자열 설정
        for(int kopo41_i=0; kopo41_i<(kopo41_num-kop41_curLen);kopo41_i++) {
			// 지정한 문자길이에서 바이트 배열의 수를 뺀 만큼을 공백을 찍는다
			kopo41_ret_str=kopo41_ret_str+" ";
        }
        kopo41_ret_str=kopo41_ret_str+kopo41_strF;
        //공백을 추가한 앞에 문자열을 더한다
        return kopo41_ret_str; //문자열 리턴
	}
	
	public static String kopo41_hanBlankBackword(String kopo41_str, int kopo41_num) {
		  StringBuilder kopo41_sb = new StringBuilder(); 
		  //문자열을 더하는 행위에서 매모리 할당과 메모리 해제에서 발생하는 비효율을 방지
        String kopo41_curChar; // 문자열을 하나씩 나누기 위한 변수
        int kop41_curLen = 0; //하나씩 나눈 문자열의 총 바이트 수를 구하기 위한 변수
       
        for (int i = 0; i < kopo41_str.length(); i++) //문자열 크기 만클 반복문을 돌린다.
        {
      	  kopo41_curChar = kopo41_str.substring(i, i + 1); //문자열을 하나씩 나눈다
      	  if (kop41_curLen + kopo41_curChar.getBytes().length > kopo41_num) {
      		  //주어진 바이트 총 수 보다 계산한 바이트 수가 커지면 반복문 나가기
      		  break;
      	  } else {
          	  kop41_curLen += kopo41_curChar.getBytes().length; //하나씩 나눈 문자열의 바이트 수를 더한다.
          	  kopo41_sb.append(kopo41_curChar); // 문자열 더하기
            } 	  
        }
        
        String kopo41_strB = kopo41_sb.toString(); //자른 문자열을 변수로 지정
        String kopo41_ret_str =""; //초기 문자열 설정
        for(int kopo41_i=0; kopo41_i<(kopo41_num-kop41_curLen);kopo41_i++) {
			// 지정한 문자길이에서 바이트 배열의 수를 뺀 만큼을 공백을 찍는다
			kopo41_ret_str=kopo41_ret_str+" ";
        }
        kopo41_ret_str=kopo41_strB+kopo41_ret_str;
        //공백을 추가한 앞에 문자열을 더한다
        return kopo41_ret_str; //문자열 리턴
	}
}
