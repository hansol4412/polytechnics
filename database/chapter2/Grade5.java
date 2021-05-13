package database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;


public class Grade5 {
		static final int kopo41_iPerson = 1000; // 총 학생의 수
		static final int kopo41_iPerson_page = 30; //페이지당 저장소의 크기
		public static int kopo41_pageNum =1; //페이지 번호
		
		public static void main(String[] args) {
			
			for(int kopo41_i=0; kopo41_i<kopo41_iPerson; kopo41_i++) {
				//출력
				if((kopo41_i)%kopo41_iPerson_page==0) { //30줄 마다
					kopo41_HeaderPrint(); // 해더 출력
					kopo41_pageNum++; //페이지 번호 증가
				}
				kopo41_ItemPrint(kopo41_i); // 내용 인쇄
				if((kopo41_i)%kopo41_iPerson_page==(kopo41_iPerson_page-1)) { //30줄 마다 
					kopo41_page_info(kopo41_i-(kopo41_iPerson_page-1),kopo41_i); // 각 페이지당 총합, 평균
					kopo41_TailPrint();  //꼬리 인쇄
				}
			}
			if(kopo41_iPerson%kopo41_iPerson_page!=0) { 
				//만약 30배수 줄에서 총합, 평균 한번 출력했다면 또 다시 총합, 평균 정보를 나타내지 않아도 된다.
				kopo41_page_info((kopo41_iPerson_page*(kopo41_pageNum-2)),kopo41_iPerson-1); // 각 페이지당 총합, 평균
				kopo41_TailPrint();	//총합, 평균 정보 출력
			}
		}

		//해더 인쇄
		public static void kopo41_HeaderPrint() { //해더 출력
			Calendar kopo41_calt1 = Calendar.getInstance();
			SimpleDateFormat kopo41_sdt = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss"); //날짜와 시간 형식 지정하기
			System.out.printf("\n\t\t  성적 집계표\n\n");
			System.out.printf("PAGE: %d\t\t 출력 일자 : %s\n",kopo41_pageNum,kopo41_sdt.format(kopo41_calt1.getTime()));
			System.out.printf("=======================================================\n");
			System.out.printf("  %2s\t%4s\t%2s\t%2s\t%2s\t%2s\t%2s \n","번호","이름","국어","영어","수학","합계","평균");
			System.out.printf("=======================================================\n");
		}
		
		public static void kopo41_ItemPrint(int kopo41_i) { //내용 출력
			Kopo41_OneRec1 kopo41_rec; //객체 선언
			kopo41_rec = kopo41_ArrayOneRec.get(kopo41_i);
			// 객체에 어레이리스트에서 받을 값을 저장한다.
			System.out.printf("%d\t%s\t%3d\t%3d\t%3d\t%3d\t%3d \n",
					kopo41_rec.kopo41_student_id(),kopo41_rec.kopo41_name(),kopo41_rec.kopo41_kor(),
					kopo41_rec.kopo41_eng(),kopo41_rec.kopo41_mat(),kopo41_rec.kopo41_sum(),(int)kopo41_rec.kopo41_avg());
			kopo41_sumKor+=kopo41_rec.kopo41_kor(); //국어 합계에 함수로 출력된 국어 점수를 누적으로 더한다.
			kopo41_sumEng+=kopo41_rec.kopo41_eng(); //영어 합계에 함수로 출력된 영어 점수를 누적으로 더한다.
			kopo41_sumMat+=kopo41_rec.kopo41_mat(); //수학 합계에 함수로 출력된 수학 점수를 누적으로 더한다.
			kopo41_sumsum+=kopo41_rec.kopo41_sum(); //총합 합계에 함수로 출력된 총합 점수를 누적으로 더한다.
			kopo41_sumAvg+=kopo41_rec.kopo41_avg(); //평균 합계에 함수로 출력된 평균 점수를 누적으로 더한다.
			if(kopo41_i != 0) { //0으로 나누면 안된다.
				kopo41_avgkor=kopo41_sumKor/(kopo41_i+1); //국어 점수 누적 평균
				kopo41_avgeng=kopo41_sumEng/(kopo41_i+1); //영어 점수 누적 평균
				kopo41_avgmat=kopo41_sumMat/(kopo41_i+1); //수학 점수 누적 평균
				kopo41_avgsum=kopo41_sumsum/(kopo41_i+1); //총 점수 누적 평균
				kopo41_avgavg=kopo41_sumAvg/(kopo41_i+1); //평균 점수 누적 평균
			}
		}
		public static void kopo41_TailPrint() { //총합 평균 출력
			
			System.out.printf("=======================================================\n");
			System.out.printf("현재페이지\n"); //페이지 당 정보 출력
			System.out.printf("합계 :\t\t%d\t%d\t%d\t%d\t%d\n",kopo41_sumKor_page,
					kopo41_sumEng_page,kopo41_sumMat_page,kopo41_sumSum_page,(int)kopo41_sumAvg_page);
			// 페이지 마다 국어, 영어, 수학, 총합, 평균 점수의 총합 구하기
			System.out.printf("평균 :\t\t%d\t%d\t%d\t%d\t%d\n",
					(int)kopo41_avgkor_page,(int)kopo41_avgeng_page,(int)kopo41_avgmat_page,
					(int)kopo41_avgsum_page,(int)kopo41_avgavg_page);
			// 페이지 마다 국어, 영어, 수학, 총합, 평균 점수의 평균 구하기
			System.out.printf("=======================================================\n");
			System.out.printf("누적페이지\n"); //누적 된 정보 출력
			System.out.printf("합계 :\t\t%d\t%d\t%d\t%d\t%d\n",kopo41_sumKor,
					kopo41_sumEng,kopo41_sumMat,kopo41_sumsum,(int)kopo41_sumAvg);
			// 페이지 마다 누적된 국어, 영어, 수학, 총합, 평균 점수의 총합 구하기
			System.out.printf("평균 :\t\t%d\t%d\t%d\t%d\t%d\n",
					(int)kopo41_avgkor,(int)kopo41_avgeng,(int)kopo41_avgmat,
					(int)kopo41_avgsum,(int)kopo41_avgavg);
			// 페이지 마다 누적된 국어, 영어, 수학, 총합, 평균 점수의 평균 구하기
			System.out.printf("=======================================================\n\n");
		}
		
