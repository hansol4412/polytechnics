package chapter6;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test1 {
		//영수증 출력 함수로 나누기 (최한솔)
		public static DecimalFormat kopo41_df = new DecimalFormat("###,###,###,###,###"); // 가격 콤마찍기 형식
		public static Calendar kopo41_calt1 = Calendar.getInstance(); //현재 시간 불러오기
		public static String[] kopo41_itemname= {"해피홈 핸드크림","원형 유리화병","상투과자E","더블링 나일론 깡 롤","해피홈 핸드워시","농심 신라면",
				"국내산삽겹살찌개","오뚜기 진비빔면 156g", "GAP 죽장사과 6입", "순 유기농 바나나","피코크 들깨미역국","남양 맛있는 우유GT",
				"녹차원흑당시럽10입", "진라면 소컵(매)65g*6","케라시스 앱플 트리트먼트","푸르밀 미숫가루우유","자일로스갈색설탕500g","CJ 비비고칩",
				"피코크 들깨고기국500","흑원당 말차 밀크티","1+ 등급란 10개입 특","동원양반볶음김치기획", "목캔디 허브민트", "원링노트 3매유선",
				"광동)감귤500ML","허쉬초코바","애호박","논산양상추","마리오케이퍼","농심닭다리너겟"}; //상품명
		public static int[] kopo41_price= {7500,6900,5980,3300,5500,3380,6610,2750,10800,4980,3980,4480,
			     4980,3210,6950,2980,1990,1980,3980,4480,3480,7980,700,1000,
			     1600,4000,1360,1180,3180,1980}; //상품가격
		public static int[] kopo41_num= {2,1,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,3,1,2,1,1,1,1}; //상품 품목수
		public static boolean[] kopo41_taxfree= {true,true,true,true,true,true,false,true,false,false,true,false,
				true,true,true,true,true,true,true,true,true,true,true,true,
				true,true,false,false,true,true}; //면세이면 false, 면세 아니면 true
			
		public static int kopo41_netprice(int kopo41_price, double kopo41_rate) {
			// 소비자 가격, 세율을 매개변수를 사용하여 함수를 호출할 때 값을 불러온다
			return (int)(kopo41_price/(1+kopo41_rate)); // 세전가격을 정수화 해서 소수점을 버린다.
		}
			
		public static void main(String[] args) {
			int kopo41_itemCount = 30; // 쇼핑 항목 수
			
			kopo41_TitlePrint(); // 영수증 맨 위 타이틀 인쇄
			kopo41_TimeStamp();  // 출력시간 인쇄
			kopo41_headerPrint(); // 해더(상품명, 단가, 수량, 금액) 인쇄
				
			for(int kopo41_i=0; kopo41_i<kopo41_itemCount; kopo41_i++) {
				kopo41_itemPrint(kopo41_i); // 항목 갯수만큼 항목 인쇄	
				}
			
			kopo41_totalPrint(); //합계 세액 등을 인쇄
			}
			
			public static void kopo41_TitlePrint() { // 영수증 맨 위 타이틀 인쇄
				System.out.printf("\t\t이마트 죽전점 (031)888-1234\n");
				System.out.printf("      emart\t206-86-50913 강희석\n");
				System.out.printf("\t\t용인 수지구 포은대로 552\n");
				System.out.printf("영수증 미지참시 교환/환불 불가\n");
				System.out.printf("정상상품에 한함, 30일 이내(신선 7일)\n");
				System.out.printf("※일부 브랜드매장 제외(매장 고지물참조)\n");
				System.out.printf("교환/환불 구매점에서 가능(결제카드 지참)\n\n");
			}
			
			public static void kopo41_TimeStamp() { // 출력시간 인쇄
				SimpleDateFormat kopo41_sdt = new SimpleDateFormat("YYYY-MM-dd HH:mm"); //날짜와 시간 형식 지정하기
				System.out.printf("[구 매]%s\t     POS:0011-9861\n",kopo41_sdt.format(kopo41_calt1.getTime()));
			}
			
			public static void kopo41_headerPrint() { // 해더(상품명, 단가, 수량, 금액) 인쇄
				System.out.printf("-------------------------------------------\n");
				System.out.printf("   상 품 명\t\t단 가  수량    금 액\n");
				System.out.printf("-------------------------------------------\n");
			}
			
			public static void kopo41_itemPrint(int kopo41_i) { //물건 배열 인덱스 받아 상품 정보 출력하기
				if(kopo41_taxfree[kopo41_i]==true) { //면세가 아니면 빈칸 출력
					System.out.printf(" ");
				} else {
					System.out.printf("*"); //면세이면 별 출력
				}
				
				System.out.printf(" %-14.14s\t%6s\t%d   %6s\n",
				kopo41_itemname[kopo41_i],kopo41_df.format(kopo41_price[kopo41_i]),kopo41_num[kopo41_i],kopo41_df.format(kopo41_price[kopo41_i]*kopo41_num[kopo41_i]));
				if((kopo41_i+1)%5==0) { // 항목 갯수 5개 마다 줄 긋기
					System.out.printf("------------------------------------------\n");
				}
			}
			
			public static void kopo41_totalPrint() { //합계 세액 등을 인쇄
				SimpleDateFormat kopo41_sdt2 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); //날짜와 시간 형식 지정하기 (주차시간)
				System.out.printf("\n");
				System.out.printf("\t\t총 품목 수량 \t%10d\n",kopo41_itemname.length); //총 품목 수
				int kopo41_dutyfree = 0; //면세물품 총 가격 구하기
				int kopo41_duty = 0; //면세가 아닌 물품 총 가격 구하기
				for(int kopo41_i=0; kopo41_i<kopo41_itemname.length; kopo41_i++) {
					if(kopo41_taxfree[kopo41_i]== false) { //면세 총 가격
						kopo41_dutyfree+=kopo41_price[kopo41_i];
					} else {
						kopo41_duty+=kopo41_price[kopo41_i]; //비면세 총 가격
					}
				
				}
				int kopo41_netPrice = kopo41_netprice(kopo41_duty, 0.1); //세전가격
				int kopo41_totalsum = kopo41_dutyfree+kopo41_duty; //소비자가격 = 면세가격 + 비면세가격
				System.out.printf("\t     (*)면 세 물 품      \t%10s\n",kopo41_df.format(kopo41_dutyfree));
				System.out.printf("\t        과 세 물 품      \t%10s\n",kopo41_df.format(kopo41_netPrice));
				System.out.printf("\t        부  가  세      \t%10s\n",kopo41_df.format(kopo41_duty-kopo41_netPrice));
				System.out.printf("\t        합      계      \t%10s\n",kopo41_df.format(kopo41_totalsum));
				System.out.printf("    결 제 대 상 금 액\t\t%10s\n",kopo41_df.format(kopo41_totalsum));
				System.out.printf("------------------------------------------\n");
				System.out.printf("0012 KEB 하나 \t     541707**0484/35860658\n");
				System.out.printf("카드결제(IC)      \t\t%7s / %s\n","일시불",kopo41_df.format(kopo41_totalsum));
				System.out.printf("------------------------------------------\n");
				System.out.printf("\t      [신세계 포인트 적립]\n");
				System.out.printf("최*솔 고객님의 포인트 현황입니다.\n");
				int kopo41_point = kopo41_totalsum/1000;
				System.out.printf("금회발생포인트\t\t9350**9995    %d\n",kopo41_point);
				int kopo41_ponit2 = 5473;
				System.out.printf("누계(가용)포인트\t\t  %s(%9s)\n",kopo41_df.format(kopo41_ponit2+kopo41_point),kopo41_df.format(kopo41_ponit2));
				System.out.printf("*신세계포인트 유효기간은 2년입니다.\n");
				System.out.printf("------------------------------------------\n");
				System.out.printf("\t구매금액기준 무료주차시간 자동부여\n");
				System.out.printf("차량번호 :\t\t\t\t  34저****\n");
				System.out.printf("입차시간 :\t\t       %s\n",kopo41_sdt2.format(kopo41_calt1.getTime()));
				System.out.printf("------------------------------------------\n");
				System.out.printf("캐셔:084599 양OO\t\t\t      1150\n");
			}

	}


