package chapter4;

public class Test3 {
	// 범위값 찾기 (최한솔)
	public static void main(String[] args) {
		int kopo41_iVal; 
		for(int kopo41_i=0; kopo41_i< 300; kopo41_i++){ //kopo41_i가 0부터 300 전까지 1씩 증가
			kopo41_iVal = 5 * kopo41_i; // kopo41_iVal은 kopo41_i에 5를 곱한다.
			if(kopo41_iVal >= 0 && kopo41_iVal<10 ) System.out.printf("일%d\n", kopo41_iVal);
			// kopo41_iVal이 0보다 크고 10보다 작으면 일의 자리
			else if (kopo41_iVal >= 10 && kopo41_iVal<100) System.out.printf("십%d\n", kopo41_iVal);
			// kopo41_iVal이 10보다 크고 100보다 작으면 십의 자리
			else if (kopo41_iVal >= 100 && kopo41_iVal<1000) System.out.printf("백%d\n", kopo41_iVal); 
			// kopo41_iVal이 100보다 크고 1000보다 작으면 백의 자리
			else System.out.printf("천 %d\n", kopo41_iVal);
			//위의 조건에 모두 충족하지 않으면 천의 자리
		}
	}

}
