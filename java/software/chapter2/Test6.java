package chapter2;

public class Test6 {
	// 변수출력 실습
	public static void main(String[] args) {
		byte kpoo41_b = 1; //byte형 변수
		short kopo41_s = 2; //short형 변수
		char kopo41_c = 'A'; //char형 변수
		
		int kopo41_finger = 10; // int형 변수
		long kopo41_big = 100000000000L; //long형 변수 (10진수)
		long kopo41_hex = 0xFFFFFFFFFFFFFFFL; // long형 변수 (16진수)
		
		int kopo41_octNum = 010; //int형 8진수 변수
		int kopo41_hexNum = 0x10; //int형 16진수 변수
		int kopo41_binNum = 0b10; //int형 2진수 변수
		
		System.out.printf("b=%d\n",kpoo41_b); //byte형 변수 출력 (10진수)
		System.out.printf("s=%d\n",kopo41_s); // short형 변수 출력 (10진수)
		System.out.printf("c=%c, %d \n",kopo41_c, (int)kopo41_c); // char형 문자 변수, char형 문자를 정수로 변환
		System.out.printf("finger=[%5d]\n", kopo41_finger); //왼쩍 정렬
		System.out.printf("finger=[%-5d]\n", kopo41_finger); //오른쪽 정랼
		System.out.printf("finger=[%05d]\n", kopo41_finger); //왼족 정렬, 빈칸에 0넣기
		System.out.printf("big=%d\n", kopo41_big); //long형 변수 (10진수) 출력
		System.out.printf("hex=%#x\n", kopo41_hex); ///long형 변수 (16진수) 출력
		System.out.printf("octNum=%o, %d\n", kopo41_octNum, kopo41_octNum); 
		//8진수 출력, 8진수 10진수로 변환해 출력
		System.out.printf("hexNum=%x, %d\n", kopo41_hexNum, kopo41_hexNum); 
		//16진수 출력, 16진수 10진수로 변환햐 출력
		System.out.printf("binNum=%s, %d\n", Integer.toBinaryString(kopo41_binNum), kopo41_binNum); 
		//2진수 출력, 2진수 10진수로 변환해 출력

	}

}
