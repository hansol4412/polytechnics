package chapter4;

public class Test9 {
	//숫자읽기 최한솔
	public static void main(String[] args) {
		String [] kopo41_units={"영","일","이","삼","사","오","육","칠","팔","구"};
		//각 자리의 숫자를 나타내기 위해 배열 선언
		for (int kopo41_i=0;kopo41_i< 101; kopo41_i++){
			//0부터 100까지 숫자 나타내기
			if(kopo41_i >= 0 && kopo41_i<10 ) {
				//0부터 9까지는 1의 자리
				System.out.printf("일의 자리 : %s\n",kopo41_units[kopo41_i]);
			} else if (kopo41_i >= 10 && kopo41_i < 100 ) {
				// 10부터 99까지는 10의 자리
				 int kopo41_i10, kopo41_i0;
				 kopo41_i10 = kopo41_i/10; //십의 자리 나타내기 위함, 10으로 나눈 몫
				 kopo41_i0 = kopo41_i%10; //일의 자리 나타내기 위함, 10으로 나눠서 나머지
				 if(kopo41_i0==0){
					System.out.printf("십의자리: %s십\n", kopo41_units[kopo41_i10]);
					//숫자를 한글로 바꾸기, 뒤에 일의 자리가 없다
					} else{
					System.out.printf("십의자리: %s십%s\n",kopo41_units[kopo41_i10], kopo41_units[kopo41_i0]);
					//숫자를 한글로 바꾸기, 뒤에 일의 자리가 있다.
				}
			} else System.out.printf("==> %d\n", kopo41_i);
			//100이되면 숫자로 나타내기
		}
	}
}
