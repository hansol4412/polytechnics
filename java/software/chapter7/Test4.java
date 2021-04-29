package chapter7;

public class Test4 {
	// 구분자 된 필드 추출 처리2 최한솔
	public static void main(String[] args) {
		String[] kopo41_oneRec = { //한국교통안전공단_서울특별시 최다 이용 정류장_20181231.csv 파일 내용 배열로 입력하기
				"순위,지역,정류장명,승차,하차,총 이용인원",
				"1,서울특별시,사당역(4103279),28524,3572,32096",
				"2,서울특별시,잠실광역환승센터(4117121),14439,13010,27449",
				"3,서울특별시,구로디지털단지역(0010718),6879,15161,22039",
				"4,서울특별시,미아사거리역(8000547),10861,10615,21476",
				"5,서울특별시,수유역.강북구청(0070707),9207,10831,20039",
				"6,서울특별시,사당역(4116659),1126,17015,18141",
				"7,서울특별시,강변역(B)(4113568),8799,8771,17570",
				"8,서울특별시,청량리역환승센타(8000781),6920,9927,16847",
				"9,서울특별시,지하철2호선강남역(8003138),10989,5667,16656",
				"10,서울특별시,고속터미널(8001908),7393,9135,16528"
		};
		
		String[] kopo41_field_name = kopo41_oneRec[0].split(","); 
		// 제일 위의 필드명을 콤마로 나눠서 필드명을 나눈다
		
		for(int kopo41_i=1; kopo41_i<kopo41_oneRec.length; kopo41_i++ ) { //필드명을 제외하고 필드 내용만 출력
			String[] kopo41_field = kopo41_oneRec[kopo41_i].split(","); // 필드 내용도 콤마로 구분지어 나눈다
			System.out.printf("********************************\n");
			for(int kopo41_j=0; kopo41_j<kopo41_field.length; kopo41_j++ ) {
				if(kopo41_j==3 || kopo41_j==4 || kopo41_j==5) {
					//나눈 필드명을 순서대로 출력한다.
					System.out.printf("%s : %s[%s]\n", kopo41_field_name[kopo41_j], kopo41_field[kopo41_j],kopo41_numToKor(kopo41_field[kopo41_j]));
					//(필드명 : 필드 내용)의 형식으로 출력한다.
				} else {
					//나눈 필드명을 순서대로 출력한다.
					System.out.printf("%s : %s\n", kopo41_field_name[kopo41_j], kopo41_field[kopo41_j]);
					//(필드명 : 필드 내용)의 형식으로 출력한다.
				}
			}
			System.out.printf("********************************\n");
		}
	}
	public static String kopo41_numToKor(String kopo41_num) {
		String kopo41_sNumVal=kopo41_num; //매개변수 kopo41_num을 변수 kopo41_sNumVal에 저장한다.
		String kopo41_sNumVoice=""; // 빈 문자열을 가지는 변수 선언
		int kopo41_i, kopo41_j;
		String[] kopo41_units = {"영","일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
		// 자릿수를 나타내기 위한 배열
		String[] kopo41_unitX = {"","십","백","천","만","십","백","천","억","십"};
		// 수의 자리 단위를 나타내기 위한 배열 (1의 자리는 단위를 나타내지 않는다 => 빈칸)
		kopo41_i=0;
		kopo41_j = kopo41_sNumVal.length()-1; //배열은 0부터 시작하기 때문에 길이가 10이라면 0~9까지 인덱스가 존재
		while (true) {
			if (kopo41_i >= kopo41_sNumVal.length()) break; //숫자를 모두 한글로 번역하면 반복문 빠져나오기
			 if(kopo41_sNumVal.substring(kopo41_i,kopo41_i+1).equals("0")) {
				 //해당 자릿수가 0일 때
				 if(kopo41_unitX[kopo41_j].equals("만") || kopo41_unitX[kopo41_j].equals("억")) {
					 //억, 만 자리마다 단위를 또 붙여줘야 한다 ex) 오천이백사십이억 일천오백칠십삼만
					 	kopo41_sNumVoice=kopo41_sNumVoice +"" + kopo41_unitX[kopo41_j];
					 	// 억, 만을 한글 변환에 추가하기
				 } else {
				 }
			 } else{ 
				 kopo41_sNumVoice=kopo41_sNumVoice 
						 + kopo41_units[Integer.parseInt(kopo41_sNumVal.substring(kopo41_i,kopo41_i+1))] //자릿수 추가
						 + kopo41_unitX[kopo41_j]; // 자리 단위 추가
			 	}
			   kopo41_i++; // 숫자 올라가기
			   kopo41_j--; // 배열로 자리 단위 내려가기 
		}
			
			return kopo41_sNumVoice;
	}

}
