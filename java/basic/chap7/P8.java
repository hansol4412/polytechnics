package chapter7;

import java.util.ArrayList;
import java.util.Scanner;

public class P8 {

	public static void main(String[] args) {
		// 배수 구하기
		ArrayList<Double> a = new ArrayList<Double>();
		Scanner std = new Scanner(System.in);
		try {
			System.out.println("list:");
			String str = std.nextLine();
			System.out.println("number:");
			double n = std.nextDouble();
			String[] temp = str.split(" ");
			double[] num = new double[str.length()]; 
			
			for(int i =0; i<temp.length; i++) {
				num[i] = Double.parseDouble(temp[i]);
				if(num[i]%n==0) {
					a.add(num[i]);
				}
			}
			
			System.out.println(a);
		} catch(Exception e) {
			System.out.println("error");
		}

	}

}
