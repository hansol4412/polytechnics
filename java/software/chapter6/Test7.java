package chapter6;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test7 {
	// 성적집계표 (최한솔)
	public static void main(String[] args) {
		int kopo41_iPerson = 30; //저장소의 크기
		Calendar kopo41_calt1 = Calendar.getInstance();
		SimpleDateFormat kopo41_sdt = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss"); //날짜와 시간 형식 지정하기
		DecimalFormat kopo41_df = new DecimalFormat("000"); // 가격 콤마찍기 형식
		Kopo41_InputData kopo41_inData = new Kopo41_InputData(kopo41_iPerson);
		System.out.printf("\t\t  성적 집계표\n");
		System.out.printf("\t\t\t  출력 일자 : %s\n",kopo41_sdt.format(kopo41_calt1.getTime()));  //출력 일자 찍기
		System.out.printf("===============================================================\n");
		System.out.printf("번호\t이름\t국어\t영어\t수학\t총점\t평균\n");
		System.out.printf("===============================================================\n");
		for(int kopo41_i=0; kopo41_i<kopo41_iPerson; kopo41_i++) {
			String kopo41_name = String.format("홍길%02d", kopo41_i+1); //이름만들기
			int kopo41_kor = (int)(Math.random()*100); //국어점수 만들기
			int kopo41_eng = (int)(Math.random()*100); //영어점수 만들기
			int kopo41_mat = (int)(Math.random()*100); //수학점수 만들기
			kopo41_inData.kopo41_SetData(kopo41_i, kopo41_name, kopo41_kor, kopo41_eng, kopo41_mat);
			//클래스 내 값 입력
		}
		
		//저장소 내용 출력
		for(int kopo41_i=0; kopo41_i<kopo41_iPerson; kopo41_i++) {
			System.out.printf("%3s\t%s \t%d \t%d \t%d \t%d \t%d\n",
					kopo41_df.format(kopo41_i+1),kopo41_inData.kopo41_name[kopo41_i],kopo41_inData.kopo41_kor[kopo41_i],
					kopo41_inData.kopo41_eng[kopo41_i], kopo41_inData.kopo41_mat[kopo41_i],
					kopo41_inData.kopo41_sum[kopo41_i], (int)kopo41_inData.kopo41_avg[kopo41_i]);
		}
		System.out.printf("===============================================================\n");
		//과목별 총합 출력
		System.out.printf("합계 :\t\t%d\t%d\t%d\t%d\t%d\n",kopo41_inData.kopo41_kor_sum,
				kopo41_inData.kopo41_eng_sum,kopo41_inData.kopo41_mat_sum,kopo41_inData.kopo41_sum_sum,(int)kopo41_inData.kopo41_avg_sum);
		
		//과목별 평균 출력
		System.out.printf("평균 :\t\t%d\t%d\t%d\t%d\t%d\n",
				(int)kopo41_inData.kopo41_kor_avg,(int)kopo41_inData.kopo41_eng_avg,(int)kopo41_inData.kopo41_mat_avg,
				(int)kopo41_inData.kopo41_sum_avg,(int)kopo41_inData.kopo41_avg_avg);

	}

}
