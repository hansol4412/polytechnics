package chapter7;

import java.text.DecimalFormat;

public class Test2 {
	// 고정 길이에서 필드 추출 처리 (최한솔)
	public static void main(String[] args) {
		DecimalFormat kopo41_df = new DecimalFormat("00"); // 물건 품목 번호 수
		DecimalFormat kopo41_df2 = new DecimalFormat("###,###,###,###,###"); // 가격 콤마찍기 형식
		String[] kopo41_oneRec = {
				" 해피홈 핸드크림  	 7,500   2   15,000",
				" 원형 유리화병   	 6,900   1    6,900",
				" 상투과자E     	 5,980   1    5,980",
				" 더블링 나일론 깡 	 3,300   1    3,300",
				" 해피홈 핸드워시  	 5,500   2   11,000",
				" 농심 신라면    	 3,380   1    3,380",
				"*국내산삽겹살찌개  	 6,610   1    6,610",
				" 오뚜기 진비빔면 1	 2,750   1    2,750",
				"*GAP 죽장사과 6	10,800   1   19,800",
				"*순 유기농 바나나 	 4,980   1    4,980",
				" 피코크 들깨미역국 	 3,980   1    3,980",
				"*남양 맛있는 우유G	 4,480   1    4,480",
				" 녹차원흑당시럽10입	 4,980   1    4,980",
				" 진라면 소컵(매)6	 3,210   1    3,210",
				" 케라시스 앱플 트리	 6,950   1    8,950",
				" 푸르밀 미숫가루우유	 2,980   2    5,960",
				" 자일로스갈색설탕50	 1,990   1    1,990",
				" CJ 비비고칩   	 1,980   1    1,980",
				" 피코크 들깨고기국5	 3,980   1    3,980",
				" 흑원당 말차 밀크티	 4,480   1    4,480",
				" 1+ 등급란 10개	 3,480   2    6,960",
				" 동원양반볶음    	 7,980   1    7,980",
				" 목캔디 허브민트  	 1,000   1    1,000",
				" 원링노트 3매유선 	 1,000   3    3,000",
				" 광동)감귤500ML	 1,600   1    1,600",
				" 허쉬초코바     	 4,000   2    9,000",
				"*애호박       	 1,360   1    1,360",
				"*논산양상추     	 1,180   1    1,180",
				" 마리오케이퍼    	 3,180   1    3,180",
				" 농심닭다리너겟   	 1,980   1    2,980"
		};
		
		//상품명
		String[] kopo41_name = new String[kopo41_oneRec.length]; // 상품명 배열로 지정
		for(int kopo41_i=0; kopo41_i<kopo41_name.length; kopo41_i++) {
			kopo41_name[kopo41_i] = kopo41_oneRec[kopo41_i].substring(1, 11);
			// 원 배열에서 1번재 인덱스부터 11번째 인덱스 전까지 문자 추출해서 kopo41_name 배열에 넣는다.
		}
		
		// 원래 물건 가격
		String[] kopo41_originalPrice = new String[kopo41_oneRec.length];  // 상품 가격 배열로 지정 (스트링)
		int[] kopo41_originalPriceInt = new int[kopo41_oneRec.length]; // 상품 가격 배열로 지정 (정수형)
		for(int kopo41_i=0; kopo41_i<kopo41_originalPrice.length; kopo41_i++) {
			kopo41_originalPrice[kopo41_i] = kopo41_oneRec[kopo41_i].substring(12, 18);
			// 원 배열에서 12번재 인덱스부터 18번째 인덱스 전까지 문자 추출해서 kopo41_originalPrice 배열에 넣는다.
			kopo41_originalPrice[kopo41_i] = kopo41_originalPrice[kopo41_i].replaceAll(",", "");
			// kopo41_originalPrice 가격에 콤마가 있으면 replaceAll 메소드를 이용해서 콤마를 없앤다
			kopo41_originalPrice[kopo41_i] = kopo41_originalPrice[kopo41_i].replaceAll(" ", "");
			// kopo41_originalPrice 가격에 빈칸이 있으면 replaceAll 메소드를 이용해서 빈칸을 없앤다
			kopo41_originalPriceInt[kopo41_i] = Integer.parseInt(kopo41_originalPrice[kopo41_i]);
			// 빈칸과 콤마를 없앤 문자열을 정수형으로 바꿔서 kopo41_originalPriceInt배열에 넣는다.
		}
		
		// 물건 품목 당 쇼핑한 갯수
		String[] kopo41_originalCnt = new String[kopo41_oneRec.length]; //상품 구매 갯수 배열로 지정 (스트링)
		int[] kopo41_originalCntInt = new int[kopo41_oneRec.length]; //상품 구매 갯수 배열로 지정 (정수형)
		
		for(int kopo41_i=0; kopo41_i<kopo41_originalCnt.length; kopo41_i++) {
			kopo41_originalCnt[kopo41_i] = kopo41_oneRec[kopo41_i].substring(21,22);
			// 원 배열에서 21번재 인덱스부터 22번째 인덱스 전까지 문자 추출해서 kopo41_originalCnt 배열에 넣는다.
			kopo41_originalCntInt[kopo41_i] = Integer.parseInt(kopo41_originalCnt[kopo41_i]);
			//  문자열을 정수형으로 바꿔서 kopo41_originalCntInt배열에 넣는다.
		}

		// 물건 품목 당 계산한 가격
		String[] kopo41_CalPrice = new String[kopo41_oneRec.length]; //상품 계산 가격 배열로 지정 (스트링)
		int[] kopo41_CallPriceInt = new int[kopo41_oneRec.length]; //상품 계산 가격 배열로 지정 (정수형)
		for(int kopo41_i=0; kopo41_i<kopo41_CalPrice.length; kopo41_i++) {
			kopo41_CalPrice[kopo41_i] = kopo41_oneRec[kopo41_i].substring(25);
			// 원 배열에서 25번재 인덱스부터 끝까지 문자 추출해서 kopo41_originalPrice 배열에 넣는다.
			kopo41_CalPrice[kopo41_i] = kopo41_CalPrice[kopo41_i].replaceAll(",", "");
			// kopo41_CalPrice 가격에 콤마가 있으면 replaceAll 메소드를 이용해서 콤마를 없앤다
			kopo41_CalPrice[kopo41_i] = kopo41_CalPrice[kopo41_i].replaceAll(" ", "");
			// kopo41_CalPrice 가격에 빈칸이 있으면 replaceAll 메소드를 이용해서 빈칸을 없앤다
			kopo41_CallPriceInt[kopo41_i] = Integer.parseInt(kopo41_CalPrice[kopo41_i]);
			// 빈칸과 콤마를 없앤 문자열을 정수형으로 바꿔서 kopo41_CallPriceInt배열에 넣는다.
		}
		for(int kopo41_i=0; kopo41_i<kopo41_oneRec.length; kopo41_i++) {
			if(kopo41_originalPriceInt[kopo41_i]*kopo41_originalCntInt[kopo41_i] != kopo41_CallPriceInt[kopo41_i]) {
				// 상품 가격과 상품 구매한 갯수를 곱한 것과 상품 계산이 다르다면 오류를 고친다.
				System.out.printf("★★★★★★★★★★★★★★★★★★★\n");
				System.out.printf("오류[%s  %s %6s                   %2d        %6s]\n", //오류 출력
						kopo41_df.format(kopo41_i),kopo41_hanBlankBackword(kopo41_name[kopo41_i], 30),kopo41_df2.format(kopo41_originalPriceInt[kopo41_i]),
						kopo41_originalCntInt[kopo41_i], kopo41_df2.format(kopo41_CallPriceInt[kopo41_i]));
				System.out.printf("수정[%s  %s %6s                   %2d        %6s]\n", //수정 출력
						kopo41_df.format(kopo41_i),kopo41_hanBlankBackword(kopo41_name[kopo41_i], 30),kopo41_df2.format(kopo41_originalPriceInt[kopo41_i]),
						kopo41_originalCntInt[kopo41_i], kopo41_df2.format(kopo41_originalPriceInt[kopo41_i]*kopo41_originalCntInt[kopo41_i]));
				System.out.printf("★★★★★★★★★★★★★★★★★★★\n");
			}
		}
	}
	
	//상품명 출력에서 칸을 맞추기 위한 함수
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
