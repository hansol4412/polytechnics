package chapter4;

public class Test12 {
	//sin함수 그래프 (최한솔)
	public static void main(String[] args) {
		double kopo41_fSin;
		for(int kopo41_i=0; kopo41_i<360; kopo41_i++) { //0도 부터 360도 까지
			kopo41_fSin= Math.sin(kopo41_i * 3.141592/180); 
			// Math 클래스의 sin함수를 사용해 sin값 구하기
			// sin값은 -1부터 1까지의 값 사이를 가진다.
			System.out.printf("%d sin ==>%f\n", kopo41_i, kopo41_fSin);
			//각에 따른 sin값을 확인하기 위해 출력한다.
		}
			 
		for(int kopo41_i=0; kopo41_i<360; kopo41_i++) { //0도 부터 360도까지
			kopo41_fSin = Math.sin(kopo41_i * 3.141592/180);
			// Math 클래스의 sin함수를 사용해 sin값 구하기
			// sin값은 -1부터 1까지의 값 사이를 가진다.
			int kopo41_iSpace = (int)((1.0-kopo41_fSin) *50);
			//-1부터 1 사이의 값을 가지는 sin값을 양수화 하면 0에서 2사이의 값이 나오는데
			//여기서 50을 곱해 1부터 100까지 사이의 수가 나오도록 한다.
			for (int kopo41_j=0; kopo41_j<kopo41_iSpace; kopo41_j++) {
				 System.out.printf(" ");
				 //1부터 100까지 나온 수를 가지고 그 값에 따라 띄어쓰기를 출력한다
			}
			System.out.printf("*[%f] [%d]\n", kopo41_fSin, kopo41_iSpace);
			//각도에 대한 원래 사인값과 변환한 사인 값을 출력한다.
		}
	}
}
