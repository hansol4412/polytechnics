package chapter4;

public class Intersection2 {

	public static void main(String[] args) {
		//교행분수수열
		double sum = 0;
		double n = 1;
		double k;
		int sw = 1;
		while(n<=49) {
			k = n/((n+1)*(n+2));
			//System.out.println(k);
			if(sw==1) {
				sum = sum+k;
				System.out.print("+");
				sw=0;
			} else {
				sum = sum-k;
				System.out.print("-");
				sw=1;
			}
			System.out.println(n+"/("+(n+1)+"*"+(n+2)+") = "+sum);
			n=n+1;
		}
		System.out.println(sum);

	}

}
