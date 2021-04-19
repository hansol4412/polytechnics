package chapter5;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test55 {

	//영수증 출력3 최한솔
		public static int kopo41_netprice(int kopo41_price, double kopo41_rate) {
			// static을 이용해서 클래스 내에서 kopo41_netprice 메소드를 자유롭게 사용할 수 있게 한다.
			// kopo41_price, kopo41_rate 매개변수를 사용하여 함수를 호출할 때 값을 불러온다
			return (int)(kopo41_price/(1+kopo41_rate)); // 세전가격을 정수화 해서 소수점을 버린다.
		}
		public static void main(String[] args) {
			String[] kopo41_itemname= {"해피홈 aaa핸드크림","원형 유리화병","상투과자E","더블링 나일론 깡 롤","해피홈 핸드워시","농심 신라면",
					"국내산삽겹살","오뚜기 진비빔면 156g", "GAP 죽장사과 6입", "순 유기농 바나나","피코크 들깨미역국","남양 맛있는 우유GT",
					"녹차원흑당시럽10입", "진라면 소컵(매)65g*6","케라시스 앱플 트리트먼트","푸르밀 미숫가루우유","자일갈색설탕500g","CJ 비비고칩",
					"피코크 들깨고기500","흑원당 말차 밀크티","1+ 등급란 10개입 특","동원양반볶음", "목캔디 허브민트", "원링노트 3매유선",
					"광동)감귤500ML","허쉬초코바","애호박","논산양상추","aaaaaaaaaaaaaasssaaaaaaaaa","농심닭다리너겟"}; //상품명
			int[] kopo41_price= {10000000,6900,5980,3300,5500,3380,6610,2750,10800,4980,3980,4480,
						         4980,3210,6950,2980,1990,1980000,3980,4480,3480,7980,700,1000,
						         1600,4000,1360,1180,3180,9990000}; //상품가격
			int[] kopo41_num= {9,10,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,3,1,2,1,1,1,2}; //상품 쇼핑 품목 수
			boolean[] kopo41_tax= {true,true,true,true,true,true,false,true,false,false,true,false,
					true,true,true,true,true,true,true,true,true,true,true,true,
					true,true,false,false,true,true}; //면세이면 false, 면세 아니면 true
			
			Calendar kopo41_calt1 = Calendar.getInstance(); //현재 시간 불러오기
			SimpleDateFormat kopo41_sdt = new SimpleDateFormat("YYYY-MM-dd HH:mm"); //날짜와 시간 형식 지정하기
			SimpleDateFormat kopo41_sdt2 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); //날짜와 시간 형식 지정하기
			SimpleDateFormat kopo41_sdt3 = new SimpleDateFormat("YYYYMMdd"); //날짜와 시간 형식 지정하기
			DecimalFormat kopo41_df = new DecimalFormat("###,###,###,###,###"); // 가격 콤마찍기 형식
			
			System.out.printf("\n            이마트 죽전점 (031)888-1234\n");
			System.out.printf("   emart    206-86-50913 강희석\n");
			System.out.printf("\t    용인 수지구 포은대로 552\n\n");
			System.out.printf("영수증 미지참시 교환/환불 불가\n");
			System.out.printf("정상상품에 한함, 30일 이내(신선 7일)\n");
			System.out.printf("※일부 브랜드매장 제외(매장 고지물참조)\n");
			System.out.printf("교환/환불 구매점에서 가능(결제카드 지참)\n\n");
			System.out.printf("[구 매]%s     POS:0011-9861\n",kopo41_sdt.format(kopo41_calt1.getTime())); //현재 시간찍기
			System.out.printf("-----------------------------------------\n");
			System.out.printf(" 상 품 명          단 가  수량      금 액\n");
			System.out.printf("-----------------------------------------\n");
			for(int kopo41_i=0; kopo41_i<kopo41_itemname.length; kopo41_i++) { //0부터 상품명 끝까지 반복문
				if(kopo41_tax[kopo41_i]==false){ // 면세가 이면
					System.out.print("*"); // 별찍기
				} else {
					System.out.print(" "); //비면세 항목이면 빈칸 찍기
				}

				System.out.printf("%s%s %2d %s\n", // 구매 상품 정보 출력
						 kopo41_hanBlankBackword(kopo41_itemname[kopo41_i],16),
						 kopo41_hanBlankForeword(kopo41_df.format(kopo41_price[kopo41_i]),10),
						 kopo41_num[kopo41_i],
						 kopo41_hanBlankForeword(kopo41_df.format(kopo41_price[kopo41_i]*kopo41_num[kopo41_i]),10));
				
				if((kopo41_i+1)%5==0) { //상품이 5개마다 줄 넣기
					System.out.printf("-----------------------------------------\n");
				}
			}
			System.out.printf("\n");
			System.out.printf("        %14s%s\n","총 품목 수량", kopo41_hanBlankForeword(kopo41_itemname.length+"",14)); // 총 품목의 갯수
			int kopo41_dutyfree = 0; //면세물품 총 가격 구하기
			int kopo41_duty = 0; //면세가 아닌 물품 총 가격 구하기
			for(int kopo41_i=0; kopo41_i<kopo41_itemname.length; kopo41_i++) {
				if(kopo41_tax[kopo41_i]== false) { // 면세 총 가격 구하기
					kopo41_dutyfree+=kopo41_price[kopo41_i]*kopo41_num[kopo41_i];
				} else { // 비면세 총 가격 구하기
					kopo41_duty+=kopo41_price[kopo41_i]*kopo41_num[kopo41_i];
				}
			
			}
			int kopo41_netPrice = kopo41_netprice(kopo41_duty, 0.1); // 비면세 품목 세전금액 구하기
			int kopo41_totalsum = kopo41_dutyfree+kopo41_duty; // 전체 가격 
			System.out.printf("%s%s\n",kopo41_hanBlankForeword("(*)면 세  물 품",27), kopo41_hanBlankForeword(kopo41_df.format(kopo41_dutyfree),14)); // 면세가격 총합
			System.out.printf("%s%s\n",kopo41_hanBlankForeword(" 과 세  물 품",27),kopo41_hanBlankForeword(kopo41_df.format(kopo41_netPrice),14)); // 비면세 가격 총합
			System.out.printf("%s%s\n",kopo41_hanBlankForeword("부   가   세",27),kopo41_hanBlankForeword(kopo41_df.format(kopo41_duty-kopo41_netPrice),14)); // 비면세 가격의 세금
			//과세 총 가격에서 세전금액을 빼서 세금을 구한다.
			System.out.printf("%s%s\n",kopo41_hanBlankForeword("합        계",27),kopo41_hanBlankForeword(kopo41_df.format(kopo41_totalsum),14)); //비면세 가격과 면세 가격의 총합
			System.out.printf("%s%s\n","결 제 대 상 금 액",kopo41_hanBlankForeword(kopo41_df.format(kopo41_totalsum),24)); // 소비자 가격
			System.out.printf("------------------------------------------\n");
			System.out.printf("0012 KEB 하나       541707**0484/35860658\n");
			System.out.printf("카드결제(IC)     %7s / %s\n","일시불",kopo41_hanBlankForeword(kopo41_df.format(kopo41_totalsum),11)); //소비자 가격
			System.out.printf("------------------------------------------\n");
			System.out.printf("           [신세계 포인트 적립]\n");
			System.out.printf("최*솔 고객님의 포인트 현황입니다.\n");
			int kopo41_point = kopo41_totalsum/1000; // 전체 가격을 1000으로 나눠서 포인트를 구한다.
			System.out.printf("금회발생포인트\t       9350**9995%s\n",kopo41_hanBlankForeword(kopo41_df.format(kopo41_point),8)); 
			int kopo41_ponit2 = 5473; // 쇼핑 전 누적 포인트
			System.out.printf("누계(가용)포인트%s(%s)\n",kopo41_hanBlankForeword(kopo41_df.format(kopo41_ponit2+kopo41_point),14),kopo41_hanBlankForeword(kopo41_df.format(kopo41_ponit2),9));
			// 전의 포인트 가격 지정하고 쇼핑 후 적립되는 포인트를 더해 누적 포인트를 구한다.
			System.out.printf("*신세계포인트 유효기간은 2년입니다.\n");
			System.out.printf("-----------------------------------------\n");
			System.out.printf("  구매금액기준 무료주차시간 자동부여\n");
			System.out.printf("차량번호 :                       34저****\n");
			System.out.printf("입차시간 :            %s\n",kopo41_sdt2.format(kopo41_calt1.getTime())); //초까지 나오는 현재시간
			System.out.printf("-----------------------------------------\n");
			System.out.printf("캐셔:084599 양OO\t             1150\n");
			System.out.printf("      %s/00119861/00164980/31\n",kopo41_sdt3.format(kopo41_calt1.getTime()));
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



