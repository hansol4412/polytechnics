package chapter4;

public class Test13 {
	// 피라미드 찍기  최한솔
	public static void main(String[] args) {
		int kopo41_n, kopo41_m;
		kopo41_m=20; //빈칸 처음에 20개 찍기
		kopo41_n=1; // 별 처음에 1개 찍기
		while(true) {
			for (int kopo41_i=0; kopo41_i<kopo41_m; kopo41_i++) System.out.printf(" ");
			//0부터 kopo41_m까지 빈칸 찍기
			for (int kopo41_i=0; kopo41_i<kopo41_n; kopo41_i++) System.out.printf("*");
			//0부터 kopo41_n까지 별 찍기
			System.out.printf("\n"); //한줄 찍고 줄 넘기기
		
			kopo41_m=kopo41_m-1; //kopo41_m값 줄이기 => 빈칸 줄이기
			kopo41_n=kopo41_n+2; //kopo41_n값 늘리기 => *을 위에 줄보다 2개씩 추가
			if (kopo41_m<0) break; //빈칸이 0보다 작으면 반복문 끝내기
		}
	}

}
