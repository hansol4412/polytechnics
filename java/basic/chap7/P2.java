package chapter7;

import java.util.Arrays;
import java.util.Scanner;

public class P2 {
	public static void main(String[] args) {
		//Exception Handling (index out of array)
		Scanner std = new Scanner(System.in);
		
		System.out.print("input n:");
		int n = std.nextInt();
		std.nextLine(); 
		System.out.print("input numbers:");
		String nums = std.nextLine();
		
		String[] temp = nums.split(" ");
		int[] a = new int[n];
		
		
		try {
			for(int i=0; i<temp.length; i++) {
				a[i] = Integer.parseInt(temp[i]);
			}
			
		} catch(Exception e) {
			System.out.println("error");
			System.exit(0);
		}
		Arrays.sort(a);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}

}
