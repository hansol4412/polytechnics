package chapter4;

public class Ex3 {
	// for문 예졔 최한솔
	public static void main(String[] args) {
		// 기본 for문
		int kopo41_sum=0;
		for(int i=0; i<10; i++) { //i는 0부터 9까지 1씩 증가한다.
			kopo41_sum= kopo41_sum+i;
			//kopo41_sum에 i값을 누적으로 더한다.
		}
		System.out.printf("sum %d\n", kopo41_sum); //kopo41_sum 출력
		
		
		//복합 for문
		for (int kopo41_i=1;kopo41_i<10; kopo41_i++) { // i는 1부터 9까지 1씩 증가한다.
			System.out.printf("************************\n"); 
			System.out.printf(" 구구단 %d \n", kopo41_i); // 몇단인지 변수 i를 이용해서 출력
			System.out.printf("************************\n"); 
			for (int kopo41_j=1; kopo41_j<10; kopo41_j++){ //j는 1부터 9까지 1씩 증가한다.
				System.out.printf(" %d * %d = %d \n", kopo41_i, kopo41_j,kopo41_i*kopo41_j);
				// 이중 for문을 이용해서 구구단을 출력한다
				// 한번의 i에 9번의 j가 돈다.
			}
		}
	}
}
