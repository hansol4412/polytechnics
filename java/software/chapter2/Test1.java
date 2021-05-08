package chapter2;

public class Test1 {
	//숫자 변수 (최한솔)
	public static void main(String[] args) {
		int kopo41_year = 0; // kopo41_year 초기값 0지정
		int kopo41_age = 14; // kopo41_age 초기값 14지정
		
		System.out.println(kopo41_year); //kopo41_year 출력해서 값 확인
		System.out.println(kopo41_age); //kopo41_age 출력해서 값 확인
		
		kopo41_year = kopo41_age + 2000; //kopo41_year에 2000더하기
		kopo41_age = kopo41_age +1;	//kopo41_age에 1더하기
		
		System.out.println(kopo41_year);  //kopo41_year 출력해서 값 확인
		System.out.println(kopo41_age); //kopo41_age 출력해서 값 확인
	}

}
