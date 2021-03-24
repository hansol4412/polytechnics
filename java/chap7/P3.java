package chapter7;

import java.util.ArrayList;
import java.util.Scanner;

public class P3 {

	public static void main(String[] args) {
		//Fibonacci Numbers (Array)
		
		Scanner stdIn = new Scanner(System.in);
		try{
			System.out.print("input:");
			int n = stdIn.nextInt();
			
			if(n<0) {
				n=n*(-1);
			}
			
			int[] a= new int[n];
			
			if(n>0) {
				int one = 0;
				int two = 1;
				int result;
				if(n==1) {
					a[0]=0;
				} else if(n==2) {
					a[0]=0;
					a[1]=1;
				} else {
					a[0]=0;
					a[1]=1;
					for (int i =2; i<n; i++) {
						a[i] = a[i-1]+a[i-2];
					}
				}
			} else {
				System.out.println("wrong input!!");
			}
			
			for(int i =0; i<n; i++) {
				System.out.println(a[i]);
			}
		}catch(Exception e) {
			System.out.println("error");
		}
		

	}

}
