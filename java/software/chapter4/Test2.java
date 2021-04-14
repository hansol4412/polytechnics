package chapter4;

public class Test2 {
	// 숫자형, 문자형 비교  최한솔
	public static void main(String[] args) {
		int kopo41_il;
		double kopo41_iD;
			kopo41_il= 10/3; //3 (정수형)
			kopo41_iD= 10/3.0; //3.33333333... (실수형)
			if (kopo41_il==kopo41_iD) System.out.printf("equal\n"); //kopo41_il와 kopo41_iD가 같으면 출력
			else System.out.printf("Not equal [%f][%f]\n", (double)kopo41_il, kopo41_iD); 
			//kopo41_il와 kopo41_iD가 다르면 출력
			
			// 단지 유효숫자까지 표시된 것 뿐이지 다르다. 
			if (kopo41_iD==3.333333) System.out.printf("equal\n"); 
			else System.out.printf("Not equal [3.333333][%f]\n", kopo41_iD);
			//3.333333과 3.333333...은 다르다.
			
			kopo41_iD= (int)kopo41_iD; //kopo41_iD을 정수형으로 강제 형변환하면 3, kopo41_iD은 3
			if (kopo41_il == kopo41_iD) System.out.printf("equal\n"); //뒤에 소숫점이 있을 뿐 둘은 같다.
			else System.out.printf("Not equal [%f][%f]\n", (double)kopo41_il, kopo41_iD); 
			
			System.out.printf("int로 인쇄 [%d] [%f] \n", kopo41_il, kopo41_iD); 
			//int형은 출력하면 뒤에 소숫점은 없앤다.
			System.out.printf("double로 인쇄 [%f][%f]\n", (double)kopo41_il, kopo41_iD);
			//double로 출력하면 뒤의 소숫점도 같이 출력
				
			char a='c'; //문자(char)비교
			if (a=='b')System.out.printf("a는 b이다 \n"); 
			if (a=='c')System.out.printf("a는 c이다 \n"); //출력 O
			if (a=='d')System.out.printf("a는 d이다 \n");
			
			String aa="abcd"; //문자열 변수 aa
			if(aa.equals("abcd")) System.out.printf("aa는 abcd이다 \n"); //문자열 비교는 ==이 아닌 equals를 사용
			else System.out.printf("aa abcd이 아니다\n");
			
			boolean bb=true; // 참 거짓 비교
			if(!!bb) System.out.printf("bb가 아니고 아니면 참이다. \n");  // !참 = 거짓,  !(!참) = 참
			else System.out.printf("bb가 아니고 아니면 거짓이다. \n");
	}
}