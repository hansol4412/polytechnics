package chapter2;

public class Test12 {

	public static void main(String[] args) {
		// int, flaot, double 형변환
		int kopo41_i = 91234567; //8자리 10진수
		float kopo41_f = (float)kopo41_i; //int를 float로 형변환
		int kopo41_i2 = (int)kopo41_f; // float를 다시 int형으로 형변환
		
		double kopo41_d = (double)kopo41_i; //int를 double형으로 형변환
		int kopo41_i3 = (int)kopo41_d; //double을 다시 int형으로 형변환
		
		float kopo41_f2 = 1.666f; // 실수형 변수
		int kopo41_i4 = (int)kopo41_f2; //실수형변수를 int형으로 형변환
		
		System.out.printf("i=%d\n",kopo41_i);
		System.out.printf("f=%f i2=%d\n",kopo41_f,kopo41_i2);
		System.out.printf("d=%f i3=%d\n",kopo41_d, kopo41_i3);
		System.out.printf("(int)%f=%d\n",kopo41_f2, kopo41_i4);
		

	}

}
