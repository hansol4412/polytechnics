package test;

public class A5 extends Thread{
	// 0.5초 마다 1~20사이의 수를 랜덤으로 받아 평균과 최댓값, 최솟값을 구하시오.
	public static void main(String[] args) throws InterruptedException{
		Thread thread1 = new Number();
		thread1.start();
	}
}
class Number extends Thread{
	public static double[][] number = new double[11][5];
	public static int cnt=0;
	public void run(){

		try {
			for(int i=0; i<10; i++) {
				double n = (Math.random()*20)+1;
				number[i][0]  = n;
				sum();
				avg();
				min();
				max();
				cnt++;
				System.out.println(n);
				System.out.println("count-"+cnt+" sum-"+number[i][1]+" avg-"+number[i][2]+" min-"+number[i][3]+" max-"+number[i][4]);

				Thread.sleep(500);
			}
		}catch(InterruptedException e) {
			System.out.println("error");
		}
		
	}
	
	public static void sum() {
		double sum = 0;
		for(int i=0; i<=cnt; i++) {
			sum+=number[i][0];
		}
		number[cnt][1]=sum;
	}
	
	public static void avg() {
		double avg = number[cnt][1]/cnt;
		number[cnt][2]= avg;
	}
	
	public static void min() {
		double min = 10000000d;
		for(int i=0; i<=cnt; i++) {
			if(min>number[i][0]) {
				min = number[i][0];
			}
		}
		number[cnt][3]= min;
	}
	
	public static void max() {
		double max = 0;
		for(int i=0; i<=cnt; i++) {
			if(max<number[i][0]) {
				max = number[i][0];
			}
		}
		number[cnt][4]= max;
	}
}
