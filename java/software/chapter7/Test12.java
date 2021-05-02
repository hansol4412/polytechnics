package chapter7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test12 {
         //클래스의 ArrayList 정렬 (최한솔)
		static ArrayList<Kopo41_OneRec1> kopo41_ArrayOneRec = new ArrayList<Kopo41_OneRec1>(); //arrayList 생성
		static int kopo41_sumKor=0; // 국어 접수 총합
		static int kopo41_sumEng=0; // 영어 접수 총합
		static int kopo41_sumMat=0; // 수학 점수 총합
		static int kopo41_sumsum=0; // 총합 점수 총합
		static double kopo41_sumAvg=0; // 평균 점수 총합
		static final int kopo41_iPerson = 20; // 총 학생의 수
		
		public static void main(String[] args) {
			kopo41_dataSet(); //데이터 세팅
			kopo41_dataSort(); // 합계를 기준으로 내림 차순
			kopo41_HeaderPrint(); // 헤더 인쇄
			for(int kopo41_i=0; kopo41_i<kopo41_ArrayOneRec.size(); kopo41_i++) {
				kopo41_ItemPrint(kopo41_i); // 내용 인쇄
			}
			kopo41_TailPrint();  //꼬리 인쇄
		}
		
		// 데이터 만들기
		public static void kopo41_dataSet() {
			for(int kopo41_i=0; kopo41_i<kopo41_iPerson; kopo41_i++) {
				String kopo41_name = String.format("홍길%02d", kopo41_i+1); //이름만들기
				int kopo41_kor = (int)(Math.random()*101); //국어점수 만들기
				int kopo41_eng = (int)(Math.random()*101); //영어점수 만들기
				int kopo41_mat = (int)(Math.random()*101); //수학점수 만들기
				kopo41_ArrayOneRec.add(new Kopo41_OneRec1(kopo41_i,kopo41_name,kopo41_kor,kopo41_eng,kopo41_mat));
				// 객체를 생성해서 어레이리스트에 추가 하기
			}
		}
		
		// 데이터 정렬 
		public static void kopo41_dataSort() { 
			//데이터 정렬기준 설정
			Comparator<Kopo41_OneRec1> kopo41_sort = new Comparator<Kopo41_OneRec1>() {
				public int compare(Kopo41_OneRec1 kopo41_a1, Kopo41_OneRec1 kopo41_a2) {
					//합계를 기준으로 정렬
					return (kopo41_a2.kopo41_sum() - kopo41_a1.kopo41_sum());
					// 양수 값일 때 뒷 레코드의 합계 값이 큰 경우 선택
					
					//문자열을 기준으로 정렬
				   //return (String.valueOf(kopo41_a1.kopo41_kor()).compareTo(String.valueOf(kopo41_a2.kopo41_kor());
				}
			};
			Collections.sort(kopo41_ArrayOneRec,kopo41_sort );// 리스트 정렬기준을 적용해서 정렬
		}
		
		//해더 인쇄
		public static void kopo41_HeaderPrint() { //해더 출력
			System.out.printf("★★★★★★★★★★★★★★★★★★★★★★★★★\n");
			System.out.printf("%2s  %4s  %2s  %2s  %2s  %2s  %2s \n","번호","이름","국어","영어","수학","합계","평균");
			System.out.printf("★★★★★★★★★★★★★★★★★★★★★★★★★\n");
		}
		
		public static void kopo41_ItemPrint(int kopo41_i) { //내용 출력
			Kopo41_OneRec1 kopo41_rec; //객체 선언
			kopo41_rec = kopo41_ArrayOneRec.get(kopo41_i);
			// 함수를 호출하여 private된 변수를 출력한다.
			
			System.out.printf("%4d  %4s  %3d   %3d   %3d   %3d  %6.2f \n",
					kopo41_rec.kopo41_student_id(),kopo41_rec.kopo41_name(),kopo41_rec.kopo41_kor(),
					kopo41_rec.kopo41_eng(),kopo41_rec.kopo41_mat(),kopo41_rec.kopo41_sum(),kopo41_rec.kopo41_avg());
			kopo41_sumKor+=kopo41_rec.kopo41_kor(); //국어 합계에 함수로 출력된 국어 점수를 누적으로 더한다.
			kopo41_sumEng+=kopo41_rec.kopo41_eng(); //영어 합계에 함수로 출력된 영어 점수를 누적으로 더한다.
			kopo41_sumMat+=kopo41_rec.kopo41_mat(); //수학 합계에 함수로 출력된 수학 점수를 누적으로 더한다.
			kopo41_sumsum+=kopo41_rec.kopo41_sum(); //총합 합계에 함수로 출력된 총합 점수를 누적으로 더한다.
			kopo41_sumAvg+=kopo41_rec.kopo41_avg(); //평균 합계에 함수로 출력된 평균 점수를 누적으로 더한다.
		}
		
		public static void kopo41_TailPrint() { //총합 평균 출력
			System.out.printf("★★★★★★★★★★★★★★★★★★★★★★★★★\n");
			System.out.printf("국어합계 %d    국어평균: %6.2f\n",kopo41_sumKor,kopo41_sumKor/(double)kopo41_ArrayOneRec.size());
			System.out.printf("영어합계 %d    영어평균: %6.2f\n",kopo41_sumEng,kopo41_sumEng/(double)kopo41_ArrayOneRec.size());
			System.out.printf("수학합계 %d    수학평균: %6.2f\n",kopo41_sumMat,kopo41_sumMat/(double)kopo41_ArrayOneRec.size());
			System.out.printf("★★★★★★★★★★★★★★★★★★★★★★★★★\n");
			System.out.printf("반평균합계 %f    반평균: %6.2f\n",kopo41_sumAvg,kopo41_sumAvg/(double)kopo41_ArrayOneRec.size());
		}
		
		

	}

