package chapter8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test4 {
	//거리 계산 (최한솔)
	public static void main(String[] args)  throws IOException{
		File kopo41_f = new File("C:\\Users\\sol\\Desktop\\12_04_07_E_무료와이파이정보.txt"); 
		//경로에 있는 파일 가져오기
		BufferedReader kopo41_br = new BufferedReader(new FileReader(kopo41_f));
		//BufferedReader로 파일읽고, 생성자로 BufferedReader객체를 넣는다.	
		String kopo41_readtxt; // 파일을 읽기 위한 변수 선언
		if((kopo41_readtxt = kopo41_br.readLine())== null) {
			//빈 파일 일 경우
			System.out.printf("빈 파일 입니다.\n");
			return;
		}
		String[] kopo41_fieldName = kopo41_readtxt.split("\t");
		//파일을 한 줄씩 읽고 탭으로 구분해서 배열에 집어 넣기 (필드명)	
		double kopo41_lat = 37.3860521; // 분당 폴리텍 위도
		double kopo41_lng = 127.1214038; // 분당 폴리텍 경도
		
		int kopo41_error=0;
		int kopo41_LineCnt = 0; // 데이터 갯수 알기 위한 변수 
		double kopo41_Maxdist = 0; // 최대 거리
		String kopo41_MaxArea=""; //최대거리 명칭
		String kopo41_MaxdistW = ""; // 최대 거리 위도
		String kopo41_MaxdistK = ""; // 최대 거리 경도
		double kopo41_Mindist = 1000000000; // 최소거리
		String kopo41_MinArea=""; //최소거리 명칭
		String kopo41_MindistW = ""; // 최소 거리 위도
		String kopo41_MindistK = ""; // 최소 거리 경도
		
		while((kopo41_readtxt = kopo41_br.readLine())!= null) { 
			try { //오류가 일어 날 가능 성이 잇는 코드를 적는 부분
				//kopo41_br.readLine()으로 파일을 한 줄씩 읽는다. 
				//더 이상 읽을 게 없으면 null을 리턴하여 반복문을 멈춘다
				String[] kopo41_field = kopo41_readtxt.split("\t");
				//파일을 한 줄씩 읽고 ","로 구분해서 배열에 집어 넣기 (내용)
				System.out.printf("**[%d번째 항목]*********************\n",kopo41_LineCnt );
				System.out.printf("%s : %s\n", kopo41_fieldName[9], kopo41_field[9]); // 주소
				System.out.printf("%s : %s\n", kopo41_fieldName[13], kopo41_field[13]); // 위도
				System.out.printf("%s : %s\n", kopo41_fieldName[14], kopo41_field[14]); // 경도

				double kopo41_dist= Math.sqrt(Math.pow(Double.parseDouble(kopo41_field[13])-kopo41_lat, 2)
						+Math.pow(Double.parseDouble(kopo41_field[14])-kopo41_lng, 2));
				if((kopo41_Maxdist<kopo41_dist) && !(kopo41_field[9].contains("서초구")) &&!(kopo41_field[9].contains("성동구"))
						&& !(kopo41_field[9].contains("용산구")) && !(kopo41_field[9].contains("금천구")) && !(kopo41_field[9].contains("허준로"))) {
					kopo41_Maxdist=kopo41_dist; // 최대거리
					kopo41_MaxArea = kopo41_field[9]; // 최대 거리 명칭
					kopo41_MaxdistW = kopo41_field[13]; //최대거리 위도
					kopo41_MaxdistK = kopo41_field[14]; //최대거리 경도
				}
				if(kopo41_Mindist>kopo41_dist) {
					kopo41_Mindist=kopo41_dist; // 최소거리
					kopo41_MinArea = kopo41_field[9]; //최대거리 명칭
					kopo41_MindistW = kopo41_field[13]; // 최소 거리 위도
					kopo41_MindistK = kopo41_field[14]; // 최소 거리 경도
				}	
				System.out.printf("현재 지점과의 거리 : %f\n", kopo41_dist); // 두 지점 사이의 거리
				System.out.printf("*************************************\n");
				kopo41_LineCnt++; // 데이터 갯수를 알기 위한 변수	
			}catch(Exception e) { //오류가 일어났을 때 반응하는 부분
				kopo41_error++;
				continue; // 오류 나면 그 부분 넘어가기
			}
		}
		System.out.println("총 "+(kopo41_LineCnt-1)+"개 데이터 처리");
		System.out.println("에러 갯수:"+kopo41_error);
		System.out.printf("현재 지점과의 최대거리 무료 와이파이 지역 => %s : %f  (위도 %s, 경도 %s)\n", 
				kopo41_MaxArea, kopo41_Maxdist,kopo41_MaxdistW,kopo41_MaxdistK); 
		System.out.printf("현재 지점과의 최소거리 무료 와이파이 지역 => %s : %f  (위도 %s, 경도 %s)\n", 
				kopo41_MinArea, kopo41_Mindist,kopo41_MindistW,kopo41_MindistK ); 
		kopo41_br.close(); //파일 읽기 종료
	}
}
