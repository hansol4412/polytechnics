package chapter6;

public class Kopo41_Overriding {
	public int kopo41_sum (int kopo41_kor, int kopo41_eng, int kopo41_math) {
		//매개변수 3개 총합 함수
		return kopo41_kor + kopo41_eng + kopo41_math;
	}
	
	public double kopo41_avg (int kopo41_kor, int kopo41_eng, int kopo41_math) {
		//매개변수 3개 평균 함수
		return (double)(kopo41_kor + kopo41_eng + kopo41_math)/3;
	}
	
	public int kopo41_sum (int kopo41_kor, int kopo41_eng, int kopo41_math, int kopo41_sci) {
		//매개변수 4개 총합 함수
		return kopo41_kor + kopo41_eng + kopo41_math+kopo41_sci;
	}
	
	public double kopo41_avg (int kopo41_kor, int kopo41_eng, int kopo41_math, int kopo41_sci) {
		//매개변수 4개 평균 함수
		return (double)(kopo41_kor + kopo41_eng + kopo41_math+kopo41_sci)/4;
	}
	
	public int kopo41_sum (int kopo41_kor, int kopo41_eng, int kopo41_math, int kopo41_sci, int kopo41_soc) {
		//매개변수 5개 총합 함수
		return kopo41_kor + kopo41_eng + kopo41_math+kopo41_sci+kopo41_soc;
	}
	
	public double kopo41_avg (int kopo41_kor, int kopo41_eng, int kopo41_math, int kopo41_sci, int kopo41_soc) {
		//매개변수 5개 평균 함수
		return (double)(kopo41_kor + kopo41_eng + kopo41_math+kopo41_sci+kopo41_soc)/5;
	}

	

}
