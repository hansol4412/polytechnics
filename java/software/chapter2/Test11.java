package chapter2;

public class Test11 {
	// float형 double형 변환
	public static void main(String[] args) {
		float kopo41_f = 9.1234567f;  //float형은 7자리만 유효하고 나머지 소숫점이 있을 때 올바른 값이 안나옴
		double kopo41_d = 9.1234567; //double형을 썼을 때 더 정확한 실수를 표현할 수 있다/
		double kopo41_d2 = (double)kopo41_f; 
		//float값을 double형으로 변환했지만 본래 float에 저장이 이상해서 정상적인 값이 나오지 않는다.
		
		System.out.printf("f =%20.18f\n",kopo41_f);
		System.out.printf("d =%20.18f\n",kopo41_d);
		System.out.printf("d2 =%20.18f\n",kopo41_d2);
		
	}

}
