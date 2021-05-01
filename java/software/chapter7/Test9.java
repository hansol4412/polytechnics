package chapter7;

import java.util.ArrayList;

public class Test9 {
	//ArratList2 (최한솔)
	public static void main(String[] args) {
		int kopo41_iTestMax = 100; // 최댓값 초기화
		ArrayList kopo41_iAL = new ArrayList();
		
		for(int kopo41_i=0; kopo41_i<kopo41_iTestMax; kopo41_i++) {
			kopo41_iAL.add((int)(Math.random()*100));
			//0부터 1000000까지의 숫자 랜덤으로 받아 어레이리스트에 추가하기
		}
		
		for(int kopo41_i=0; kopo41_i<kopo41_iAL.size(); kopo41_i++) {
			System.out.printf("ArrayList %d = %s\n", kopo41_i,kopo41_iAL.get(kopo41_i));
			//어레이 리스트 값 확인하기
		}
		
		System.out.printf("---------------------------------\n");
		kopo41_iAL.sort(null); //어레이 리스트 정렬하기
		
		for(int kopo41_i=0; kopo41_i<kopo41_iAL.size(); kopo41_i++) {
			System.out.printf("ArrayList %d = %s\n", kopo41_i,kopo41_iAL.get(kopo41_i));
			//어레이 리스트 정렬한 값 확인하기
		}
	}

}
