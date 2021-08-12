package chapter4;

public class Factorial {

	public static void main(String[] args) {
		// 팩토리얼
		//1부터 100팩토리얼까지의 합을 구하여라
		
		long f = 1;
		long sum = 1;
		long n = 2;
		
		while(n<=100) {
			f = f*n;
			//System.out.println("f:"+f);
			sum = sum+f;
			//System.out.println("sum:"+sum);
			n=n+1;
		}
		System.out.println(sum);
	}
}
