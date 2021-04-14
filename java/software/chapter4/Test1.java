package chapter4;

public class Test1 {
	// 이중 while문 최한솔
	public static void main(String[] args) {
		int kopo41_iA, kopo41_iB; //변수 선언
		kopo41_iA=0; //kopo41_iA 초기값 0
		while(true){
			kopo41_iB=0; //kopo41_iB 초기값 0
			while(true) {
				System.out.printf("*"); 
				if(kopo41_iA==kopo41_iB) break; 
				//kopo41_iA와 //kopo41_iB값이 같으면 안쪽 while문 나가기
				kopo41_iB++; // 안쪽 반복문 돌 때 마다 kopo41_iB값 증가시키기
			}
			System.out.printf("\n"); // 줄바꾸기
			kopo41_iA++; //바깥쪽 반복문 돌 때 마다 kopo41_iA값 증가시키기
			if(kopo41_iA==30) break; //kopo41_iA이 30이 되면 바깥쪽 반복문 나가기
		}
	}

}
