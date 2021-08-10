package chapter4;

public class geometricProgression {

	public static void main(String[] args) {
		//등비수열
		//첫째항은 2, 공비는 3, 100번째 항까지의 합을 구하여라.
		
		long r = 3; //공비
		long a = 2; //첫째항
		long sum = 0;
		sum = sum+a;
		
		for(int n= 2; n<=100; n++) {
			a = a*r;
			//System.out.println("a"+n+":"+a);
			sum = sum + a;
			//System.out.println("sum"+n+":"+sum);
		}
		System.out.println(sum);
	}

}
