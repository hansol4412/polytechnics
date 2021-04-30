package chapter7;

public class Test6 {
	// 배열의 최대, 최소값 찾기 (최한솔0
	public static void main(String[] args) {
		int [] kopo41_iArray= {1,7,5,3,2,1,3,4,9,12,1,212,33,11,21,11,2121,121,11,5,6,33};
		// 숫자들을 배열로 지정한다.
		
		//배열 목록 확인화기
		for(int kopo41_i=0; kopo41_i<kopo41_iArray.length; kopo41_i++) {
			System.out.printf("kopo41_iArray[%d]=%d\n",kopo41_i,kopo41_iArray[kopo41_i] );
		}
		
		int kopo41_iMax = kopo41_iArray[0]; // 처음 시작 배열 값 max값 지정
		int kopo41_iMaxPt = 0; // 최댓값이 배열의 몇번째 위치하고 있는지 확인하기 위한 변수
		
		//반복문을 돌면서
		for(int kopo41_i=0; kopo41_i<kopo41_iArray.length; kopo41_i++) {
			//max값보다 다음 배열의 값이 크다면
			if(kopo41_iMax<kopo41_iArray[kopo41_i]) {
				kopo41_iMax= kopo41_iArray[kopo41_i]; //max값에 배열 지정
				kopo41_iMaxPt = kopo41_i; // 최댓값의 배열 인덱스 번호도 바꾼다
			}
		}
		
		//최댓값 출력
		System.out.printf("MAX : kopo41_iArray[%d]=%d\n",kopo41_iMaxPt, kopo41_iMax);
	}

}
