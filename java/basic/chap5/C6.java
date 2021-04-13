package test;

public class C6 implements Statistics{

	public static void main(String[] args) {
		C6 a6 = new C6();
		double[] numbers = {1.2, 3.2, 5.2, 12,3, 45.0, -3.4, -6.7};
		
		System.out.println("Max : "+a6.getMaxNumber(numbers));
		System.out.println("Min : "+a6.getMinNumber(numbers));
	}
	
	@Override
	public double getMaxNumber(double[] numbers) {
		double max = -100;
		for (int i=0; i<numbers.length; i++) {
			if(numbers[i]>max) max= numbers[i]; 
		}
		return max;
	}
	
	@Override
	public double getMinNumber(double[] numbers) {
		double min = 100;
		for (int i=0; i<numbers.length; i++) {
			if(numbers[i]<min) min= numbers[i];
		}
		return min;
	}

}
