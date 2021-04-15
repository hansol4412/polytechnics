package chapter4;

public class Test8 {
	// Array이용 비교 최한솔
	public static void main(String[] args) {
		int [] kopo41_iLMD ={31,28,31,30,31,30,31,31,30,31,30,31}; 
		// 단 배열은 0부터 시작한다는 것에 유의 
		// 1월부터 12월까지 막날을 배열로 생성
		for(int kopo41_i=1;kopo41_i<13;kopo41_i++){ //1월부터 12월까지
			System.out.printf("%d월=>", kopo41_i); //몇 월인지 알려주기
			for (int kopo41_j=1;kopo41_j<32; kopo41_j++){ 
				 // 일을 출력하기 위해 1부터 31까지 출력하기
				System.out.printf("%d",kopo41_j);
				if(kopo41_iLMD[kopo41_i-1]==kopo41_j) break;
				// 배열의 kopo41_i-1번째 인덱스 값이 kopo41_j에 같을 때 반복문 빠져나가기
				System.out.printf(","); 
				//마지막일 콤마 안찍기위해 
				//반복문을 빠져나가는 마지막 날에는 콤마를 찍지 않는다.
			}
			System.out.printf("\n");
		}
	}
}
