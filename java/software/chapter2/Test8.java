package chapter2;

public class Test8 {
	// 변수출력          실습3 (최한솔)
	public static void main(String[] args) {
		short kopo41_sMin = -32768; //short의 최솟값
		short kopo41_sMax = 32767; //short의 최댓값
		char kopo41_cMin = 0; // char의 최솟값
		char kopo41_cMax = 65535; // char의 최댓값
		
		System.out.println("sMin = " + kopo41_sMin); //sMin 출력
		System.out.println("sMin -1 = " + (short)(kopo41_sMin-1)); 
		//sMin-1출력, 최솟값보다 작아져서 short의 최댓값 32767을 출력한다(순환)
		System.out.println("sMax = " + kopo41_sMax); //sMax값 출력
		System.out.println("sMax +1 = " + (short)(kopo41_sMax+1));
		//sMax+1출력, 최댓값보다 커져서 short의 최솟값 -32768을 출력한다(순환)
		System.out.println("cMin = " + (int)(kopo41_cMin)); // char의 최솟값 0 (음수x)
		System.out.println("cMin-1 = " + (int)(--kopo41_cMin)); // char의 최솟값보다 작아져서 최댓값 출력
		System.out.println("cMan = " + (int)(kopo41_cMax)); //char의 최댓값 65535
		System.out.println("cMax+1 = "+ (int)++kopo41_cMax); //char의 최댓값보다 커져서 최솟값 출력
	}

}