		public static void kopo41_page_info(int kopo41_start, int kopo41_finish) { 
			// 각 페이지의 시작과 끝 번호를 받아 그 번호들만 따로 총합과 평균을 구하는 함수
			kopo41_sumKor_page=0; //현재 페이지 국어점수 총합 초기화
			kopo41_sumEng_page=0; //현재 페이지 영어점수 총합 초기화
			kopo41_sumMat_page=0; //현재 페이지 수학점수 총합 초기화
			kopo41_sumSum_page=0; //현재 페이지 총점의 총합 초기화
			kopo41_sumAvg_page=0; //현재 페이지 평균점수의 총합 초기화
			
			int kopo41_gap = kopo41_finish-kopo41_start; 
			// 끝번호에서 시작번호 빼서 총 몇개의 데이터가 있는지 확인 => 평균구하기 위함
			
			for(int kopo41_j=kopo41_start; kopo41_j<=kopo41_finish; kopo41_j++ ) {
				Kopo41_OneRec1 kopo41_rec1 = kopo41_ArrayOneRec.get(kopo41_j);
				// 객체에 어레이리스트에서 받을 값을 저장한다.

				//페이지 시작번호에서 끝 번호까지 각 과목과 총합, 평균의 총합 구하기
				kopo41_sumKor_page+=kopo41_rec1.kopo41_kor(); //현재 페이지 국어점수 총합
				kopo41_sumEng_page+=kopo41_rec1.kopo41_eng(); //현재 페이지 영어점수 총합
				kopo41_sumMat_page+=kopo41_rec1.kopo41_mat(); //현재 페이지 수학점수 총합 
				kopo41_sumSum_page+=kopo41_rec1.kopo41_sum(); //현재 페이지 총점의 총합 
				kopo41_sumAvg_page+=(int)kopo41_rec1.kopo41_avg(); //현재 페이지 평균점수의 총합
			}
			kopo41_avgkor_page=kopo41_sumKor_page/(kopo41_gap+1); //현재 페이지 국어점수 평균 
			kopo41_avgeng_page=kopo41_sumEng_page/(kopo41_gap+1); //현재 페이지 영어점수 평균 
			kopo41_avgmat_page=kopo41_sumMat_page/(kopo41_gap+1); //현재 페이지 수학점수 평균 
			kopo41_avgsum_page=kopo41_sumSum_page/(kopo41_gap+1); //현재 페이지 총점의 평균 
			kopo41_avgavg_page=kopo41_sumAvg_page/(kopo41_gap+1);  //현재 페이지 평균점수의 평균 
			
		}

	}