package chapter2;

public class Test7 {
	// 변수출력 실습2
	public static void main(String[] args) {
		String kopo41_url = "www.codechobo.com";
		float kopo41_f1 = .10f; //0.10
		float kopo41_f2 = 1e1f; //10.0 / 1의 소숫점 뒤로 하나 보내기
		float kopo41_f3 = 3.14e3f; //3140 / 3.14 소숫점 뒤로 3개 보내기
		double kopo41_d = 1.23456789; // float타입으로는 정확하게 표현 불가해서 double형 사용
		
		
		System.out.printf("f1 = %f, %e, %g\n",kopo41_f1, kopo41_f1, kopo41_f1 );
		// 부동 소수점, 지수형, 지수형의 간략한 형식
		System.out.printf("f2 = %f, %e, %g\n",kopo41_f2, kopo41_f2, kopo41_f2);
		// 부동 소수점, 지수형, 지수형의 간략한 형식
		System.out.printf("f3 = %f, %e, %g\n",kopo41_f3, kopo41_f3, kopo41_f3);
		// 부동 소수점, 지수형, 지수형의 간략한 형식

		System.out.printf("d=%f\n", kopo41_d); // kopo41_d출력
		System.out.printf("d=%14.10f\n", kopo41_d); //14개의 칸 설정, 10개의 숫자만 출력, 오른쪽 정렬
		
		System.out.printf("[13245678901234567890]\n"); // 믄자열 지정해 출력
		System.out.printf("[%s]\n",kopo41_url); // url 출력
		System.out.printf("[%20s]\n", kopo41_url); //20칸 잡아 url 출력, 오른쪽 정렬
		System.out.printf("[%-20s]\n", kopo41_url); //20칸 잡아 url 출력, 왼쪽 정렬
		System.out.printf("[%.8s]\n", kopo41_url); // 0칸 잡아 url 출력, 넘는 글자는 출력하지 않는다.

	}

}
