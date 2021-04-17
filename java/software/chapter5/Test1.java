package chapter5;

public class Test1 {
	// 구구단 인쇄 최한솔
	public static void main(String[] args) {
		for(int kopo41_i=1; kopo41_i<10; kopo41_i=kopo41_i+3) {
			// 처음 줄의 시작 1단, 4단, 7단
			System.out.printf("*************\t*************\t*************\n");
			System.out.printf("구 구 단 %d 단\t 구 구 단 %d 단\t 구 구 단 %d 단\n",kopo41_i,kopo41_i+1, kopo41_i+2 );
			// 세 단씩 한줄로 보여주기 위해 형식 맞추기 (1단, 2단, 3단) (4단, 5단, 6단), (7단, 8단, 9단)
			System.out.printf("*************\t*************\t*************\n");
			for(int kopo41_j=1; kopo41_j<10; kopo41_j++) {
			//단마다 구구단 출력
			System.out.printf("%d * %d = %d\t %d * %d = %d\t %d * %d = %d\n",
					kopo41_i,kopo41_j,kopo41_i*kopo41_j,kopo41_i+1,kopo41_j,(kopo41_i+1)*kopo41_j,kopo41_i+2,kopo41_j,(kopo41_i+2)*kopo41_j );
			}
		}

	}

}
