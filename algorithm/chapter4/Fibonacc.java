package chapter4;

public class Fibonacc {

	public static void main(String[] args) {
		// 피보나치 수열
		//100번째 항의 합
		
		long a = 1;
		long b = 1;
		long sum = a+b;
		long n = 3;
		
		while(n<=100) {
			n= n+1;
			long c = a + b;
			//System.out.println("c:"+c);
			sum = sum + c;
			//System.out.println("sum:"+sum);
			a = b;
			b = c;	
		}
		System.out.println(sum);
	}

}
