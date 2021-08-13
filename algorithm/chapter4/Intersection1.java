package chapter4;

public class Intersection1 {

	public static void main(String[] args) {
		//+, - 교행수열
		// 0+1-2=3-2 + ... +99-100을 구하시오
		
		int n=0;
		int sum =0;
		
		while(n<100) {
			n=n+1;
			sum = sum+n;
			System.out.print("+"+n);
			n=n+1;
			sum = sum-n;
			System.out.print("-"+n);
		}
		System.out.println("=");
		System.out.println(sum);
	}
}
