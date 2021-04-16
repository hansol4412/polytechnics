package chapter4;

public class Test10 {
	//숫자 읽기 고급 (최한솔)
		public static void main(String[] args) {
			int kopo41_iNumVal=1001034567; //일십억일백삼만사천오백육십칠
			String kopo41_sNumVal=String.valueOf(kopo41_iNumVal); //kopo41_iNumVal숫자를 문자열로 변환
			String kopo41_sNumVoice=""; // 빈 문자열을 가지는 변수 선언
			System.out.printf("==> %s [%d자리]\n", kopo41_sNumVal , kopo41_sNumVal.length()); 
			// 문자열로 바꾼 숫자의 총 자리의 길이를 구하기 위해 문자열의 길이를 구한다.
			int kopo41_i, kopo41_j;
			String[] kopo41_units = {"영","일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
			// 자릿수를 나타내기 위한 배열
			String[] kopo41_unitX = {"","십","백","천","만","십","백","천","억","십"};
			// 수의 자리 단위를 나타내기 위한 배열 (1의 자리는 단위를 나타내지 않는다 => 빈칸)
			kopo41_i=0;
			kopo41_j = kopo41_sNumVal.length()-1; //배열은 0부터 시작하기 때문에 길이가 10이라면 0~9까지 인덱스가 존재
			while (true) {
				if (kopo41_i >= kopo41_sNumVal.length()) break; //숫자를 모두 한글로 번역하면 반복문 빠져나오기
				 System.out.printf("%s[%s]", //하나의 수의 자리마다 "숫자[한글]" 형식으로 보여주기 위함
						 kopo41_sNumVal.substring(kopo41_i,kopo41_i+1), // 문자열로 변환한 숫자를 하나씩 나누기 위해 subString사용 
						 kopo41_units[Integer.parseInt(kopo41_sNumVal.substring(kopo41_i,kopo41_i+1))]); 
				 		 //하나씩 나눈 숫자를 배열의 인덱스로 적용해 한글로 나타내기
				 if(kopo41_sNumVal.substring(kopo41_i,kopo41_i+1).equals("0")) {
					 //해당 자릿수가 0일 때
					 if(kopo41_unitX[kopo41_j].equals("만") || kopo41_unitX[kopo41_j].equals("억")) {
						 //억, 만 자리마다 단위를 또 붙여줘야 한다 ex) 오천이백사십이억 일천오백칠십삼만
						 	kopo41_sNumVoice=kopo41_sNumVoice +"" + kopo41_unitX[kopo41_j];
						 	// 억, 만을 한글 변환에 추가하기
					 }
				 } else{ 
					 kopo41_sNumVoice=kopo41_sNumVoice 
							 + kopo41_units[Integer.parseInt(kopo41_sNumVal.substring(kopo41_i,kopo41_i+1))] //자릿수 추가
							 + kopo41_unitX[kopo41_j]; // 자리 단위 추가
				 	}
				   kopo41_i++; // 숫자 올라가기
				   kopo41_j--; // 배열로 자리 단위 내려가기 
			}
				System.out.printf("\n %s[%s]\n", kopo41_sNumVal, kopo41_sNumVoice); // 숫자[한글]로 나타내기
		
		}

	}

