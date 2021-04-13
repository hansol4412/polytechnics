package test;

import java.util.Scanner;

public class B3 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		System.out.print("input number:");
		String n = std.nextLine();
		String[] temp = n.split(" ");
		
		double sum=0;
		double min=100000;
		double max=0;
		for(int i=0;i<temp.length; i++) {
			sum+=Double.parseDouble(temp[i]);
			if(Double.parseDouble(temp[i])<min) min = Double.parseDouble(temp[i]);
			if(Double.parseDouble(temp[i])>max) max = Double.parseDouble(temp[i]);
		}
		double avg = sum/4;
		System.out.printf("Summation : %.2f\n",sum);
		System.out.printf("Average : %.4f\n",avg);
		System.out.printf("Minimum : %.2f\n",min);
		System.out.printf("Maximum : %.2f\n",max);
		
		
		
	
		

	}

}
