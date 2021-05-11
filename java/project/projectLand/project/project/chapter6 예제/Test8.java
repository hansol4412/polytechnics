package chapter6;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test8 {
	// 성적 집계표 (다 페이지) 최한솔
	public static int kopo41_pageNum =1; //페이지 번호
	public static Kopo41_InputData kopo41_inData; // Kopo41_InputData클래스의 kopo41_inData객체 선언
	public static void main(String[] args) {
		int kopo41_iPerson_page = 30; //페이지당 저장소의 크기
		int kopo41_iPerson = 100; //전체 저장소의 크기
		
		DecimalFormat kopo41_df = new DecimalFormat("000"); // 가격 콤마찍기 형식
		
		kopo41_inData = new Kopo41_InputData(kopo41_iPerson); //Kopo41_InputData클래스의 kopo41_inData 객체 생성
		
		for(int kopo41_i=0; kopo41_i<kopo41_iPerson; kopo41_i++) {
			String kopo41_name = String.format("홍길%02d", kopo41_i+1); //이름만들기
			int kopo41_kor = (int)(Math.random()*100); //국어점수 만들기
			int kopo41_eng = (int)(Math.random()*100); //영어점수 만들기
			int kopo41_mat = (int)(Math.random()*100); //수학점수 만들기
			kopo41_inData.kopo41_SetData(kopo41_i, kopo41_name, kopo41_kor, kopo41_eng, kopo41_mat);
			//클래스 내 값 입력
			
			//출력
			if((kopo41_i)%kopo41_iPerson_page==0) { //30줄 마다
				kopo41_printHeader(); // 해더 출력
				kopo41_pageNum++; //페이지 번호 증가
			}
			
			// 점수 정보 출력
			System.out.printf("%3s\t%s \t%d \t%d \t%d \t%d \t%d\n",
					kopo41_df.format(kopo41_i+1),kopo41_inData.kopo41_name[kopo41_i],kopo41_inData.kopo41_kor[kopo41_i],
					kopo41_inData.kopo41_eng[kopo41_i], kopo41_inData.kopo41_mat[kopo41_i],
					kopo41_inData.kopo41_sum[kopo41_i], (int)kopo41_inData.kopo41_avg[kopo41_i]);
			
			
			if((kopo41_i)%kopo41_iPerson_page==(kopo41_iPerson_page-1)) { //30줄 마다 
				kopo41_inData.kopo41_page_info(kopo41_i-(kopo41_iPerson_page-1),kopo41_i);
				kopo41_printTail(); //총합, 평균 정보 출력
			}
		}
		if(kopo41_iPerson%kopo41_iPerson_page!=0) { 
			//만약 30배수 줄에서 총합, 평균 한번 출력했다면 또 다시 총합, 평균 정보를 나타내지 않아도 된다.
			kopo41_inData.kopo41_page_info((kopo41_iPerson_page*(kopo41_pageNum-2))-1,kopo41_iPerson-1);
			kopo41_printTail();	//총합, 평균 정보 출력
		}	
	}
	
	public static void kopo41_printHeader() { //헤더 정보
		Calendar kopo41_calt1 = Calendar.getInstance();
		SimpleDateFormat kopo41_sdt = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss"); //날짜와 시간 형식 지정하기
		System.out.printf("\n\t\t  성적 집계표\n");
		System.out.printf("PAGE: %d\t\t  출력 일자 : %s\n",kopo41_pageNum,kopo41_sdt.format(kopo41_calt1.getTime()));
		System.out.printf("===============================================================\n");
		System.out.printf("번호\t이름\t국어\t영어\t수학\t총점\t평균\n");
		System.out.printf("===============================================================\n");
	}
	
	public static void kopo41_printTail() { //누적, 현재 페이지의 총합과 평균을 구하는 메소드
		System.out.printf("===============================================================\n");
		System.out.printf("현재페이지\n"); //페이지 당 정보 출력
		System.out.printf("합계 :\t\t%d\t%d\t%d\t%d\t%d\n",kopo41_inData.kopo41_kor_page_sum,
				kopo41_inData.kopo41_eng_page_sum,kopo41_inData.kopo41_mat_page_sum,kopo41_inData.kopo41_sum_page_sum,(int)kopo41_inData.kopo41_avg_page_sum);
		// 페이지 마다 국어, 영어, 수학, 총합, 평균 점수의 총합 구하기
		System.out.printf("평균 :\t\t%d\t%d\t%d\t%d\t%d\n",
				(int)kopo41_inData.kopo41_kor_page_avg,(int)kopo41_inData.kopo41_eng_page_avg,(int)kopo41_inData.kopo41_mat_page_avg,
				(int)kopo41_inData.kopo41_sum_page_avg,(int)kopo41_inData.kopo41_avg_page_avg);
		// 페이지 마다 국어, 영어, 수학, 총합, 평균 점수의 평균 구하기
		
		System.out.printf("===============================================================\n");
		System.out.printf("누적페이지\n"); //누적 된 정보 출력
		System.out.printf("합계 :\t\t%d\t%d\t%d\t%d\t%d\n",kopo41_inData.kopo41_kor_sum,
				kopo41_inData.kopo41_eng_sum,kopo41_inData.kopo41_mat_sum,kopo41_inData.kopo41_sum_sum,(int)kopo41_inData.kopo41_avg_sum);
		// 페이지 마다 누적된 국어, 영어, 수학, 총합, 평균 점수의 총합 구하기
		System.out.printf("평균 :\t\t%d\t%d\t%d\t%d\t%d\n",
				(int)kopo41_inData.kopo41_kor_avg,(int)kopo41_inData.kopo41_eng_avg,(int)kopo41_inData.kopo41_mat_avg,
				(int)kopo41_inData.kopo41_sum_avg,(int)kopo41_inData.kopo41_avg_avg);
		// 페이지 마다 누적된 국어, 영어, 수학, 총합, 평균 점수의 평균 구하기
	}
}

