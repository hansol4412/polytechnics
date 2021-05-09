package chapter2;

public class Test10 {
	//byte, int 형변환
	public static void main(String[] args) {
		int kopo41_i = 10; //int형 변수 초기화
		byte kopo41_b = (byte)kopo41_i; //byte형 변수를 선언하고 kopo41_i를 byte형으로 형변환한다.
		System.out.printf("[int -> byte] i=%d -> b=%d\n",kopo41_i,kopo41_b); //i와 b 출력해 확인
		
		kopo41_i = 300; //int형 변수 변경
		kopo41_b = (byte)kopo41_i; //int형 변수 초기화
		System.out.printf("[int -> byte] i=%d -> b=%d\n",kopo41_i,kopo41_b);
		//byte의 최댓값은 127이어서 그것을 넘는 수를 넣었을 때 올바른 값이 나오지 않는다
		
		kopo41_b = 10; //b변수 변경
		kopo41_i = (int)kopo41_b; //바이트형 변수 b를 int형으로 변환
		System.out.printf("[byte -> int] i=%d -> b=%d\n",kopo41_b,kopo41_i);
		//문제 없이 출력
		
		kopo41_b = -2;
		kopo41_i = (int)kopo41_b;
		System.out.printf("[byte -> int] i=%d -> b=%d\n",kopo41_b,kopo41_i);
		//문제 없이 출력
		
		System.out.println("i="+Integer.toBinaryString(kopo41_i));
		//int형 10진수 변수를 2진수로 출력 , 음수 값은 1로 시작
		
	}

}
