package chapter7;

import java.util.ArrayList;

public class Test8 {
	// ArrayList를 정의, 추가, 변경, 삭제, 전부지움 실습 (최한솔)
	public static void main(String[] args) {
		ArrayList kopo41_iAL = new ArrayList();
		kopo41_iAL.add("abc");
		kopo41_iAL.add("abcd");
		kopo41_iAL.add("efga");
		kopo41_iAL.add("가나다0");
		kopo41_iAL.add("1234");
		kopo41_iAL.add("12가34");
		//kopo41_iAL.add(12가34); String으로 어레이리스트 만들었다가 정수형 삽입 불가
		
		System.out.printf("---------------------------\n");
		System.out.printf("시작 ArraySize %d \n",kopo41_iAL.size());
		for(int kopo41_i=0; kopo41_i<kopo41_iAL.size(); kopo41_i++) {
			System.out.printf("ArrayList %d = %s\n", kopo41_i,kopo41_iAL.get(kopo41_i));
			//어레이리스트 값 확인하기 => get()
		}
		
		kopo41_iAL.set(3, "가라라라"); // 3번 어레이리스트 내용 변경
		System.out.printf("---------------------------\n");
		System.out.printf("내용변경 ArraySize %d \n",kopo41_iAL.size());
		for(int kopo41_i=0; kopo41_i<kopo41_iAL.size(); kopo41_i++) {
			System.out.printf("ArrayList %d = %s\n", kopo41_i,kopo41_iAL.get(kopo41_i));
			//어레이리스트 값 확인하기 => get()
		}
		
		kopo41_iAL.remove(4); // 4번 어레이리스트 삭제
		System.out.printf("---------------------------\n");
		System.out.printf("내용삭제 ArraySize %d \n",kopo41_iAL.size());
		for(int kopo41_i=0; kopo41_i<kopo41_iAL.size(); kopo41_i++) {
			System.out.printf("ArrayList %d = %s\n", kopo41_i,kopo41_iAL.get(kopo41_i));
			//어레이리스트 값 확인하기 => get()
		}
		
		kopo41_iAL.sort(null); // 어레이 리스트 정렬
		System.out.printf("---------------------------\n");
		System.out.printf("리스트 정렬 ArraySize %d \n",kopo41_iAL.size());
		for(int kopo41_i=0; kopo41_i<kopo41_iAL.size(); kopo41_i++) {
			System.out.printf("ArrayList %d = %s\n", kopo41_i,kopo41_iAL.get(kopo41_i));
			//어레이리스트 값 확인하기 => get()
		}
		
		kopo41_iAL.clear();; // 어레이 리스트 초기화
		System.out.printf("---------------------------\n");
		System.out.printf("전부 삭제 ArraySize %d \n",kopo41_iAL.size());
		for(int kopo41_i=0; kopo41_i<kopo41_iAL.size(); kopo41_i++) {
			System.out.printf("ArrayList %d = %s\n", kopo41_i,kopo41_iAL.get(kopo41_i));
			//어레이리스트 값 확인하기 => get()
		}
	}
}
