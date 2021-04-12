package test;

import java.util.Scanner;

public class A4 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		int num = std.nextInt();
		int[] a = new int[num];
		
		for(int i=0; i<num; i++) {
			a[i] = std.nextInt();
		}
		
		int sum=0;
		float avg=0;
		int min=100;
		int max=0;
		
		int i=0;
		while(i<num) {
			sum+=a[i];
			if(a[i]<min) min=a[i];
			if(a[i]>max) max=a[i];
			i++;
		}
		avg= Math.round((float)sum/a.length);
		System.out.println("sum : "+sum);
		System.out.println("avg : "+avg);
		System.out.println("min : "+min);
		System.out.println("max : "+max);
		

	}

}

