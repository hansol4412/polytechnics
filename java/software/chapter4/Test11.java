package chapter4;

public class Test11 {
	//띄어쓰기 연습 최한솔
	public static void main(String[] args) {
		for(int kopo41_i=0; kopo41_i<10; kopo41_i++) { 
		// 0부터 9까지 숫자 출력
			for(int kopo41_j=0 ; kopo41_j<kopo41_i; kopo41_j++) {
			// kopo41_j는 kopo41_i보다 작을 때만 돌아간다.
				System.out.printf(" "); 
				//j의 수만큼 빈칸을 출력한다
			}
			System.out.printf("%d\n",kopo41_i); //다음 줄로
		}
	}
}
