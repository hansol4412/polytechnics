package chapter6;

public class Kopo41_InputData {
	public int kopo41_inData; //저장소의 크기
	
	public String[] kopo41_name;
	public int[] kopo41_kor; //국어 점수 배열
	public int[] kopo41_eng; //영어 점수 배열
	public int[] kopo41_mat; //수학 점수 배열
	public int[] kopo41_sum; // 총점 배열
	public float[] kopo41_avg; //평균 배열
	
	public int kopo41_kor_sum=0; //누적 국어점수 총합
	public int kopo41_eng_sum=0; //누적 영어점수 총합
	public int kopo41_mat_sum=0; //누적 수학점수 총합
	public int kopo41_sum_sum=0; //누적 총점의 총합
	public float kopo41_avg_sum=0; //누적 평균점수의 총합
	
	public float kopo41_kor_avg=0; //누적 국어점수 평균
	public float kopo41_eng_avg=0; //누적 영어점수 평균
	public float kopo41_mat_avg=0; //누적 수학점수 평균
	public float kopo41_sum_avg=0; //누적 총점의 평균
	public float kopo41_avg_avg=0;  //누적 평균점수의 평균
	
	Kopo41_InputData(int kopo41_inData){ //저장소의 크기를 생성자로 지정
		this.kopo41_inData = kopo41_inData;
		this.kopo41_name = new String[kopo41_inData]; //이름 배열 크기지정
		this.kopo41_kor = new int[kopo41_inData]; //국어 점수 배열 크기지정
		this.kopo41_eng = new int[kopo41_inData]; //영어 점수 배열 크기지정
		this.kopo41_mat = new int[kopo41_inData]; //수학 점수 배열 크기지정
		this.kopo41_sum = new int[kopo41_inData]; // 총점 배열 크기지정
		this.kopo41_avg = new float[kopo41_inData]; //평균 배열 크기지정
	}
	
	//인덱스와 이름, 국어점수, 영어점수, 수학점수를 매개변수로 받아 저장소에 정보 저장
	public void kopo41_SetData(int kopo41_i, String kopo41_name, int kopo41_kor, int kopo41_eng, int kopo41_mat) {
		this.kopo41_name[kopo41_i] = kopo41_name; //이름 저장
		this.kopo41_kor[kopo41_i] = kopo41_kor; //국어점수 저장
		this.kopo41_eng[kopo41_i] = kopo41_eng; //영어점수 저장
		this.kopo41_mat[kopo41_i] = kopo41_mat; //수학점수 저장
		this.kopo41_sum[kopo41_i] = kopo41_kor + kopo41_eng + kopo41_mat; //총점 저장
		this.kopo41_avg[kopo41_i] = (kopo41_kor + kopo41_eng + kopo41_mat)/3; //평균 점수 저장
		
		kopo41_kor_sum+=this.kopo41_kor[kopo41_i]; //국어 점수 누적 총합
		kopo41_eng_sum+=this.kopo41_eng[kopo41_i]; //영어 점수 누적 총합
		kopo41_mat_sum+=this.kopo41_mat[kopo41_i]; //수학 점수 누적 총합
		kopo41_sum_sum+=this.kopo41_sum[kopo41_i]; //총 점수 누적 총합
		kopo41_avg_sum+=this.kopo41_avg[kopo41_i]; //평균 점수 누적 총합
		
		if(kopo41_i != 0) {
			kopo41_kor_avg=kopo41_kor_sum/(kopo41_i+1); //국어 점수 누적 평균
			kopo41_eng_avg=kopo41_eng_sum/(kopo41_i+1); //영어 점수 누적 평균
			kopo41_mat_avg=kopo41_mat_sum/(kopo41_i+1); //수학 점수 누적 평균
			kopo41_sum_avg=kopo41_sum_sum/(kopo41_i+1); //총 점수 누적 평균
			kopo41_avg_avg=kopo41_avg_sum/(kopo41_i+1); //평균 점수 누적 평균
		}
	}
	
	public int kopo41_kor_page_sum; //현재 페이지 국어점수 총합
	public int kopo41_eng_page_sum; //현재 페이지 영어점수 총합
	public int kopo41_mat_page_sum; //현재 페이지 수학점수 총합
	public int kopo41_sum_page_sum; //현재 페이지 총점의 총합
	public float kopo41_avg_page_sum; //현재 페이지 평균점수의 총합
	
	public float kopo41_kor_page_avg; //현재 페이지 국어점수 평균
	public float kopo41_eng_page_avg; //현재 페이지 영어점수 평균
	public float kopo41_mat_page_avg; //현재 페이지 수학점수 평균
	public float kopo41_sum_page_avg; //현재 페이지 총점의 평균
	public float kopo41_avg_page_avg;  //현재 페이지 평균점수의 평균
	
	public void kopo41_page_info(int kopo41_start, int kopo41_finish) { 
		// 각 페이지의 시작과 끝 번호를 받아 그 번호들만 따로 총합과 평균을 구하는 함수
		kopo41_kor_page_sum=0; //현재 페이지 국어점수 총합 초기화
		kopo41_eng_page_sum=0; //현재 페이지 영어점수 총합 초기화
		kopo41_mat_page_sum=0; //현재 페이지 수학점수 총합 초기화
		kopo41_sum_page_sum=0; //현재 페이지 총점의 총합 초기화
		kopo41_avg_page_sum=0; //현재 페이지 평균점수의 총합 초기화
		
		int kopo41_gap = kopo41_finish-kopo41_start; 
		// 끝번호에서 시작번호 빼서 총 몇개의 데이터가 있는지 확인 => 평균구하기 위함
		
		for(int kopo41_j=kopo41_start; kopo41_j<=kopo41_finish; kopo41_j++ ) {
			//페이지 시작번호에서 끝 번호까지 각 과목과 총합, 평균의 총합 구하기
			this.kopo41_kor_page_sum+=this.kopo41_kor[kopo41_j]; //현재 페이지 국어점수 총합
			this.kopo41_eng_page_sum+=this.kopo41_eng[kopo41_j]; //현재 페이지 영어점수 총합
			this.kopo41_mat_page_sum+=this.kopo41_mat[kopo41_j]; //현재 페이지 수학점수 총합 
			this.kopo41_sum_page_sum+=this.kopo41_sum[kopo41_j]; //현재 페이지 총점의 총합 
			this.kopo41_avg_page_sum+=this.kopo41_avg[kopo41_j]; //현재 페이지 평균점수의 총합
		}
		kopo41_kor_page_avg=kopo41_kor_page_sum/(kopo41_gap+1); //현재 페이지 국어점수 평균 
		kopo41_eng_page_avg=kopo41_eng_page_sum/(kopo41_gap+1); //현재 페이지 영어점수 평균 
		kopo41_mat_page_avg=kopo41_mat_page_sum/(kopo41_gap+1); //현재 페이지 수학점수 평균 
		kopo41_sum_page_avg=kopo41_sum_page_sum/(kopo41_gap+1); //현재 페이지 총점의 평균 
		kopo41_avg_page_avg=kopo41_avg_page_sum/(kopo41_gap+1);  //현재 페이지 평균점수의 평균 
		
	}
}


