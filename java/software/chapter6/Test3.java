package chapter6;

public class Test3 {
	// 메소드 오버로딩 (성적표) (최한솔)
	public static void main(String[] args) {
		Kopo41_Overriding kopo41_overriding = new Kopo41_Overriding(); 
		//Kopo41_Overriding 클래스로 kopo41_overriding 객체 생성
		int kopo41_kor = 100; //국어점수
		int kopo41_eng = 90; //영어점수
		int kopo41_math = 80; //수학점수
		int kopo41_sci = 70; //과학점수
		int kopo41_sco = 60; //사회점수
		
		System.out.printf("3월 성적표\n");
		System.out.printf("==================================================\n");
		System.out.printf("이름\t국어\t영어\t수학\t총점\t평균\n");
		System.out.printf("==================================================\n");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%f\n","kopo41",kopo41_kor,kopo41_eng,kopo41_math, // 국어, 영어, 수학 점수
				kopo41_overriding.kopo41_sum(kopo41_kor, kopo41_eng, kopo41_math), //매개변수가 3개인 총합 함수 호출
				kopo41_overriding.kopo41_avg(kopo41_kor, kopo41_eng, kopo41_math));  //매개변수가 3개인 평균 함수 호출
		System.out.printf("\n\n");
		
		System.out.printf("4월 성적표\n");
		System.out.printf("============================================================\n");
		System.out.printf("이름\t국어\t영어\t수학\t과학\t총점\t평균\n");
		System.out.printf("============================================================\n"); // 국어, 영어, 수학, 과학 점수
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%f\n","kopo41",kopo41_kor,kopo41_eng,kopo41_math,kopo41_sci,
				kopo41_overriding.kopo41_sum(kopo41_kor, kopo41_eng, kopo41_math,kopo41_sci),  //매개변수가 4개인 총합 함수 호출
				kopo41_overriding.kopo41_avg(kopo41_kor, kopo41_eng, kopo41_math,kopo41_sci)); //매개변수가 4개인 평균 함수 호출
		System.out.printf("\n\n");
		
		System.out.printf("5월 성적표\n");
		System.out.printf("=======================================================================\n");
		System.out.printf("이름\t국어\t영어\t수학\t과학\t사회\t총점\t평균\n");
		System.out.printf("========================================================================\n"); // 국어, 영어, 수학, 과학, 사회 점수
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%d\t%f\n","kopo41",kopo41_kor,kopo41_eng,kopo41_math,kopo41_sci,kopo41_sco,
				kopo41_overriding.kopo41_sum(kopo41_kor, kopo41_eng, kopo41_math,kopo41_sci,kopo41_sco),  //매개변수가 5개인 총합 함수 호출
				kopo41_overriding.kopo41_avg(kopo41_kor, kopo41_eng, kopo41_math,kopo41_sci,kopo41_sco)); //매개변수가 5개인 평균 함수 호출

	}

}
